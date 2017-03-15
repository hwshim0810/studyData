package backAlgo;

import java.util.Scanner;

public class T2908_SangSu {
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			StringBuffer buffer = new StringBuffer(scan.nextLine());
			
			String[] strArr = buffer.reverse().toString().split(" ");
			int num0 = Integer.parseInt(strArr[0]);
			int num1 = Integer.parseInt(strArr[1]);
			
			int result = num0 > num1? num0:num1; 
			System.out.println(result);
		}
	}
}
