package searchStrategy;

import genericSearch.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends SearchQueue{
	
	Queue<Node> queue = new LinkedList<Node>();

	/**
	 * @return boolean indicating whether the queue is empty
	 */
	@Override
	public boolean isEmpty() {
		
		return queue.isEmpty();
	}

	/**
	 * @return Node remove the front node in the queue
	 */
	@Override
	public Node removeFront() {
		
		return queue.remove();
	}

	/**
	 * @param nodes an array list of nodes to be added to the queue
	 * if the state resulting has not been previously explored
	 */
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
