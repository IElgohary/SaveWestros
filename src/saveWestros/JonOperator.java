package saveWestros;

import genericSearch.Node;
import genericSearch.Operator;

public class JonOperator extends Operator{
	
	public int dx, dy;
	boolean attack, pick;

	public JonOperator(String name, int cost, int dx, int dy, boolean attack, boolean pick) {
		super(name, cost);
		this.dx = dx;
		this.dy = dy;
		this.attack = attack;
		this.pick = pick;
	}


	@Override
	public Node run(Node node) {
		WestrosState state = (WestrosState) node.state;
		char[][] grid = state.grid;
		int newX = state.cell.x + dx;
		int newY = state.cell.y + dy;
//		Validate Location 
		if(!isValidCell(grid, newX, newY)) return null;
// 		If Action is attacking walker, validate that walkers are around
		if(attack) {
			int walkersAround = walkersAround(grid,newX, newY);
			if (walkersAround < 0) return null;
		}
//		If Action is Picking DragonGlass, Validate that cell has DragonGlass
		if(pick) {
			if(grid[newX][newY] != SaveWestros.JON_ON_DRAGONGLASS) return null;
		}
//		If move is valid, construct new state
		
		
		return null;
	}

	private WestrosState newState(WestrosState state, int newX, int newY) {
		Cell newCell = new Cell(newX,newY);
		Cell oldCell = state.cell;
		char[][] grid = state.grid;
		char[][] newGrid = new char[grid.length][grid[0].length];
		int dragonGlass = state.dragonGlass, whiteWalkersLeft = state.whiteWalkersLeft;
		
		for (int i = 0 ; i < grid.length ; i++) {
			for (int j = 0 ; j < grid[0].length; j++) {
				newGrid[i][j] = grid[i][j];
				if(i == newX && j == newY) {
					if(grid[i][j] == SaveWestros.EMPTY_CELL) newGrid[i][j] = SaveWestros.JON_SNOW;
					if(grid[i][j] == SaveWestros.DRAGONGLASS) newGrid[i][j] = SaveWestros.JON_ON_DRAGONGLASS;
				} else if(grid[i][j] == SaveWestros.WHITE_WALKER) {
					if(attack && attackedWalker(newX,newY, i, j)) {
						newGrid[i][j] = SaveWestros.EMPTY_CELL;
					}
				} else if(oldCell.x == i && oldCell.y == j) {
					if(grid[i][j] == SaveWestros.JON_SNOW) newGrid[i][j] = SaveWestros.EMPTY_CELL;
					if(grid[i][j] == SaveWestros.JON_ON_DRAGONGLASS) newGrid[i][j] = SaveWestros.DRAGONGLASS;
				}
			}
		}
		return new WestrosState(newCell, dragonGlass, whiteWalkersLeft, newGrid);
	}

	private boolean attackedWalker(int x, int y, int i, int j) {
		if(Math.abs(x-i) <= 1 && Math.abs(y-j) <= 1) return true;
		return false;
	}


	private int walkersAround(char[][] grid, int x, int y) {
		int walkers = 0;
		if(grid[x-1][y] == SaveWestros.WHITE_WALKER) walkers++;
		if(grid[x+1][y] == SaveWestros.WHITE_WALKER) walkers++;
		if(grid[x][y+1] == SaveWestros.WHITE_WALKER) walkers++;
		if(grid[x][y-1] == SaveWestros.WHITE_WALKER) walkers++;
		return walkers;
	}


	private boolean isValidCell(char[][] grid, int x, int y) {
//		Stay inside the grid
		if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length )
			return false;
//		Can't move to cells with obstacles
		if(grid[x][y] == SaveWestros.OBSTACLE) return false;
//		Can't Move to cell with a living Walker
		if(grid[x][y] == SaveWestros.WHITE_WALKER) return false;
		return true;
	}
	
	

}
