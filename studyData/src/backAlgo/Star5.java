package backAlgo;

import java.util.Scanner;

public class Star5 {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
			
			int num = scan.nextInt();
			String stars = null;
			int count = num - 1;
			
			for(int i = 0; i < num ; i++){
				
				StringBuilder star = new StringBuilder();
				
				for(int j = 0; j < 2 * i + 1; j++){
					
					star.append("*");
					
				}
				
				
				for(int k = count; k > 0; k--){
					
					star.insert(0, " ");
					
				}
				
				stars = star.toString();
				count--;
				System.out.println(stars);
				
			}
		}
	}
}
