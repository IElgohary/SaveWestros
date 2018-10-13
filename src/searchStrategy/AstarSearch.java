package searchStrategy;

public class AstarSearch extends UniformCostSearch{
	
	public AstarSearch(String func){
		super(new AstarNodeComparator(func));
	}
}
