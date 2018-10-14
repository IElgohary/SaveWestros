package searchStrategy;

import genericSearch.Node;
import genericSearch.State;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeMap;

public class IterativeDeepeningSearch  extends SearchQueue{
	
	Stack<Node> stack = new Stack<Node>();
	int level = 0;
	static final int max_level = ((int) 1e9);
	
	/**
	 * if the queue is empty, but the max level has not been reached,
	 * continue increasing the depth and reset the state space.
	 * @return boolean indicating whether the queue is empty
	 */
	@Override
	public boolean isEmpty() {
		
		if(stack.isEmpty() && level == max_level)
			return true;
		
		if(!stack.isEmpty())
			return false;
		
		level+=1;
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		visited = new TreeMap<State, Integer>();
		nodes.add(initial_node);
		add(nodes);
		
		return false;
		
	}
	
	/**
	 * @return Node remove the front node in the queue
	 */
	@Override
	public Node removeFront() {
		
		return stack.pop();
	}

	/**
	 * @param nodes an array list of nodes to be added to the queue
	 * if the state resulting has not been previously explored and
	 * the max level has not yet been reached.
	 */
	@Override
	public void add(ArrayList<Node> nodes) {
		for(Node node: nodes){
			if(node.depth > level)
				continue;
			Integer pathCost = visited.get(node.state);
			if(pathCost == null){ 
				visited.put(node.state, node.pathCost);
				stack.push(node);
			}
		}
	}
	
}
