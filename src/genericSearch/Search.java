package genericSearch;
import java.util.ArrayList;

import searchStrategy.SearchQueue;

public class Search {
	
//	Defining the state space	
	private static ArrayList<Node> expand(Node currentNode, ArrayList<Operator> operators){
		ArrayList<Node> resultNodes = new ArrayList<Node>();
		for (Operator operator: operators) {
			
			Node resNode  = operator.run(currentNode);
			
			if(resNode != null)
				resultNodes.add(resNode);
		}
		return resultNodes;
	}
	
	/**
	 * @param problem an instance of the problem
	 * @param queue An instance of the queuing strategy
	 * @param visualize a boolean dictating whether or not the step by step solution should be printed
	 * Generic search algorithm
	 * @return the final node goal node if a goal exists or null
	 */
	public static Node search(Problem problem, SearchQueue queue, boolean visualize) {
		queue.initializeQueue(new Node(problem.initialState, null, null));
		int expanded_node_count = 0;
		while(!queue.isEmpty()) {
			Node node = queue.removeFront();
			expanded_node_count+=1;
			if(problem.goal(node.state)){ if(visualize){ Node.printPath(node); System.out.println("Total cost: "+node.pathCost);
				System.out.println("Number of expanded states: "+expanded_node_count);} return node;}
			ArrayList<Node> possibleNodes = expand(node, problem.operators);
			queue.add(possibleNodes);
		}
		
		return null;
	}
	
}
