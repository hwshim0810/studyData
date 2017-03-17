package backAlgo;

import java.util.Scanner;

/**
 * 문제
상근이는 보통 사람들이 사는 것과는 조금 다른 삶을 사는 사람이다. 상근이는 이런 사람들의 시선이 부담스럽기 때문에, 자신만의 숫자를 개발하기로 했다. 바로 그 이름은 팩토리얼 진법이다. 팩토리얼 진법은 각 자리에 올 수 있는 숫자는 0부터 9까지로 10진법과 거의 비슷하다. 하지만, 읽는 법은 조금 다르다. 팩토리얼 진법에서는 i번 자리의 값을 ai×i!로 계산한다. 즉, 팩토리얼 진법에서 719는 10진법에서 53과 같다. 그 이유는 7×3! + 1×2! + 9×1! = 53이기 때문이다.

팩토리얼 진법으로 작성한 숫자가 주어졌을 때, 10진법으로 읽은 값을 구하는 프로그램을 작성하시오. 

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 최대 5자리인 팩토리얼 진법 숫자가 주어진다. 입력의 마지막 줄에는 0이 하나 주어진다.

출력
각 테스트 케이스에 대해서, 입력으로 주어진 팩토리얼 진법 숫자를 10진법으로 읽은 값을 출력한다.

예제 입력  복사
719
1
15
110
102
0
예제 출력  복사
53
1
7
8
8
 * @author user
 * @see https://www.acmicpc.net/problem/5692
 */
public class T5692_Fact {
	private static int fact(int i) {
		if (i < 2) return 1;
		else
			return i * fact(i-1);
	}
	
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			
			while (true) {
				String str = (new StringBuffer(scan.nextLine())).reverse().toString();
				if (str.equals("0")) break;
				
				int sum = 0;
				for (int i = 1; i <= str.length(); i++) {
					int num = str.charAt(i-1) - '0';
					sum += num * fact(i);
				}
				System.out.println(sum);
			}
		}
	}
	
}
