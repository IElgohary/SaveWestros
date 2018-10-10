package searchStrategy;

public class AstarSearch extends UniformCostSearch{
	
	public AstarSearch(){
		super(new AstarNodeComparator());
	}
}
