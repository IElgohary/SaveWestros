package searchStrategy;

import genericSearch.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class UniformCostSearch extends SearchQueue{

	NodeComparator nodeComparator;
	
	PriorityQueue<Node> queue;
	
	/**
	 *	Constructs a uniform cost search queue with the default uninformed comparator. 
	 */
	public UniformCostSearch(){
		this.nodeComparator = new NodeComparator();
		this.queue = new PriorityQueue<Node>(nodeComparator);
	}

	/**
	 *	Constructs a uniform cost search queue with a given comparator function. 
	 *	@param comparator the comparator to be used for comparing node costs
	 */
	public UniformCostSearch(Comparator<Node> comparator){
		this.queue = new PriorityQueue<Node>(comparator);
	}

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
	 * Removes the first element of the queue (i.e: the node to be expanded),
	 * based on the comparator function used.
	 * @return the removed node.
	 */
	@Override
	public void add(ArrayList<Node> nodes) {
		
		for(Node node: nodes){
			
			Integer pathCost = visited.get(node.state);
			if(pathCost == null || node.pathCost < pathCost){ //if a state is either unvisited or can be attained using a cheaper cost, consider the cheaper option
				visited.put(node.state, node.pathCost);
				queue.add(node);
			}
		}
	}

}
