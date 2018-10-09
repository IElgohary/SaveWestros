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
	public static int get_cost(Node node) {
		WestrosState state = (WestrosState) node.state;
		int n,m;
		n = state.grid.length;
		m = state.grid[0].length;
		return state.whiteWalkersLeft * (n * m + 1);
	}
}
