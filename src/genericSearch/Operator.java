package genericSearch;

public abstract class Operator {
	public String name;
	public int cost;
	
	/**
	 * Constructs a generic operator with the given paramters.
	 * @param name
	 * @param cost
	 */
	public Operator(String name, int cost) {
		super();
		this.name = name;
		this.cost = cost;
	}
	
	/**
	 * @param node
	 * Applies an operator on the given node.
	 * @return a new node that results from applying the operator.
	 */
	public abstract Node run(Node node);
}
