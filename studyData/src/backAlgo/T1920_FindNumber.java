package backAlgo;
/**
 * 문제
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1≤N≤100,000)이 주어진다. 
다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1≤M≤100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 
이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수들의 범위는 int 로 한다.

출력
M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.

예제 입력 
5
4 1 5 2 3
5
1 3 7 9 5
예제 출력 
1
1
0
0
1
@see https://www.acmicpc.net/problem/1920
 */
import java.util.Arrays;
import java.util.Scanner;

class FindNumber {
	// 배열과 배열의 첫번째 인덱스, 마지막인덱스, 찾는 값을 받아서 있으면 1 없으면 0을 반환하는 메서드
	private static int find(int[] arr, int first, int last, int target) {
		int mid;
		if(first > last) return 0; // 처음과 마지막이 역전됐다는것은 모든값을 다뒤졌다는것
		
		mid = (first + last) / 2; // 중앙 인덱스 설정
		
		if(arr[mid] == target) return 1; // 중앙값이 찾는값이면 1반환
		else if(target < arr[mid]) return find(arr, first, mid-1, target); // 찾는값이 중앙값보다 작으면 처음부터~중앙값 -1 인덱스까지 찾는다
		else return find(arr, mid+1, last, target); // 중앙값보다 크면 중앙값+1부터~마지막 인덱스까지 찾는다
		
	}

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int rpt = scan.nextInt();
			
			int[] arr = new int[rpt];
			
			for(int i = 0; i < rpt; ++i) arr[i] = scan.nextInt();
			
			int rpt2 = scan.nextInt();
			
			Arrays.sort(arr);
			
			for(int j = 0; j < rpt2; ++j) {
				System.out.println(find(arr, 0, arr.length-1, scan.nextInt()));
			}
			
		}
	}

}
