package backAlgo;

import java.util.Scanner;

class AvgScore {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
			
			int ans = 0;
			
			for(int i = 0; i < 5; i++) {
				int score = scan.nextInt();
				
				if(score < 40) score = 40;
				
				ans += score;
			}
			
			System.out.println(ans / 5);
		}
	}

}
