package backAlgo;

import java.util.Scanner;

/**
 * 문제
대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.

입력
첫째 줄에는 테스트케이스 C가 주어진다.

둘째 줄부터 각 테스트케이스 마다 첫 수로 정수 N(1 <= N <= 1000)명의 학생이 주어지고 그 다음으로 N명의 0부터 100 사이의 점수가 이어서 주어진다.

출력
각 케이스마다 한줄씩 평균을 넘는 학생들의 비율을 소수점 넷째자리에서 반올림하여 출력한다.

예제 입력  복사
5
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91
예제 출력  복사
40.000%
57.143%
33.333%
66.667%
55.556%
 * @author user
 * @see https://www.acmicpc.net/problem/4344
 */
public class T4344_OverAvg {
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int rpt = scan.nextInt();
			
			for (int i = 0; i < rpt; i++) {
				int man = scan.nextInt();
				int[] scores = new int[man];
				int total = 0, count = 0;
				
				for (int j = 0; j < man; j++) {
					int score = scan.nextInt();
					scores[j] = score;
					total += score;
				}
				
				int avg = total / man;
				for (int num : scores)
					if (num > avg) ++count;
				
				System.out.printf("%.3f%%\n", (Float.valueOf(count) / Float.valueOf(man)) * 100);
			}
		}
	}
}
