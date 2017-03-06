package backAlgo;

import java.util.Scanner;

class OneTwoThree {
	private static int find(int num, int origin, int sum) {
		
		if(num >= 3) {
			sum += 3;
			return find(num - 3, origin, sum);
		}
		else if(num >= 2) {
			sum += 2;
			return find(num - 2, origin, sum);
		}
		else if(num >= 1){
			sum += 1;
			return find(num - 1, origin, sum);
		}
		
		if(origin == sum) return sum;
		
		return sum;
	}
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int rpt = scan.nextInt();
			
			for(int i = 0; i < rpt; i++) {
				int num = scan.nextInt();
				System.out.println(find(num, num, 0));
			}
		}
	}

}
