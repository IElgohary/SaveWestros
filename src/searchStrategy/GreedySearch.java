package searchStrategy;

public class GreedySearch extends UniformCostSearch{
	
	/**
	 * Constructs a greedy search queue with one of the predefined cost functions.
	 * @param func a string dictating the type of cost calculating strategy to be used.
	 */
	public GreedySearch(String func){
		super(new GreedyNodeComparator(func));
	}
}
