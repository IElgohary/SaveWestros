import java.util.ArrayList;

public abstract class GenericSearchProblem {
	public Node initialState;
	public String[] operators;
	
//	Defining the state space	
	public abstract ArrayList<Node> expand(Node currentState, String[] operators);
	
	public abstract int calculateCost(Node currentState, String[] Operators);
	
	public abstract boolean goal(Node currentState);
	
	public abstract ArrayList<Node> queuing(Node currentState, ArrayList<Node> possibleNodes, ArrayList<Node> nodes);	
	
	public static Node genericSearch(GenericSearchProblem problem, SearchStrategy strategy) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(problem.initialState);
		
		while(!nodes.isEmpty()) {
			Node node = nodes.remove(0);
			if(problem.goal(node)) return node;
			ArrayList<Node> possibleNodes = problem.expand(node, problem.operators);
			problem.queuing(node, possibleNodes, nodes);
		}
		
		return null;
	}
}
