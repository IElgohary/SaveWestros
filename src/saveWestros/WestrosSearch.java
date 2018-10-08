package saveWestros;

import java.util.Scanner;

import genericSearch.Search;

public class WestrosSearch extends Search{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Width:");
		int n = sc.nextInt();
		System.out.println("Enter Height:");
		int m = sc.nextInt();
		
		SaveWestros problem = new SaveWestros(n,m);
//		TODO: Start searching
		
	}

}
