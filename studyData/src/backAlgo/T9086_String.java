package backAlgo;

import java.util.Scanner;
/**
 * 문제
문자열을 입력으로 주면 문자열의 첫 글자와 마지막 글자를 출력하는 프로그램을 작성하시오.

입력
입력의 첫 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 10)가 주어진다. 각 테스트 케이스는 한 줄에 하나의 문자열이 주어진다. 문자열은 알파벳 A~Z 대문자로 이루어지며 알파벳 사이에 공백은 없으며 문자열의 길이는 1000보다 작다.

출력
각 테스트 케이스에 대해서 주어진 문자열의 첫 글자와 마지막 글자를 연속하여 출력한다.

예제 입력  복사
3
ACDKJFOWIEGHE
O
AB
예제 출력  복사
AE
OO
AB
 * @author user
 * @see https://www.acmicpc.net/problem/9086
 */
public class T9086_String {
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int rpt = Integer.parseInt(scan.nextLine());
			
			for (int i = 0; i < rpt; i++) {
				char[] arr = scan.nextLine().toCharArray();
				System.out.println(String.valueOf(arr[0]) + String.valueOf(arr[arr.length-1]));
			}
		}
	}
}
