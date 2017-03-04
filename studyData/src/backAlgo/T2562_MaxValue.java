package backAlgo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MaxValue {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			Map<Integer, Integer> value = new HashMap<Integer, Integer>();
			int max = 0 , maxIndex = 0;
			
			for(int i = 1; i < 10; i++) {
				value.put(i, scan.nextInt());
				
				if(value.get(i) > max) {
					max = value.get(i);
					maxIndex = i;
				}
			}
			
			System.out.println(value.get(maxIndex));
			System.out.println(maxIndex);
			
		}
	}
}
