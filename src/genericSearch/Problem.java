package genericSearch;

import java.util.ArrayList;

public abstract class Problem {
	
	public ArrayList<Operator> operators;
	public State initialState;
	
	/**
	 * @param state a node state
	 * @return true if it is a goal state or false if it is not.
	 */
	public abstract boolean goal(State state);
	
}
