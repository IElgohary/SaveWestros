package genericSearch;

public abstract class Operator {
	public String name;
	public int cost;
	
	public Operator(String name, int cost) {
		super();
		this.name = name;
		this.cost = cost;
	}
	
	public abstract Node run(Node node);
}
