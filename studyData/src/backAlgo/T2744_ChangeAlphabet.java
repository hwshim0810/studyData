package backAlgo;
/**
 * 문제
영어 소문자와 대문자로 이루어진 단어를 입력받은 뒤, 대문자는 소문자로, 소문자는 대문자로 바꾸어 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 영어 소문자와 대문자로만 이루어진 단어가 주어진다. 단어의 길이는 최대 100이다.

출력
첫째 줄에 입력으로 주어진 단어에서 대문자는 소문자로, 소문자는 대문자로 바꾼 단어를 출력한다.

예제 입력 
WrongAnswer

예제 출력 
wRONGaNSWER

@see https://www.acmicpc.net/problem/2744
 */
import java.util.Scanner;

class ChangeAlphabet {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		StringBuilder stb = new StringBuilder();
		
		scan.close();
		
		for(int i = 0; i < str.length(); ++i) {
			if(str.charAt(i) <= 90) { // 입력받은게 대문자면
				stb.append((char)(str.charAt(i) + 32)); // 소문자와 32차이 나기때문에 32를 더하는데 이때 int로 확장변환되므로 
														// char로 casting해줘야함.
			}
			else stb.append((char)(str.charAt(i) - 32));
		}
		
		System.out.println(stb.toString());
	}

}
