package genericSearch;

import java.util.ArrayList;

public abstract class Problem {
	
	public ArrayList<Operator> operators;
	public State initialState;
	
	public abstract boolean goal(State state);
	
}
