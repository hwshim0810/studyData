package backAlgo;
/**
 문제
알파벳 소문자로만 이루어진 단어 S가 주어진다. 이 때, 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.

출력
단어에 포함되어 있는 a의 개수, b의 개수, …, z의 개수를 공백으로 구분해서 출력한다.
@see https://www.acmicpc.net/problem/10808
 */
import java.util.Scanner;

class AlphabetNum {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			String str = scan.nextLine().toLowerCase(); //문자열을 입력받고 소문자로 전환
			char[] arr = str.toCharArray(); // 배열로 전환
			int[] ans = new int[26]; //갯수를 표현할 배열 생성
			
			for(int i = 0; i < arr.length; i++) {
				ans[arr[i] - 97]++;	//ascii 코드의 a가 97이므로 97을 뺀 번호의 인덱스로 찾아가 값 증가
			}
			
			for(int e : ans) { //출력
				System.out.printf("%d ", e);
			}

		}
	}

}
