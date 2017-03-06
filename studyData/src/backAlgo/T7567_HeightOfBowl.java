package backAlgo;
/**
 * 문제
그릇을 바닥에 놓았을 때 그 높이는 10cm 이다. 그런데 두 개의 그릇을 같은 방향으로 포개면 그 높이는 5cm만 증가된다. 만일 그릇이 서로 반대방향으로 쌓이면 높이는 그릇만큼, 
즉 10cm 늘어난다. 그릇을 괄호 기호로 나타내어 설명해보자. 편의상 그릇이 쌓여지는 방향은 왼쪽에서 오른쪽이라고 가정한다. 
그림에서 ‘(’은 그릇이 바닥에 바로 놓인 상태를 나타내며, ‘)’은 그릇이 거꾸로 놓인 상태를 나타낸다.
여러분은 입력에 주어진 모양대로 그릇을 쌓을 때 최종의 전체 그릇 높이를 계산해서 출력해야 한다. 즉 처음 입력으로 주어진 각 그릇의 방향은 바꿀 수 없다. 

입력
첫 줄에는 괄호문자로만 이루어진 문자열이 주어진다. 입력 문자열에서 열린 괄호 ‘(’은 바로 놓인 그릇, 닫힌 괄호 ‘)’은 거꾸로 놓인 그릇을 나타난다. 문자열의 길이는 3이상 50 이하이다.

출력
여러분은 그릇 방향이 괄호 문자로 표시된 문자열을 읽어서 그 최종의 높이를 정수로 출력해야 한다.
@see https://www.acmicpc.net/problem/7567
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HeightOfBowl {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String bowls = br.readLine(); // 그릇 현 상태를 문자열로 입력받음
		
		char bowl = ' '; // 그릇을 하나씩 빼서 넣을 변수
		int height = 0;
		
		for(int i = 0; i < bowls.length(); i++) {
			
			if(i == 0) { // 반복문 초기화
				bowl = bowls.charAt(i);
				height = 10;
			} else if(bowl == bowls.charAt(i)) { // 모양이 같으면 5cm 추가
				height += 5;
			} else {
				bowl = bowls.charAt(i); // 다르면 10cm추가
				height += 10;
			}
			
		}
		System.out.println(height);
	}

}
