package backAlgo;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

class Maze {

	public static void main(String[] args) {
		Low lw = new Low();
		lw.init();
		System.out.println(lw.run());
		
	}
}
	
	class Low {
		private static Map<Entry<Integer,Integer>, HashSet<Entry<Integer,Integer>>> adj = new HashMap<>();
		private static HashSet<Entry<Integer,Integer>> visited = new HashSet<>();
		private static LinkedBlockingQueue<Entry<Integer,Integer>> q = new LinkedBlockingQueue<>();
		
		public void init() {
			try(Scanner scan = new Scanner(System.in)) {
				String[] nm = scan.nextLine().split(" ");
				
				int row = Integer.parseInt(nm[0]);
				int column = Integer.parseInt(nm[1]);
				
				char[][] maze = new char[row][column];
				
				for(int i = 0; i < row; ++i) {
					String str = scan.nextLine();
					for(int j = 0; j < column; ++j) {
						maze[i][j] = str.charAt(j);
					}
				}
			
			for(int i = 0; i < row; ++i) {
				for(int j = 0; j < column; ++j) {
					Entry<Integer,Integer> key = new SimpleEntry<>(i,j);
					Entry<Integer,Integer> rkey = new SimpleEntry<>(i+1,j);
					Entry<Integer,Integer> ckey = new SimpleEntry<>(i,j+1);
 					
					adj
						.computeIfAbsent(key , x -> new HashSet<Entry<Integer,Integer>>())
						.add(rkey);
					adj
						.computeIfAbsent(key , x -> new HashSet<Entry<Integer,Integer>>())
						.add(ckey);
					
					adj
						.computeIfAbsent(rkey , x -> new HashSet<Entry<Integer,Integer>>())
						.add(key);
					
					adj
						.computeIfAbsent(ckey , x -> new HashSet<Entry<Integer,Integer>>())
						.add(key);
					
				}
			}
		}
	}
			static void bfs(int i, int j) {
				Entry<Integer,Integer> key = new SimpleEntry<>(Integer.valueOf(i), Integer.valueOf(j));
				q.add(key);
				
				while(!q.isEmpty()) {
					Entry now = q.poll();
					visited.add(now);
					
					adj
						.getOrDefault(now, new HashSet<Entry<Integer,Integer>>())
						.stream()
						.filter(next -> !visited.contains(next))
						.forEach(next -> q.add(next));
				}
				
			}
			
			static int run() {
				bfs(0, 0);
//				visited.remove(1);
				return visited.size();
			}

	}	