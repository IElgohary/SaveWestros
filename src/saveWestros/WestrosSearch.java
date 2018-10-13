package saveWestros;

import java.util.Scanner;


import searchStrategy.AstarSearch;
import searchStrategy.BreadthFirstSearch;
import searchStrategy.DepthFirstSearch;
import searchStrategy.GreedyNodeComparator;
import searchStrategy.GreedySearch;
import searchStrategy.IterativeDeepeningSearch;
import searchStrategy.UniformCostSearch;

import genericSearch.Node;
import genericSearch.Search;

public class WestrosSearch extends Search{
	// Start here	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Width:");
		int n = sc.nextInt();
		System.out.println("Enter Height:");
		int m = sc.nextInt();
		
		SaveWestros problem = new SaveWestros(4,4);
		Node res = search(problem, new AstarSearch("h3"), true);
		
	}

}
