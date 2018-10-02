package saveWestros;
import java.util.ArrayList;

import genericSearch.Problem;
import genericSearch.State;

public class SaveWestros extends Problem{
	public int n,m;
	public char[][] grid;
	
	public static final char WHITE_WALKER = 'w', EMPTY_CELL = '.', OBSTACLE = 'o', JON_SNOW = 'j';
			
	

	public SaveWestros(int n, int m) {
		super();
		this.n = n;
		this.m = m;
		generateGrid();
		initializeOperators();
	}



	private void initializeOperators() {
		// TODO Auto-generated method stub
		
	}



	private void generateGrid() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean goal(State state) {
		WestrosState westrosState = (WestrosState) state;
		if(westrosState.whiteWalkersLeft == 0) return true;
		return false;
	}
	

}
