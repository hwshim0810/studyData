package backAlgo;

import java.util.Scanner;

class R2 {

	public static void main(String[] args) {
		
		try(Scanner scan = new Scanner(System.in)){
			
			int R1 = scan.nextInt();
			int S = scan.nextInt();
			int R2 = (S * 2) - R1;
			
			System.out.println(R2);
		}
	}
}
