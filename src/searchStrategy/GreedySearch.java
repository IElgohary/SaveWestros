package searchStrategy;

public class GreedySearch extends UniformCostSearch{
	
	public GreedySearch(String func){
		super(new GreedyNodeComparator(func));
	}
}
