package backAlgo;

import java.util.Scanner;

class MinGongbae {
	
	public static int MinGongbae(int num1, int num2) {
		
		if(num2 == 0)return num1;
		
		return MinGongbae(num2, num1%num2);
		
	}

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {
			int num = scan.nextInt();
			
			for(int i = 0; i < num; i++) {
				
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();
			
			int gongyak = MinGongbae(num1, num2);
			int gongbae = (num1 * num2) / gongyak;
			
			System.out.println(gongbae);
			}			
		}
	}
}
