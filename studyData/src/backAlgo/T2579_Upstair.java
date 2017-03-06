package backAlgo;
/**
 * 문제
계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다. 
<그림 1>과 같이 각각의 계단에는 일정한 점수가 쓰여 있는데 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다.

예를 들어 <그림 2>와 같이 시작점에서부터 첫 번째, 두 번째, 네 번째, 여섯 번째, 계단을 밟아 도착점에 도달하면 
총 점수는 10 + 20 + 25 + 20 = 75점이 된다.

계단 오르는 데는 다음과 같은 규칙이 있다.

계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
연속된 세 개의 계단을 모두 밟아서는 안된다. 단, 시작점은 계단에 포함되지 않는다.
마지막 도착 계단은 반드시 밟아야 한다.
따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세번째 계단을 연속해서 모두 밟을 수는 없다.

각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최대값을 구하는 프로그램을 작성하시오.

입력
입력의 첫째 줄에 계단의 개수가 주어진다.

둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다. 
계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수이다.

출력
첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최대값을 출력한다.

예제 입력
6
10
20
15
25
10
20
예제 출력
75

@see https://www.acmicpc.net/problem/2579
 */
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class Upstair {
	private static Map<Entry<Integer,Integer>,Integer> memo = new HashMap<>(); // 계산한 값을 저장할 메모
	
	//배열과 끝인덱스 첫번째 스탭을 받아서 최대값 계산
	private static int maxValue(int[] stair, int fromEnd_idx, int step) {
		Entry<Integer,Integer> key = new SimpleEntry<>(fromEnd_idx , step);
		
		if(memo.containsKey(key)) return memo.get(key); // 키 생성 및 확인 등
		
		if(fromEnd_idx < 0) return 0; // 기저사례 : 첫번째 인덱스 아래로 가면 반환
		
		int sum = 0;
		if(step == 1) sum = Math.max(stair[fromEnd_idx] + maxValue(stair, fromEnd_idx - 1, 2)
									,stair[fromEnd_idx] + maxValue(stair, fromEnd_idx - 2, 1));
							// 첫번째 계단인경우
							// 현재계단과 그 앞계단(두번째스텝이 됨)의 합과 현재계단과 그 앞앞계단(다시 첫번째 스텝이됨)의 합중 최대값
		
		if(step == 2) sum = stair[fromEnd_idx] + maxValue(stair, fromEnd_idx - 2, 1);
							// 두번째 스텝인 경우 앞앞계단으로 밖에 갈수없음
		
		memo.put(key, sum); // 메모
		
		return sum;
	}
	
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int[] stair = new int[scan.nextInt()];
			
			for(int i = 0; i < stair.length; ++i) {
				stair[i] = scan.nextInt();
			}
			
			int fromEnd_idx = stair.length-1;
			
			System.out.println(maxValue(stair, fromEnd_idx, 1));
		}
	}

}
