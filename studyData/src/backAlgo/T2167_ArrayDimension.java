package backAlgo;
/**
 * 문제
2차원 배열이 주어졌을 때 (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합을 구하는 프로그램을 작성하시오. 
배열의 (i, j) 위치는 i행 j열을 나타낸다.

입력
첫째 줄에 배열의 크기 N, M(1≤N, M≤300)이 주어진다. 다음 N개의 줄에는 M개의 정수로 배열이 주어진다. 
그 다음 줄에는 합을 구할 부분의 개수 K(1≤K≤10,000)가 주어진다. 다음 K개의 줄에는 네 개의 정수로 i, j, x, y가 주어진다(i≤x, j≤y).

출력
K개의 줄에 순서대로 배열의 합을 출력한다. 배열의 합은 32bit-int 범위를 초과하지 않는다.
@see https://www.acmicpc.net/problem/2167
 */
import java.util.Scanner;

class ArrayDimension {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int row = scan.nextInt(); // 행을 입력받는다
			int column = scan.nextInt(); // 열을 입력받는다
			
			int[][] arr = new int[row][column]; // 2차원 배열을 생성한다
			
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < column; j++) {
					arr[i][j] = scan.nextInt();  // 2차원 배열에 값을 입력한다
				}
			}
			
			int rangeNum = scan.nextInt(); // 합계를 몇번 낼껀지 입력받는다
			
			for(int l = 0; l < rangeNum; l++) {
				int i = scan.nextInt(); 
				int j = scan.nextInt();
				int x = scan.nextInt();
				int y = scan.nextInt(); // 좌표를 입력받는다
				
				int ans = arrSum(i, j, x, y, arr); // 좌표와 배열을 메서드에 넣어준다
				
				System.out.println(ans); // 메서드의 결과를 출력
			}
		}
	}
	
	private static int arrSum(int i, int j, int x, int y, int[][] arr) {
											// 좌표와 배열을 파라미터로 받는다
		
		int sum = 0; // 출력할 합을 설정하고 초기화
		
		if(i == x && j == y) return arr[i-1][j-1]; // 두 좌표가 같으면 더할필요가 없으니 그대로 출력
			
		for(int a = i-1; a <= x-1; a++) { 	// 인덱스라서 1씩 뺀 값으로 설정해준다
			for(int b = j-1; b <= y-1; b++) {
				sum += arr[a][b];  // 2차원 배열의 좌표를 설정하여 누적합을 구함
			}
		}
		return sum; // 누적합을 리턴
	}

}
