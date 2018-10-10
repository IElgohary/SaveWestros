package searchStrategy;

import genericSearch.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends SearchQueue{
	
	Queue<Node> queue = new LinkedList<Node>();

	@Override
	public boolean isEmpty() {
		
		return queue.isEmpty();
	}

	@Override
	public Node removeFront() {
		
		return queue.remove();
	}

	@Override
	public void add(ArrayList<Node> nodes) {
		
		for(Node node: nodes){
			Integer pathCost = visited.get(node.state);
			
			if(pathCost == null){
				visited.put(node.state, node.pathCost);
				queue.add(node);
			}
		}
	}
	
}
