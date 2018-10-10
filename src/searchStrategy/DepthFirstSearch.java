package searchStrategy;

import genericSearch.Node;

import java.util.ArrayList;
import java.util.Stack;

/*
 * An implementation of the Depth first search Queuing strategy
 */

public class DepthFirstSearch extends SearchQueue{

	Stack<Node> stack = new Stack<Node>();
	
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public Node removeFront() {
		return stack.pop();
	}

	@Override
	public void add(ArrayList<Node> nodes) {
		for (Node node: nodes){
			Integer pathCost = visited.get(node.state);
			
			//check if the state has not been previously expanded, before
			//deciding whether or not to add to the queue (i.e: avoid visiting a repeated state)
			if(pathCost == null){ 
				visited.put(node.state, node.pathCost);
				stack.push(node);
			}
		}
	}
	
}
