package genericSearch;

public class Node{
	public State state;
	public Node parent;
	public Operator operator;
	public int depth;
	public int pathCost;
	
	/**
	 * Constructs a generic node with the given parameters
	 * @param state
	 * @param parent
	 * @param operator
	 */
	public Node(State state, Node parent, Operator operator) {
		this.state = state;
		this.parent = parent;
		this.operator = operator;
		if( parent != null) {
			this.depth = parent.depth + 1;
			this.pathCost = parent.pathCost + operator.cost;
		}
		
	}

	/**
	 * prints a step by step solution, visualizing the state
	 * and agent action throughout the grid it is solving.
	 * @param node the final goal node if one is reached.
	 */
	public static void printPath(Node node){
		
		if(node.parent == null){
			System.out.println(node.state);	
			return;
		}
		
		printPath(node.parent);
		System.out.println(node.operator.name);
		System.out.println(node.state);	
	}
}
