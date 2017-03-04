package backAlgo;
/**
 * @see	https://www.acmicpc.net/problem/2446
 */
import java.util.Scanner;

public class Star9 {
    
	private static void printStar(int x, int n) {
		StringBuilder sb = new StringBuilder();
        
		for (int i = 1; i < x; i++)
			sb.append(" ");
		
		for (int i = 0; i < n - x; i++)
			sb.append("*");
		
		sb.append("*");
		
		for (int i = 0; i < n - x; i++)
			sb.append("*");
		
		if(x != 1) sb.append(" "); // 첫줄이 아니면 공백하나씩
		
		System.out.println(sb.toString());
        
		if (x == n)
			return;
		
		printStar(x + 1, n);
		System.out.println(sb.toString());
        
	}
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int num = scan.nextInt(); 
			
			printStar(1, num);
		}
	}
}