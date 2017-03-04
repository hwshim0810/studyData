package backAlgo;

import java.util.Scanner;

class Plug {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int rptNum = scan.nextInt();
			int allHole = 0;
			
			for(int i = 0; i < rptNum; i++) {
				allHole += scan.nextInt();
			}
			
			System.out.println(allHole - (rptNum - 1));
		}
	}

}
