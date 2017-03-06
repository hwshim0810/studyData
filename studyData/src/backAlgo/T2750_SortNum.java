package backAlgo;

import java.util.Arrays;
import java.util.Scanner;

class SortNum {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int size = scan.nextInt(); // 배열 사이즈를 입력받음
			int[] arr = new int[size]; // 배열 생성
			
			for(int i = 0; i < size; i++) {
				arr[i] = scan.nextInt(); // 배열 입력
			}
			
			Arrays.sort(arr); // 오름차순 정렬
			
			for(int n : arr) {  //출력
				System.out.println(n);
			}
		}
	}

}
