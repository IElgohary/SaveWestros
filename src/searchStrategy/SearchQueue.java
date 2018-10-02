package searchStrategy;

import java.util.ArrayList;

import genericSearch.Node;

public abstract class SearchQueue {

	public void initializeQueue(Node node) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(node);
		add(nodes);
		
	}

	public abstract boolean isEmpty();

	public abstract Node removeFront();

	public abstract void add(ArrayList<Node> nodes);

}
