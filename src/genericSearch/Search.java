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
	 * @param problem
	 * @param queue
	 * @param printPath
	 * Generic search algorithm
	 * @return
	 */
	public static Node search(Problem problem, SearchQueue queue, boolean printPath) {
		queue.initializeQueue(new Node(problem.initialState, null, null));
		
		while(!queue.isEmpty()) {
			Node node = queue.removeFront();
			if(problem.goal(node.state)){ if(printPath) Node.printPath(node); return node;}
			ArrayList<Node> possibleNodes = expand(node, problem.operators);
			queue.add(possibleNodes);
		}
		
		return null;
	}
	
}
