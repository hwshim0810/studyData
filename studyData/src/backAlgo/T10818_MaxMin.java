package backAlgo;

import java.util.Arrays;
import java.util.Scanner;

class MaxMin {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int[] arr = new int[scan.nextInt()];
			
			for(int i = 0; i < arr.length; ++i) arr[i] = scan.nextInt();
			
			Arrays.sort(arr);
			
			System.out.printf("%d %d" ,arr[0] ,arr[arr.length-1]);
		}
	}

}
