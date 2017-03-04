package backAlgo;

import java.util.Scanner;

class Chocolat {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			
			int n = scan.nextInt();
			int m = scan.nextInt();
			int ans = n * m -1;
			
			
			System.out.println(ans);
		}
	}

}
