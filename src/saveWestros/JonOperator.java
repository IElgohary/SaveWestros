package saveWestros;

import java.util.Arrays;

import genericSearch.Node;
import genericSearch.Operator;

public class JonOperator extends Operator{
	
	public int dx, dy;
	boolean attack, pick;
	final int maxDragonGlass = 10;
	
	/**
	 * @param name name of the action
	 * @param cost cost of the action
	 * @param dx,dy The change in location that this action does
	 * @param attack whether the action is to attack walkers
	 * @param pick whether the action is to pick dragonglass
	 */
	public JonOperator(String name, int cost, int dx, int dy, boolean attack, boolean pick) {
		super(name, cost);
		this.dx = dx;
		this.dy = dy;
		this.attack = attack;
		this.pick = pick;
	}

	/**
	 * @param node the node to apply the action to
	 * @return Node node after applying the action
	 */
	@Override
	public Node run(Node node) {
		WestrosState state = (WestrosState) node.state;
		char[][] grid = state.grid;
		int newX = state.cell.x + dx;
		int newY = state.cell.y + dy;
		int dragonGlass = state.dragonGlass;
//		Validate Location 
		if(!isValidCell(grid, newX, newY)) return null;
// 		If Action is attacking walker, validate that walkers are around
		if(attack) {
			int walkersAround = walkersAround(grid,newX, newY);
			if (walkersAround <= 0 || dragonGlass == 0) return null;
			if(walkersAround > 0){
				dragonGlass--;
			}
		}
//		If Action is Picking DragonGlass, Validate that cell has DragonGlass
		if(pick) {
			
			if(grid[newX][newY] != SaveWestros.JON_ON_DRAGONGLASS || dragonGlass == maxDragonGlass) return null;
			dragonGlass = maxDragonGlass;
		}
//		If move is valid, construct new state
		WestrosState newState = newState(state, newX, newY, dragonGlass);
		return new Node(newState, node, this);
	}
	
	/**
	 * @param state the old state before the action is applied
	 * @param newX,newY The coordinates of the new Location
	 * @param dragonGlass the number of dragon glass Jon has in the new state
	 * @return WestrosState the new State after the action is applied
	 */
	private WestrosState newState(WestrosState state, int newX, int newY, int dragonGlass) {
		Cell newCell = new Cell(newX,newY);
		Cell oldCell = state.cell;
		char[][] grid = state.grid;
		char[][] newGrid = new char[grid.length][grid[0].length];
		int whiteWalkersLeft = state.whiteWalkersLeft;
		
		for (int i = 0 ; i < grid.length ; i++) {
			for (int j = 0 ; j < grid[0].length; j++) {
				if(i == newX && j == newY) {
					if(grid[i][j] == SaveWestros.EMPTY_CELL) 
						newGrid[i][j] = SaveWestros.JON_SNOW;
					else if(grid[i][j] == SaveWestros.DRAGONGLASS)
							newGrid[i][j] = SaveWestros.JON_ON_DRAGONGLASS;
						else
							newGrid[i][j] = grid[i][j];
					
				} else if(grid[i][j] == SaveWestros.WHITE_WALKER) {
					if(attack && attackedWalker(newX,newY, i, j)) {
						newGrid[i][j] = SaveWestros.EMPTY_CELL;
						whiteWalkersLeft--;
					}else {
						newGrid[i][j] = grid[i][j];
					}
				} else if(oldCell.x == i && oldCell.y == j) {
					if(grid[i][j] == SaveWestros.JON_SNOW)
						newGrid[i][j] = SaveWestros.EMPTY_CELL;
					else if(grid[i][j] == SaveWestros.JON_ON_DRAGONGLASS)
						newGrid[i][j] = SaveWestros.DRAGONGLASS;
					else
						newGrid[i][j] = grid[i][j];
				} else {
					newGrid[i][j] = grid[i][j];
				}
				
			}
		}
		
		return new WestrosState(newCell, dragonGlass, whiteWalkersLeft, newGrid);
	}

	/**
	 * @param x,y The coordinates of Jon Snow
	 * @param i,j the coordinates of the Walker
	 * @return boolean whether the walker was attacked by Jon 
	 */
	private boolean attackedWalker(int x, int y, int i, int j) {
		if(Math.abs(x-i) == 0 && Math.abs(y-j) == 1 ||
			Math.abs(x-i) == 1 && Math.abs(y-j) == 0) return true;
		return false;
	}

	/**
	 * @param grid The grid of the source state
	 * @param x,y The coordinates of the new Location
	 * @return boolean whether there are walkers around the new location
	 */
	private int walkersAround(char[][] grid, int x, int y) {
		int walkers = 0;
		if(isValidWhiteWalker(grid, x-1, y) && grid[x-1][y] == SaveWestros.WHITE_WALKER) walkers++;
		if(isValidWhiteWalker(grid, x+1, y) && grid[x+1][y] == SaveWestros.WHITE_WALKER) walkers++;
		if(isValidWhiteWalker(grid, x, y+1) && grid[x][y+1] == SaveWestros.WHITE_WALKER) walkers++;
		if(isValidWhiteWalker(grid, x, y-1) && grid[x][y-1] == SaveWestros.WHITE_WALKER) walkers++;

		return walkers;
	}

	/**
	 * @param grid The grid of the source state
	 * @param x,y The coordinates of the new Location
	 * @return boolean whether the cell is a valid move
	 */
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
	
	/**
	 * check if a cell is within the grid and is not an obstacle
	 * @param grid
	 * @param x,y coordinates of the cell
	 * @return boolean whether the cell is within the grid and not an obstacle
	 */
	private boolean isValidWhiteWalker(char[][] grid, int x, int y) {
//		Stay inside the grid
		if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length )
			return false;
//		Can't move to cells with obstacles
		if(grid[x][y] == SaveWestros.OBSTACLE) return false;
		return true;
	}
	
	

}
