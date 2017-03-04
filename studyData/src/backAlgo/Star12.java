package backAlgo;

import java.util.Scanner;

public class Star12 {
	private static void rptStar(int x, int n) {
		StringBuilder stb = new StringBuilder();
		
		for(int i = 0; i < (n-x); i++) {
			stb.append(" ");
		}
		
		for(int i = 0; i < x; i++) {
			stb.append("*");
		}
		
		System.out.println(stb.toString());
		if(x == n) return;
		
		rptStar(x + 1, n);
		System.out.println(stb.toString());
		
	}
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int num = scan.nextInt(); 
			
			rptStar(1, num);
		}
	}

}
