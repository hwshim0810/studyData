package backAlgo;

import java.util.Scanner;

public class Star8 {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
			
			int num = scan.nextInt();
			printStar(1, num);
			
//			String stars = null , stars2 = null;
//			
//			for(int i = 1; i <= num; i++){
//				StringBuilder star = new StringBuilder();
//				StringBuilder star2 = new StringBuilder();
//				
//				for(int j = 0; j < i; j++){
//					star.append("*");
//					star2.append("*");
//				}
//				
//				
//				for(int k = num; k > i; k--){
//					star.append(" ");
//					star2.insert(0, " ");
//				}
//
//				stars = star.toString();
//				stars2 = star2.toString();
//				
//				System.out.print(stars);
//				System.out.println(stars2);
//				
//			}
//			
//			for(int i = 1; i < num; i++){
//				StringBuilder star = new StringBuilder();
//				StringBuilder star2 = new StringBuilder();
			
//				for(int j = num; j > i; j--){
//					star.append("*");
//					star2.append("*");
//				}
//				
//				for(int k = 0; k < i; k++){
//					star.append(" ");
//					star2.insert(0, " ");
//				}
//
//				stars = star.toString();
//				stars2 = star2.toString();
//				
//				System.out.print(stars);
//				System.out.println(stars2);
//				
//			}
		}
	}
	
	private static void printStar(int x, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < x; i++)
			sb.append("*");
		
		for (int i = 0; i < (n - x) * 2; i++)
			sb.append(" ");
		
		for (int i = 0; i < x; i++)
			sb.append("*");
		
		System.out.println(sb.toString());
		if (x == n)
			return;
		
		printStar(x + 1, n);
		System.out.println(sb.toString());
	}
}