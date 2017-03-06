package backAlgo;
/**
 * 문제
0과 1로만 이루어진 수를 이진수라 한다. 이러한 이진수 들 특별한 성질을 갖는 것들이 있는데, 
이들을 이친수(pinary number)라 한다. 이친수는 다음의 성질을 만족한다.

이친수는 0으로 시작하지 않는다.
이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다. 
하지만 0010101이나 101101은 각각 1, 2번 규칙에 위배되므로 이친수가 아니다.

N(1≤N≤90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다.

출력
첫째 줄에 N자리 이친수의 개수를 출력한다.

예제 입력 
3
예제 출력 
2

@see https://www.acmicpc.net/problem/2193
 */
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class FriendlyBinary {
	private static Map<Entry<Long,Long>, Long> memo = new HashMap<>(); // 메모할 맵 선언
	
	// 첫글자는 1이 되므로 마지막으로 쓴글자(last)는 1, 자릿수를 넣어서 자릿수에 해당하는 이친수의 갯수를 구함
	public static long search(long last, long num) {
		Entry<Long,Long> key = new SimpleEntry<>(last, num);
		long ans = 0;
		
		if(memo.containsKey(key)) return memo.get(key);
		
		if(num == 1) return 1; // 기저사례 : 1자리수라면 1을 반환
		
		if(last == 0) ans = search(1, num - 1) + search(0, num -1); // 마지막글자가 0 이라면 1이나 0을 쓴 한자릿수 작은것들의 합
		else ans = search(0, num - 1); // 1이라면 0밖에없음
		
		memo.put(key, ans);
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.close();
		
		long start = System.currentTimeMillis();

		System.out.println(search(1, num));
		System.out.println("1 : " + (System.currentTimeMillis() - start));
	}

}
