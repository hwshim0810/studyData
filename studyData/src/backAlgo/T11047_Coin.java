package backAlgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 문제
준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.

동전을 적절히 사용해서 그 가치의 합을 K로 만드려고 한다. 이 때 필요한 동전 개수의 최소값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)

둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)

출력
첫째 줄에 K원을 만드는데 필요한 동전 개수의 최소값을 출력한다.

예제 입력
10 4200
1
5
10
50
100
500
1000
5000
10000
50000
예제 출력
6
 * @author user
 * @see https://www.acmicpc.net/problem/11047
 */
public class T11047_Coin {
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int rpt = scan.nextInt();
			int object = scan.nextInt();
			int count = 0;
			List<Integer> coins = new ArrayList<>();
			
			for (int i = 0; i < rpt; i++)
				coins.add(scan.nextInt());
				
			coins.sort((a, b) -> b.compareTo(a));
			
			while (object > 0) {
				for (int i = 0; i < coins.size(); i++)
					if (object >= coins.get(i)) {
						object -= coins.get(i);
						++count;
						break;
					}
			}
			
			System.out.println(count);
		}
	}
}
