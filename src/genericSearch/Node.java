package genericSearch;

public class Node{
	public State state;
	public Node parent;
	public Operator operator;
	public int depth;
	public int pathCost;
	
	public Node(State state, Node parent, Operator operator) {
		this.state = state;
		this.parent = parent;
		this.operator = operator;
		if( parent != null) {
			this.depth = parent.depth + 1;
			this.pathCost = parent.pathCost + operator.cost;
		}
		
	}

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
