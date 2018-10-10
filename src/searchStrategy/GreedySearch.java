package searchStrategy;

public class GreedySearch extends UniformCostSearch{
	
	public GreedySearch(){
		super(new GreedyNodeComparator());
	}
}
