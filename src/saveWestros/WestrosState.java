package saveWestros;

import genericSearch.State;

public class WestrosState extends State{
	public Cell cell;
	public int dragonGlass;
	public int whiteWalkersLeft;
	char[][] grid;
	
	public WestrosState(Cell cell, int dragonGlass, int whiteWalkersLeft, char[][] grid) {
		this.cell = cell;
		this.dragonGlass = dragonGlass;
		this.whiteWalkersLeft = whiteWalkersLeft;
		this.grid = grid;
		
	}

	public int compareTo(State o) {
		
		char[][] oGrid = ((WestrosState)o).grid;
		int ww = whiteWalkersLeft -((WestrosState) o).whiteWalkersLeft;
		if(ww != 0)
			return ww;
		int dg = dragonGlass - ((WestrosState) o).dragonGlass;
		if(dg != 0)
			return dg;
		
		for(int i = 0; i < grid.length; ++i)
			for(int j = 0; j < grid[0].length; ++j){
				if(grid[i][j] != oGrid[i][j]){
					return grid[i][j] - oGrid[i][j];
				}
			}
		return 0;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Dragon Glass: ").append(dragonGlass).append("\n");
		sb.append("White Walkers: ").append(whiteWalkersLeft).append("\n");
		for(char[] row: grid){
			sb.append(row).append("\n");
		}
		return sb.toString();
	}
	
}
