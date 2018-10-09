package saveWestros;
import java.util.ArrayList;

import genericSearch.Operator;
import genericSearch.Problem;
import genericSearch.State;

public class SaveWestros extends Problem{
	public int n,m;
	public char[][] grid;
	
	public static final char WHITE_WALKER = 'w', EMPTY_CELL = '.',
			OBSTACLE = 'o', JON_SNOW = 'j', DRAGONGLASS = 'd',
			JON_ON_DRAGONGLASS = '@';
			
	

	public SaveWestros(int n, int m) {
		super();
		this.n = n;
		this.m = m;
		generateGrid();
		initializeOperators();
	}



	private void initializeOperators() {
		operators = new ArrayList<Operator>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		String[] operatorName = {"North", "South", "East", "West"};
		for(int i = 0; i < 4; i++)
			operators.add(new JonOperator(operatorName[i], 1, dx[i], dy[i], false, false));
		operators.add(new JonOperator("Attack", n * m + 1, 0, 0, true, false));
		operators.add(new JonOperator("Pick", 1, 0, 0, false, true));
		
	}



	private void generateGrid() {
//		TODO: random grid
//		grid = new char[4][4];
		char[][] newGrid = 
			{{'.','.','w','.'},
			{'d','.','.','w'},
	        {'.','o','.','o'},
	        	{'w','.','.','j'}};
		this.grid = newGrid;
		this.initialState = new WestrosState(new Cell(3,3), 0, 3, newGrid);
	}



	@Override
	public boolean goal(State state) {
		WestrosState westrosState = (WestrosState) state;
		if(westrosState.whiteWalkersLeft == 0) return true;
		return false;
	}
	

}
