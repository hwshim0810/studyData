package backAlgo;
/**
 * 문제
<그림 1>과 같이 9×9 격자판에 쓰여진 81개의 자연수가 주어질 때, 
이들 중 최댓값을 찾고 그 최댓값이 몇 행 몇 열에 위치한 수인지 구하는 프로그램을 작성하시오.

입력
첫째 줄부터 아홉 번째 줄까지 한 줄에 아홉 개씩 자연수가 주어진다. 주어지는 자연수는 100보다 작다.

출력
첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 위치한 행 번호와 열 번호를 빈칸을 사이에 두고 차례로 출력한다. 최댓값이 두 개 이상인 경우 그 중 한 곳의 위치를 출력한다.

예제 입력 
3 23 85 34 17 74 25 52 65
10 7 39 42 88 52 14 72 63
87 42 18 78 53 45 18 84 53
34 28 64 85 12 16 75 36 55
21 77 45 35 28 75 90 76 1
25 87 65 15 28 11 37 28 74
65 27 75 41 7 89 78 64 39
47 47 70 45 23 65 3 41 44
87 13 82 38 31 12 29 29 80

예제 출력 
90
5 7

@see https://www.acmicpc.net/problem/2566
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SecondDimentionMax {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int maxRow = 0;
		int maxCol = 0;
		int maxVal = 0;
		List max = null;
		
		List[] arr = new List[9]; // 리스트를 저장할 배열(9줄)
		
		for(int i = 0; i < 9; ++i) {
			List<Integer> list = new ArrayList<>(); // 값을 저장할 리스트(1행 9열)
			
			for(int j = 0; j < 9; ++j) {
				list.add(scan.nextInt());
			}
			arr[i] = list; // 1줄 추가
		}
		
		scan.close();
		
		for(List x : arr) { // 배열에서 1줄씩 꺼냄
			for(int i = 0; i < x.size(); ++i) {
				// 1줄에서 값을꺼내서 최대값을 찾음
				if(Integer.parseInt(x.get(i).toString()) > maxVal) { 
					maxVal = Integer.parseInt(x.get(i).toString());  // 최대값
					maxCol = i; // 열번호
					max = x; // 최대값이 있는 줄
				}
			}
			// 최대값이 있는 줄의 번호를 찾아냄
			for(int j = 0; j < arr.length; ++j) if(arr[j] == max) maxRow = j;
		}
		
		System.out.println(maxVal);
		System.out.printf("%d %d", maxRow+1, maxCol+1);
	}

}
