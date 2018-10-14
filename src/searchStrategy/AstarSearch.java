package searchStrategy;

public class AstarSearch extends UniformCostSearch{
	
	/**
	 * Constructs an A* search queue with one of the predefined cost functions.
	 * @param func a string dictating the type of cost calculating strategy to be used.
	 */
	public AstarSearch(String func){
		super(new AstarNodeComparator(func));
	}
}
