package backAlgo;

import java.util.ArrayList;
import java.util.Scanner;

class FindSosu {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int num = scan.nextInt();
			int ans = 0;
			ArrayList<Integer> arr = new ArrayList<Integer>(num);
			
			for(int i = 0; i < num; i++) {
				arr.add(scan.nextInt());
			}
			
			for(int i = 0; i < num; i++){
				if(arr.get(i) == 1) arr.set(i, 0);
				
				for(int j = 2; j < arr.get(i); j++) {
					
					if(arr.get(i) % j == 0) {
						arr.set(i, 0);
					}
				}
			}
			
			for(int n : arr) {
				if(n != 0) ans++;
			}
			System.out.println(ans);
		}
	}

}
