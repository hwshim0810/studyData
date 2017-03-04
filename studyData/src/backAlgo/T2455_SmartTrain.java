package backAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SmartTrain {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			
			int sum = 0, in = 0, out = 0, ans = 0;
			ArrayList<Integer> ansList = new ArrayList<Integer>();
			
			for(int i = 0; i < 4; i++) {
				out = scan.nextInt();
				in = scan.nextInt();
				
				sum -= out;
				sum += in;
				ansList.add(sum);
			}
			Collections.sort(ansList);
			
			ans = ansList.get(3);
			System.out.println(ans);
		}
	}
}
