package backAlgo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MakeOne {
	
	public static void main(String[] args) {
			try(Scanner scan = new Scanner(System.in)) {
				int num = scan.nextInt();
				
				System.out.println(make2(num));
		}
	}
	
	private static Map<Integer,Integer> valueMap = new HashMap<Integer, Integer>();
	
	private static int make2(int n) {
		int min = 0;
		int case1 = 987654321, case2 = 987654321, case3 = 987654321;
		
		if(valueMap.containsKey(n)) return valueMap.get(n);
		
		if (n == 1) return 0;
		
		if (n % 3 == 0) case1 = 1 + make2(n / 3);
		if (n % 2 == 0) case2 = 1 + make2(n / 2);
		case3 = 1 + make2(n - 1);
		
		min = Math.min(case1, case2);
		min = Math.min(min, case3);
		
		valueMap.put(n, min);
		return min;
	}
}