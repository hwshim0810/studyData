package backAlgo;

import java.util.Scanner;

public class Star1 {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			int num = s.nextInt();
			for (int i = 1; i <= num; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

}
