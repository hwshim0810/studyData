package backAlgo;
/**
 * 문제
배열을 정렬하는 것은 쉽다. 숫자가 주어지면, 그 숫자의 각 자리수를 내림차순으로 정렬해보자.

입력
첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같다.

출력
둘째 줄에 숫자의 자리수를 내림차순으로 정렬한 수를 출력한다.

예제 입력 
2143
예제 출력 
4321
@see https://www.acmicpc.net/problem/1427
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class SortInside {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine(); // 숫자를 문자로 입력받음
		scan.close();
		
		int rpt = str.length(); // 문자열 길이로 자리수 추출
		int num = Integer.parseInt(str); // 숫자로 바꿔줌
		
		List<Integer> list = new ArrayList<Integer>(); // 정렬을 위해서 리스트를 만듬
		
		for(int i = rpt; i >= 2; --i) { // 10의 자리까지 추출해서 리스트에 추가
			if(i == rpt) {
				int n = num / ((int)Math.pow(10, i-1));
				list.add(n);
			} else {
				int n = num / ((int)Math.pow(10, i-1)) % 10;
				list.add(n);
			}
		}
		
		list.add(num % 10); // 일의 자리 리스트에 추가
		
		Collections.sort(list);
		Collections.reverse(list); // 정렬 후 뒤집기
		list.toArray(); // 배열변환
		
		for(int e : list) System.out.printf("%d", e); //배열 출력
	}

}
