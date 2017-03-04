package backAlgo;

import java.util.Scanner;

class MaxNumber {
	
	public static int MaxGongyak(int num1, int num2) {
		
		if(num2 == 0)return num1;
		
		return MaxGongyak(num2, num1%num2);
		
	}

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {

			int num1 = scan.nextInt();
			int num2 = scan.nextInt();
			
			int gongyak = MaxGongyak(num1, num2);
			int gongbae = (num1 * num2) / gongyak;
			System.out.println(gongyak);
			System.out.println(gongbae);
			
		}
	}
}
