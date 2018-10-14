package searchStrategy;

import genericSearch.Node;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import saveWestros.HeuristicFunction;

public class AstarNodeComparator implements Comparator<Node> {
	
	String hn;
	/**
	 * Constructs an A* node comparator with  one of the predefined cost function. 
	 * @param func a string that dictates the cost calculating function.
	 */
	public AstarNodeComparator(String func){
		this.hn = func;
	}
	
	public int compare(Node node1, Node node2) {
		// TODO Auto-generated method stub
		switch(hn){
			case "h1": return (HeuristicFunction.remainingWalkers(node1) + node1.pathCost) - (HeuristicFunction.remainingWalkers(node2) + node2.pathCost);
			
			case "h2": return (HeuristicFunction.distanceToFarthestWalker(node1)
					+ node1.pathCost) - (HeuristicFunction.distanceToFarthestWalker(node2) + node2.pathCost);
			
			case "h3": return (HeuristicFunction.distanceAndRemainingWalkers(node1) 
					+ node1.pathCost) - (HeuristicFunction.distanceAndRemainingWalkers(node2) + node2.pathCost);
			
			default:  return (HeuristicFunction.remainingWalkers(node1) + node1.pathCost) - (HeuristicFunction.remainingWalkers(node2) + node2.pathCost);
		}
		
	}

	public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
			Function<? super T, ? extends U> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T, U> Comparator<T> comparing(
			Function<? super T, ? extends U> arg0, Comparator<? super U> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingDouble(
			ToDoubleFunction<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingInt(ToIntFunction<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingLong(ToLongFunction<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> nullsFirst(Comparator<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> nullsLast(Comparator<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Node> reversed() {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Node> thenComparing(Comparator<? super Node> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <U extends Comparable<? super U>> Comparator<Node> thenComparing(
			Function<? super Node, ? extends U> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <U> Comparator<Node> thenComparing(
			Function<? super Node, ? extends U> arg0, Comparator<? super U> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Node> thenComparingDouble(
			ToDoubleFunction<? super Node> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Node> thenComparingInt(ToIntFunction<? super Node> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Node> thenComparingLong(ToLongFunction<? super Node> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
