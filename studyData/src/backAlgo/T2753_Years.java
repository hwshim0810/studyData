package backAlgo;

import java.util.Scanner;

class Years {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int year = scan.nextInt();
			int ans = 0;
			
			if(year % 4 == 0) {
				if(year % 100 != 0 || year % 400 == 0) {
					ans = 1;
				} else {
					ans = 0;
				}
			} else {
				ans = 0;
			}
			System.out.println(ans);
		}
	}

}
