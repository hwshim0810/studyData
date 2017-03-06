package backAlgo;
/**
 * 문제
신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.

예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 
1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 
하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.

어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 
1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 
둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.

출력
1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.

예제 입력
7
6
1 2
2 3
1 5
5 2
5 6
4 7

예제 출력 
4
@see https://www.acmicpc.net/problem/2606
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

class Virus {
	
/**	static class Computer {
//		List<Integer> list;
//		
//		Computer(){
//			List<Integer> list = new ArrayList<Integer>();
//			this.list = list;
//		}
//		
//	}
//	
//	static void add(Computer co, int left, int right) {
//		if(left == 1) {
//			if(!co.list.contains(right)) co.list.add(right);
//		} 
//		else if(right == 1) {
//			if(!co.list.contains(left)) co.list.add(left);
//		}
//		else {
//			if(co.list.contains(left)) {
//				if(!co.list.contains(right)) co.list.add(right);
//			}
//			else if(co.list.contains(right)) co.list.add(left);
//		}
	} **/

	public static void main(String[] args) {
		ChickenVirus cv = new ChickenVirus(); // 객체 생성
		cv.init(); // 초기화
		System.out.println(cv.numOfDefect()); // 함수 출력
/**		try(Scanner scan = new Scanner(System.in)) {
//			int sum = scan.nextInt();
//			int rpt = scan.nextInt();
//			Computer com = new Computer();
//			
//			for(int i = 0; i < rpt; ++i){
//				int left = scan.nextInt();
//				int right = scan.nextInt();
//				
//				add(com, left, right);
//			}
//			System.out.println(com.list.toString());
//			System.out.println(com.list.size());
		} **/
	}
	
	static class ChickenVirus {
		private HashSet<Integer> visited = new HashSet<>(); // 방문한곳 기록할 컬렉션(set: 집합- 중복허용이안됨)
		private Map<Integer, HashSet<Integer>> adjList = new HashMap<>(); // 노드당 방문한 곳을 기록할 set을 Map을 통해 기록
		private LinkedBlockingQueue<Integer> q = new LinkedBlockingQueue<>();  // bfs에 쓸 queue를 정의
		
		public void init() {
			visited.clear();
			adjList.clear(); // 재활용 가능하게 내용 초기화
			try(Scanner scan = new Scanner(System.in)) {
				int numOfComputers = scan.nextInt(); // 컴퓨터의 수 입력받음
				int n = scan.nextInt(); // 컴퓨터 연결 쌍의 수
				for (int i = 0; i < n; i++) {
					int a = scan.nextInt(); 
					int b = scan.nextInt(); // 컴퓨터 쌍을 입력받는다
					
					adjList
						.computeIfAbsent(a, x -> new HashSet<Integer>()) // key를 통해 검색한곳의 리스트가 있는지 검색후 없으면 만들어준다 그 후 반환
						.add(b); // 반환된 리스트에 추가
					
					adjList
						.computeIfAbsent(b, x -> new HashSet<Integer>()) // key를 바꿔서 양방향으로도 검사
						.add(a);
				}
			}
		}
		
		private void dfs(int now) { // 스택방식의 dfs
			visited.add(now); // 1번 컴퓨터 부터 따라감
			adjList
				.getOrDefault(now, new HashSet<>()) // key를 검색해서 가져옴 없으면 기본 set을 반환(null반환을 방지하기 위해)
				.stream() // stream 화
				.filter(next -> !visited.contains(next)) // 방문한곳에 없는것을 필터링해서 반환
				.forEach(next -> dfs(next)); // 방문한곳이 없는것들을 방문해서 따라감
		}
		
		private void bfs(int n) {
			q.add(n); // 큐에 처음방문하는곳을 넣음 (여기서는 1)
			while (!q.isEmpty()) { // 큐가 비지않았다면
				int now = q.poll(); // 큐의 헤드를 반환
				visited.add(now); // 헤드를 방문한곳에 넣음
				adjList
					.getOrDefault(now, new HashSet<>()) // 방문하는곳에 연결된 장소들이 있는지 검색
					.stream() // stream화
					.filter(next -> !visited.contains(next)) // 방문한곳에 있는지 필터링해서 없는것들 반환
					.forEach(next -> q.add(next)); // 없는것들을 큐에 넣어줌
			}
		}
		
		public int numOfDefect() {
//			dfs(1);
			bfs(1);
			visited.remove(1);
			return visited.size();
		}
	}

}
