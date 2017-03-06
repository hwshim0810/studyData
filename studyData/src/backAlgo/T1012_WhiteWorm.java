package backAlgo;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class WhiteWorm {
	public static int search_right(int[][] arr, int row, int col) {
		if(arr[row][col+1] == 1) return 1;
		else return 0;
	}
	public static int search_left(int[][] arr, int row, int col) {
		if(arr[row][col-1] == 1) return 1;
		else return 0;
	}
	public static int search_under(int[][] arr, int row, int col) {
		if(arr[row+1][col] == 1) return 1;
		else return 0;
	}
	public static int search_up(int[][] arr, int row, int col) {
		if(arr[row-1][col] == 1) return 1;
		else return 0;
	}


	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int rpt = scan.nextInt();
			int worm_num = 0;
			Map<Entry<Integer,Integer>,Integer> itsWorm = new HashMap<>();
			
			for(int i = 0; i < rpt; ++i) {
				int m = scan.nextInt();
				int n = scan.nextInt();
				int[][] arr = new int[n][m];
				
				int location_vector = scan.nextInt();
				
				for(int j = 0; j < location_vector; ++j) arr[scan.nextInt()][scan.nextInt()] = 1;
				
				for(int row = 0; row < m; ++row) {
					for(int col = 0; col < n; ++col) {
						SimpleEntry<Integer, Integer> key = new SimpleEntry<>(row,col);
						
						if(row == 0 && col == 0) {
							if(search_right(arr, row, col) == 1) {
								SimpleEntry<Integer, Integer> rkey = new SimpleEntry<>(row,col+1);
								if(!itsWorm.containsKey(rkey)) itsWorm.put(rkey, 1);
							}
								
						}
						
					}
				}
				
			}
			
			
		}
	}

}
