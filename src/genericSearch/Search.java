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
	
//	Generic search algorithm
	public static Node search(Problem problem, SearchQueue queue) {
		queue.initializeQueue(new Node(problem.initialState, null, null));
		
		while(!queue.isEmpty()) {
			Node node = queue.removeFront();
			if(problem.goal(node.state)) return node;
			ArrayList<Node> possibleNodes = expand(node, problem.operators);
			queue.add(possibleNodes);
		}
		
		return null;
	}
	
}
