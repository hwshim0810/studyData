package backAlgo;

import java.util.Scanner;

public class Star3 {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			int num = s.nextInt();
			for (int i = num; i != 0; i--) {
				String stars = "*";
				String repeated = new String(new char[i]).replace("\0",stars);
				System.out.printf("%" + num + "s\n" , repeated);
//				for (int j = 0; j < i; j++) {
//					stars += "*";
//				}
//				System.out.printf("%" + num + "s\n",stars);
			}
		}
	}

}