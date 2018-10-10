package searchStrategy;

import genericSearch.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class UniformCostSearch extends SearchQueue{

	NodeComparator nodeComparator;
	
	PriorityQueue<Node> queue;
	
	public UniformCostSearch(){
		this.nodeComparator = new NodeComparator();
		this.queue = new PriorityQueue<Node>(nodeComparator);
	}

	public UniformCostSearch(Comparator<Node> comparator){
		this.queue = new PriorityQueue<Node>(comparator);
	}

	@Override
	public boolean isEmpty() {
		
		return queue.isEmpty();
	}

	@Override
	public Node removeFront() {
		
		return queue.remove();
	}

	/**
	 * Removes the first element of the queue (i.e: the node to be expanded).
	 * @return the removed node.
	 */
	@Override
	public void add(ArrayList<Node> nodes) {
		
		for(Node node: nodes){
			
			Integer pathCost = visited.get(node.state);
			if(pathCost == null || node.pathCost < pathCost){ //if a state is either unvisited or can be attained using a cheaper cost, consider the new option
				visited.put(node.state, node.pathCost);
				queue.add(node);
			}
		}
	}

}
