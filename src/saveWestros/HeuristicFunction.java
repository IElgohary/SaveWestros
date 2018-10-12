package saveWestros;

import genericSearch.Node;

public class HeuristicFunction {
	/**
	 * Calculate the cost according to the cost of 
	 * killing the remaining white walkers
	 * 
	 * @param node the node to calculate the cost for
	 * @return The heuristic cost of this node
	 */
	public static int remainingWalkers(Node node) {
		WestrosState state = (WestrosState) node.state;
		int n,m;
		n = state.grid.length;
		m = state.grid[0].length;
		return state.whiteWalkersLeft * (n * m + 1);
	}
	
	/**
	 * Calculate the cost according to the cost of 
	 * moving to the farthest white walker
	 * 
	 * @param node the node to calculate the cost for
	 * @return The heuristic cost of this node
	 */
	public static int distanceToFarthestWalker(Node node) {
		char [][] grid = ((WestrosState) node.state).grid;
		int maxCost = 0;
//		Current position of Jon Snow
		int x = ((WestrosState) node.state).cell.x;
		int y = ((WestrosState) node.state).cell.y;
		
		for (int i = 0 ; i < grid.length; i++) {
			for (int j = 0 ; j < grid[0].length ; j++) {
				if(grid[i][j] == saveWestros.SaveWestros.WHITE_WALKER) {
					int cost = Math.abs((j - y) + (i - x));
					maxCost = Math.max(maxCost, cost);
				}
			}
		}
		return maxCost;
	}
	
	/**
	 * Calculate the cost according to the cost of 
	 * killing the remaining white walkers + the cost of moving  
	 * to the farthest white walker
	 * 
	 * @param node the node to calculate the cost for
	 * @return The heuristic cost of this node
	 */
	public static int distanceAndRemainingWalkers(Node node) {
		return distanceToFarthestWalker(node) + remainingWalkers(node);
	}
}
