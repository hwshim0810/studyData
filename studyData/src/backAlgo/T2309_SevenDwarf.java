package backAlgo;
/** 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.

아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.

아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
@see https://www.acmicpc.net/problem/2309 
**/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class SevenDwarf {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int[] dwarfs = new int[9]; // 9명의 난쟁이를 입력받을 배열
			Random random = new Random(); // 난수 생성객체
			
			for(int i = 0; i < 9; i++) {
				dwarfs[i] = scan.nextInt(); // 9명의 난쟁이를 입력받는다.
			}
			
			List<Integer> ranArr = new ArrayList<Integer>(); // 난수 인덱스를 저장할 리스트
			int sum = 0, count = 0; // 키의 합계 변수와 계산한 난쟁이를 카운트 할 변수
			
			while(true) {
				int ranNum = random.nextInt(9); // 0에서 9까지 난수를 생성
				
				if(count < 7) { // 난쟁이 7명 체크가 되지않았다면
					sum += dwarfs[ranNum]; // 9명중 랜덤으로 하나를 뽑아 더함
					
					if(ranArr.contains(ranNum)) { // 뽑은번호가 리스트에있으면 더한건 취소
						sum -= dwarfs[ranNum];
					} else {
						ranArr.add(ranNum); // 없다면 리스트에 인덱스를 추가하고 인원수 카운트
						count++;
					}
				}
				
				if(count == 7 && sum != 100) { // 7명이됬지만 키가 100이 안되었다면
					ranArr = new ArrayList<Integer>(); // 난수 인덱스를 초기화
					sum = 0;
					count = 0; // 합계와 인원수도 초기화
					continue; // 다시 처음부터 반복
					
				} else if(count == 7 && sum == 100) { // 7명이 되었고 키도 100이라면
					break; // 나감.
					
				} else {
					continue; // 아직 덜 모였다면 처음부터 진행
				}
			}
			
				int[] selectDwarf = new int[7]; // 7명의 난쟁이들을 정렬할 배열생성
				
				for(int i = 0; i < 7; i++) {
					selectDwarf[i] = dwarfs[ranArr.get(i)]; // 랜덤하게 뽑은 인덱스를 리스트에서 꺼내어 인덱스에 맞는 난쟁이 델고옴
				}
				
				Arrays.sort(selectDwarf); // 오름차순 정렬
				
				for(int e : selectDwarf) System.out.println(e); // 한명씩 출력
		}
	}

}
