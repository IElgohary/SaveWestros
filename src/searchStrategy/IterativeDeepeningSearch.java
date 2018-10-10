package searchStrategy;

import genericSearch.Node;

import java.util.ArrayList;
import java.util.Stack;

public class IterativeDeepeningSearch  extends SearchQueue{
	
	Stack<Node> stack;
	int level = 0;
	static final int max_level = ((int) 1e9);
	
	
	@Override
	public boolean isEmpty() {
		
		boolean isEmpty = stack.isEmpty();
		
		if(isEmpty && level == max_level)
			return isEmpty;
		
		if(isEmpty && level != max_level){
			level++;
			initializeQueue(new Node(initial_state, null, null));
			return false;
		}
		
		return true;
		
	}

	@Override
	public Node removeFront() {
		
		return stack.pop();
	}

	@Override
	public void add(ArrayList<Node> nodes) {
		for(Node node: nodes){
			if(node.depth == level)
				return;
			Integer pathCost = visited.get(node.state);
			if(pathCost == null){
				visited.put(node.state, node.pathCost);
				stack.push(node);
			}
		}
	}
	
}
