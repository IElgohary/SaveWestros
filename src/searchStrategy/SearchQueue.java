package searchStrategy;

import java.util.ArrayList;

import genericSearch.Node;

// a class for the base queueing algorithm 
public abstract class SearchQueue {

	public void initializeQueue(Node node) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(node);
		add(nodes);
		
	}
	
	/**
	 * @return boolean indicating whether the queue is empty
	 */
	public abstract boolean isEmpty();

	/**
	 * @return Node remove the front node in the queue
	 */
	public abstract Node removeFront();

	/**
	 * @param nodes an array list of nodes to be added to the queue
	 */
	public abstract void add(ArrayList<Node> nodes);

}
