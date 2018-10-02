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
	
}
