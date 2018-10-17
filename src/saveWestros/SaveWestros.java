package saveWestros;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import genericSearch.Operator;
import genericSearch.Problem;
import genericSearch.State;

public class SaveWestros extends Problem{
	public int n,m;
	public char[][] grid;
	
	public static final char WHITE_WALKER = 'w', EMPTY_CELL = '.',
			OBSTACLE = 'o', JON_SNOW = 'j', DRAGONGLASS = 'd',
			JON_ON_DRAGONGLASS = '@';
	
	public static char[]grid_elements = {WHITE_WALKER, OBSTACLE, DRAGONGLASS, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL};
	

	public SaveWestros() {
		super();
		
		genGrid();
		initializeOperators();
	}


	/**
	 * Initialize the operators of the problem
	 */
	private void initializeOperators() {
		operators = new ArrayList<Operator>();
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		String[] operatorName = {"North", "South", "East", "West"};
//		Operators of movement
		for(int i = 0; i < 4; i++)
			operators.add(new JonOperator(operatorName[i], 1, dx[i], dy[i], false, false));
//		Cost of attack is the highest to minimize the number of dragon glass pieces used
		operators.add(new JonOperator("Attack", n * m + 1, 0, 0, true, false));
		operators.add(new JonOperator("Pick", 1, 0, 0, false, true));
		
	}


	/**
	 * Generate a grid for the problem with dimensions n * m
	 */
	private void genGrid() {
		char[][] newGrid;
		int white_walker_count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Randomize grid?[y/n]? default=y");
		String randomize = sc.next();
		if(!randomize.equals("n")) {
			Random rnd = new Random();
			n = rnd.nextInt(8);
			m = rnd.nextInt(8);
			
			if(n < 4 || m < 4) {
				n = 4;
				m = 4;
			}
			newGrid = new char[n][m];
			System.out.println(n+" "+m);
			Random randomIndexGenerator = new Random();
			Random randomDragonGlass = new Random();
			for (int i = 0; i < newGrid.length; i++) {
				for (int j = 0; j < newGrid[i].length; j++) {
					
					if(i == newGrid.length-1 && j == newGrid[i].length-1){
						newGrid[i][j] = JON_SNOW;
						continue;
					}
					
					newGrid[i][j] = grid_elements[randomIndexGenerator.nextInt(grid_elements.length)];
					if(newGrid[i][j] == WHITE_WALKER) white_walker_count++;
				}
			}
		} else {
			System.out.println("Grid 1 or 2? default=1");
			switch(sc.nextInt()) {
			case 2: 
				char[][] newGrid2 = {
					{'.','w','.', 'w'},
					{'d','.', '.','.'},
					{'.','.','.','.'},
					{'w', '.','.', 'j'}
			};
				newGrid= newGrid2;
				white_walker_count = 3;
				n = 4;
				m = 4;
			break;
			default:
				char[][] newGrid1 = {
					{'.','.','w', '.'},
					{'.','.', '.','.'},
					{'.','.','w','.'},
					{'w', '.','d', 'j'}
			};
				newGrid = newGrid1;
				white_walker_count = 3;
				n = 4;
				m = 4;
			break;
			}
			
		}
		
		int dragonGlass = 0;
		
		this.grid = newGrid;
		this.initialState = new WestrosState(new Cell(newGrid.length - 1, newGrid[0].length - 1), dragonGlass, white_walker_count, this.grid);
	}

	
	/**
	 * The goal node is the node in which no white walkers are left
	 * 
	 * @param state the state to test whether it's a goal or not
	 * @return a boolean indicating whether or not the state is the goal
	 */
	@Override
	public boolean goal(State state) {
		WestrosState westrosState = (WestrosState) state;
		if(westrosState.whiteWalkersLeft == 0) return true;
		return false;
	}
	

}
