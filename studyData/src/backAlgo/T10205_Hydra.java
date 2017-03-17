package backAlgo;

import java.util.Scanner;

/**
 * 문제
헤라클레스는 그리스 신화의 유명한 비극적인 영웅이다. 그는 제우스의 사생아로 태어났는데, 이 때문에 제우스의 아내 헤라는 그를 매우 싫어했다. 그는 매우 강한 힘과 높은 지식을 가졌지만, 동시에 자신의 아이들이나, 그의 많은 스승들, 연인들 등을 스스로 죽이는 광기도 함께 가졌다. 그는 그의 아이들을 죽인 죄로, 에우리스테우스 왕이 내린 12가지의 과업을 수행해야 했던 인물로 잘 알려져 있다.

그 과업 중 두 번째는 바로 거대하고, 여러 개의 머리를 가진 히드라를 죽이라는 것이었다. 그런데 이 히드라는 헤라가 헤라클레스를 죽이려는 목적으로 만든 괴물이었다.

히드라를 죽이는 데 있어 큰 문제는, 머리 하나를 날려버리면, 2개의 새 머리가 나온다는 것이었고, 히드라는 머리가 하나 이상 남아있다면 죽지 않았다. 헤라클레스의 조카 이올라우스는 그 머리들을 자를 때 그 밑동에 불을 지지면 머리가 다시 자라나지 않는다는 사실을 깨달았다.

이런 상황에서, 헤라클레스와 이올라우스는 일련의 연속된 행동을 수행하는데, 이 행동은 그냥 히드라의 머리를 자르는 것과, 자름과 동시에 불로 지지는 두 가지 중 하나이다. 이 일련의 행동이 끝난 뒤 몇 개의 머리가 남아있는지를 결정하라.

입력
입력의 첫 번째 줄은 data set의 개수 K가 주어진다.

각 data set의 첫 번째 줄에는 히드라의 머리 개수 1 ≤ h ≤ 50 가 주어진다.

두 번째 줄에는 헤라클레스와 이올라우스의 일련의 행동들이 100글자 이하로 이루어진 문자열로 주어지는데, 이 때 'c'는 불로 지지지 않고 머리만 자르는 것을 뜻하고, 'b'는 머리를 자른 후 불로 지지는 것을 뜻한다.

출력
각 data set에 대한 출력의 첫 번째 줄은 "Data Set x:" 이다.

그 다음 줄에 헤라클레스와 이올라우스의 행동이 끝난 후 남아있는 히드라의 머리 개수를 출력한다.

각각의 data set 사이에는 빈 칸이 존재한다.

예제 입력  복사
2
10
cbbbbccbb
10
bbbbbbbbbccbbb
예제 출력  복사
Data Set 1:
7

Data Set 2:
0
 * @author user
 * @see https://www.acmicpc.net/problem/10205
 */
public class T10205_Hydra {
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int rpt = Integer.parseInt(scan.nextLine());
			
			for (int i = 1; i <= rpt; i++) {
				int head = Integer.parseInt(scan.nextLine());
				String act = scan.nextLine();
				
				for (int j = 0; j < act.length(); j++) {
					if (act.charAt(j) == 'c') ++head;
					else --head;
				}
				System.out.println("Data Set " + (i) + ":");
				System.out.println(head);
				System.out.println();
			}
		}
	}
}
