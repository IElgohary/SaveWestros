import java.util.ArrayList;

public class SaveWestros extends GenericSearchProblem{
	public Cell[][] grid;
	public String[] operators;
	
	@Override
	public int calculateCost(Node currentState, String[] Operators) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean goal(Node currentState) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Node> expand(Node currentState, String[] operators) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Node> queuing(Node currentState, ArrayList<Node> possibleNodes, ArrayList<Node> nodes) {
		// TODO Auto-generated method stub
		return null;
	}

}
