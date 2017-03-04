package backAlgo;

import java.util.HashMap;
import java.util.Scanner;

public class T2747_Fibonacci {
	
	private static HashMap<Integer, Integer> memo = new HashMap<>();

	public static int fibonacci2747(int num) {
		if (memo.containsKey(num)) {
			return memo.get(num);
		} else {
			int result = fibonacci2747(num - 1) + fibonacci2747(num - 2);
			memo.put(num, result);
			return result;
		}
//		return memo.computeIfAbsent(num, key -> {
//			if (num == 0) {
//				return 0;
//			} else if (num == 1) {
//				return 1;
//			} else {
//				return fibonacci2747(num - 1) + fibonacci2747(num - 2);
//			}
//		});
	}

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int num = scan.nextInt();
			
			memo.clear();
			memo.put(0, 0);
			memo.put(1, 1);
			System.out.println(fibonacci2747(num));
		}
	}
}
