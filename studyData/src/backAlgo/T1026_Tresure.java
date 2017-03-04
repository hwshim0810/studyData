package backAlgo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Tresure {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in);) {
			
			int N = Integer.parseInt(scan.nextLine());
			Integer arrA[] = new Integer[N];
			Integer arrB[] = new Integer[N];
			
			for (int k = 0; k < N; k++) {
				arrA[k] = scan.nextInt();
			}
			
			for (int k = 0; k < N; k++) {
				arrB[k] = scan.nextInt();
			}

			int compareProduct = 0;
			
			Arrays.sort(arrA);
			Arrays.sort(arrB, Comparator.reverseOrder());
			
			for(int j = 0; j < N; j++){
				
				compareProduct += arrA[j] * arrB[j];
				
			}
			
			System.out.println(compareProduct);
		}
	}
}
