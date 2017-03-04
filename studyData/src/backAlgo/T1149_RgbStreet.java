package backAlgo;
/**
 * 문제
RGB거리에 사는 사람들은 집을 빨강, 초록, 파랑중에 하나로 칠하려고 한다. 또한, 그들은 모든 이웃은 같은 색으로 칠할 수 없다는 규칙도 정했다. 
집 i의 이웃은 집 i-1과 집 i+1이다. 처음 집과 마지막 집은 이웃이 아니다.

각 집을 빨강으로 칠할 때 드는 비용, 초록으로 칠할 때 드는 비용, 파랑으로 드는 비용이 주어질 때, 
모든 집을 칠할 때 드는 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 수 N이 주어진다. N은 1,000보다 작거나 같다. 둘째 줄부터 N개의 줄에 각 집을 빨강으로 칠할 때, 초록으로 칠할 때, 파랑으로 칠할 때 드는 비용이 주어진다.

출력
첫째 줄에 모든 집을 칠할 때 드는 비용의 최솟값을 출력한다.

예제 입력 
3
26 40 83
49 60 57
13 89 99
예제 출력 
96
@see https://www.acmicpc.net/problem/1149
 */
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

class RgbStreet {
  private static final int INF = 987654321;
  private static final int R = 0;
  private static final int G = 1;
  private static final int B = 2;
  private static final int NOT_PAINTED = 3;
  private static final int FIRST_HOUSE = 0;

  private static int N = 0;
  private static int[][] cost = null;
  private static HashMap<Entry<Integer,Integer>,Integer> memo = new HashMap<>();

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      N = scanner.nextInt();
      cost = new int[N][3];
      for (int i = 0; i < N; i++) {
        cost[i][R] = scanner.nextInt();
        cost[i][G] = scanner.nextInt();
        cost[i][B] = scanner.nextInt();
      }

      System.out.println(minCost(FIRST_HOUSE, NOT_PAINTED));
    }
  }

  // minCost는 마지막으로 색칠한 색(다음 집에는 칠할 수 없음)과 다음 집의 인덱스를 입력으로 받아서 색칠비용의 최소값을 반환한다.
  private static int minCost(int houseToPaint, int lastColor) {
    SimpleEntry<Integer, Integer> key = new SimpleEntry<>(houseToPaint, lastColor);
    if (memo.containsKey(key))
      return memo.get(key);

    int ret = INF;
    // 다음 집의 인덱스가 N이면 모든 집을 색칠한 상태이므로 더이상 비용을 계산할 필요가 없다.
    if (houseToPaint == N) {
      ret =  0;
    } else {
      // 현재 집에서부터 마지막 집까지 색칠하는 비용의 최소값은
      // 현재집을 빨간색으로 칠한 경우 : 현재 집의 빨간색 색칠 비용 + 다음집부터 마지막집까지의 최소비용
      // 현재집을 초록색으로 칠한 경우 : 현재 집의 초록색 색칠 비용 + 다음집부터 마지막집까지의 최소비용
      // 현재집을 파란색으로 칠한 경우 : 현재 집의 파란색 색칠 비용 + 다음집부터 마지막집까지의 최소비용
      // 위 세 가지 경우 중 최소값임.

      // 이웃한 집의 색이 달라야 하므로 lastColor는 칠할 수 없다.
      if (lastColor != R)
        ret = Math.min(ret, cost[houseToPaint][R] + minCost(houseToPaint + 1, R));

      if (lastColor != G)
        ret = Math.min(ret, cost[houseToPaint][G] + minCost(houseToPaint + 1, G));

      if (lastColor != B)
        ret = Math.min(ret, cost[houseToPaint][B] + minCost(houseToPaint + 1, B));
    }
    memo.put(key, ret);
    return ret;
  }
}
