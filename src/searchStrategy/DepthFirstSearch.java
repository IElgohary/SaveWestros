package searchStrategy;

import genericSearch.Node;

import java.util.ArrayList;
import java.util.Stack;

/*
 * An implementation of the Depth first search Queuing strategy
 */

public class DepthFirstSearch extends SearchQueue{

	Stack<Node> stack = new Stack<Node>();
	
	/**
	 * @return boolean indicating whether the queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/**
	 * @return Node remove the front node in the queue in last in first out fashion.
	 */
	@Override
	public Node removeFront() {
		return stack.pop();
	}

	/**
	 * @param nodes an array list of nodes to be added to the queue
	 * if the state resulting has not been previously explored
	 */
	@Override
	public void add(ArrayList<Node> nodes) {
		for (Node node: nodes){
			Integer pathCost = visited.get(node.state);
			
			if(pathCost == null){ 
				visited.put(node.state, node.pathCost);
				stack.push(node);
			}
		}
	}
	
}
