package backAlgo;

import java.util.Scanner;

class EscapeSquare {

	public static void main(String[] args) {
		
		try(Scanner scan = new Scanner(System.in)){
			
			String[] arr = scan.nextLine().split(" ");
			
			int Min = 0;
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			int w = Integer.parseInt(arr[2]);
			int h = Integer.parseInt(arr[3]);
			
				
			Min = Math.min(Math.min(x, y), Math.min(w - x , h - y));
			
			System.out.println(Min);
			
		}
	}
}
