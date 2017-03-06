package backAlgo;
/**
 * 문제
자연수 N개를 주면 합을 구하는 프로그램을 작성하시오.

입력
입력의 첫 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 10)가 주어진다. 
각 테스트 케이스는 첫 줄에 자연수의 개수 N(1 ≤ N ≤ 100)이 주어지고, 그 다음 줄에는  N개의 자연수가 주어진다. 
각각의 자연수 사이에는 하나씩의 공백이 있다.

출력
각 테스트 케이스에 대해서 주어진 자연수의 합을 한 줄에 하나씩 출력한다.

예제 입력 
2
5
1 1 1 1 1
7
1 2 3 4 5 6 7
예제 출력 
5
28

@see https://www.acmicpc.net/problem/9085
 */
import java.util.Scanner;

class Plus {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int rpt = scan.nextInt();
			for(int i = 0; i < rpt; ++i) {
				int[] arr = new int[scan.nextInt()];
				int sum = 0;
				
				for(int j = 0; j < arr.length; ++j) arr[j] = scan.nextInt();
				for(int x : arr) sum += x;
				System.out.println(sum);
			}
		}
	}

}
