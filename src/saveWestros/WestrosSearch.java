package saveWestros;

import java.util.Scanner;

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
//		TODO: Start searching
		
	}

}
