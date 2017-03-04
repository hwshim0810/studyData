package backAlgo;

import java.util.Scanner;

class PlusCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner scan = new Scanner(System.in)){
			
			int N = scan.nextInt();
			int ans = 0, newN = 0, num10 = 0 ,num1 = 0, compare = 0;
			String temp;
			
			newN = N;
			while(true){
				
				int sum = 0;
				
				num10 = newN/10;
				num1 = newN%10;
				
				sum = num10 + num1;
				temp = String.valueOf(num1) + String.valueOf(sum%10);
				compare = Integer.parseInt(temp);
				ans++;
				
				if (compare == N) break;
				
				newN = Integer.parseInt(temp);
				
			}
			System.out.println(ans);
		}
	}
}
