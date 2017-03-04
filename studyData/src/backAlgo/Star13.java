package backAlgo;
/**
 * 문제
  예제를 보고 별찍는 규칙을 유추한 뒤에 별을 찍어 보세요.

입력
  첫째 줄에 N (1<=N<=100)이 주어진다.

출력
  첫째 줄부터 2*N-1번째 줄 까지 차례대로 별을 출력한다.

예제 입력 
3
예제 출력 
*
**
***
**
*

@see https://www.acmicpc.net/problem/2523
 */
import java.util.Scanner;

public class Star13 {
	private static void rptStar(int x, int n) {
		StringBuilder stb = new StringBuilder();
		
		for(int i = 0; i < x; i++) {
			stb.append("*");
		}
		
		System.out.println(stb.toString());
		if(x == n) return;
		
		rptStar(x + 1, n);
		System.out.println(stb.toString());
		
	}
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int num = scan.nextInt(); 
			
			rptStar(1, num);
		}
	}

}
