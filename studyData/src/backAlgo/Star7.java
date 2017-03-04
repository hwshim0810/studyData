package backAlgo;

import java.util.Scanner;

public class Star7 {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
			
			int num = scan.nextInt();
			String stars = null;
			int count = num;
			
			for(int i = 0; i < num ; i++){
				
				StringBuilder star = new StringBuilder();
				
				for(int j = 0; j < 2 * i + 1; j++){
					
					star.append("*");
					
				}
				
				
				for(int k = count - 1; k > 0; k--){
					
					star.insert(0, " ");
					
				}
				
				stars = star.toString();
				count--;
				System.out.println(stars);
				
			}
			
			for (int i = num-1; i > 0; i--) {

				StringBuilder star = new StringBuilder();

				for (int j = 0; j < 2 * i - 1; j++) {

					star.append("*");

				}

				stars = star.toString();

				for (int k = 0; k < count+1; k++) {

					star.insert(0, " ");
					stars = star.toString();

				}

				count++;
				System.out.println(stars);

			}
		}
	}
}
