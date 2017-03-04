package backAlgo;

import java.util.Scanner;

public class Star2 {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			int num = s.nextInt();
			for (int i = num; i != 0; i--) {
				for (int j = 0; j<i ; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

}