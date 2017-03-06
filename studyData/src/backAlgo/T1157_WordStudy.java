package backAlgo;
/**
 * 문제
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

입력
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

출력
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
@see https://www.acmicpc.net/problem/1157
 */
import java.util.Scanner;

class WordStudy {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			String str = scan.nextLine().toUpperCase(); // 문자열을 입력받고 대문자로 전환
			char[] arr = str.toCharArray(); // 배열로 전환
			int[] ans = new int[26]; // 갯수를 표현할 배열 생성

			for (int i = 0; i < arr.length; i++) {
				ans[arr[i] - 'A']++; // ascii 코드의 a가 97이므로 97을 뺀 번호의 인덱스값 증가
									// ascii 코드의 A가 65이므로 65을 뺀 번호의 인덱스값 증가
			}
			
			int max = ans[0]; // 최대값을 구하기위해 비교할 숫자(증가된 배열의 첫번째값)
			int maxIndex = 0; // 최대값의 인덱스
			int count = 0; // 최대값의 갯수 카운트
			
			for(int i = 1; i < ans.length; i++) {
				if(ans[i] > max) { // 계산된 글자들의 갯수배열을 돌면서 최대값을 찾아 최대값과 최대값 인덱스를 저장
					max = ans[i];
					maxIndex = i;
				} 
			}
			
			for(int i = 0; i < ans.length; i++) {
				if(ans[i] == max) count++; // 구해진 최대값을 배열을 돌면서 갯수를 확인
			}
			
			if(count < 2) { // 최대값이 하나라면
				char ch = (char)(maxIndex + 'A');
				System.out.println(ch); // 아스키코드를 이용해서 바꾼다음 출력
			} 
			else
				System.out.println("?"); // 아니라면 ?를 출력

		}
	}

}
