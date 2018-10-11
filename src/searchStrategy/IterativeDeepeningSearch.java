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
	
	
	@Override
	public boolean isEmpty() { //TODO: change code
		
		if(!stack.isEmpty())
			return false;
		if(stack.isEmpty() && level == max_level)
			return true;
//		System.out.println(level);
		++level;
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		visited = new TreeMap<State, Integer>();
		nodes.add(initial_node);
		add(nodes);
		
		return false;
		
	}

	@Override
	public Node removeFront() {
		
		return stack.pop();
	}

	@Override
	public void add(ArrayList<Node> nodes) {
		for(Node node: nodes){
			
			Integer pathCost = visited.get(node.state);
			if(pathCost == null && node.depth <= level){
				visited.put(node.state, node.pathCost);
				stack.push(node);
			}
		}
	}
	
}
