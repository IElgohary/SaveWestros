package searchStrategy;

import java.util.ArrayList;

import java.util.TreeMap;

import genericSearch.Node;
import genericSearch.State;

// a class for the base queueing algorithm 
public abstract class SearchQueue {
	TreeMap<State, Integer> visited = new TreeMap<State, Integer>();
	Node initial_node;
	/**
	 * Initialize the queue with a single node
	 * 
	 * @param node initial node to add in the queue
	 */
	public void initializeQueue(Node node) {
		initial_node = node;
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
	 * if the state resulting has not been previously explored.
	 */
	public abstract void add(ArrayList<Node> nodes);

}
