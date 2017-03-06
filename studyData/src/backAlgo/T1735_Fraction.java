package backAlgo;
/**
 * 문제
분수 A/B는 분자가 A, 분모가 B인 분수를 의미한다. A와 B는 모두 자연수라고 하자.

두 분수의 합 또한 분수로 표현할 수 있다. 두 분수가 주어졌을 때, 그 합을 기약분수의 형태로 구하는 프로그램을 작성하시오. 기약분수란 더 이상 약분되지 않는 분수를 의미한다.

입력
첫째 줄과 둘째 줄에, 각 분수의 분자와 분모를 뜻하는 두 개의 자연수가 순서대로 주어진다. 입력되는 네 자연수는 모두 30,000 이하이다.

출력
첫째 줄에 구하고자 하는 기약분수의 분자와 분모를 뜻하는 두 개의 자연수를 빈 칸을 사이에 두고 순서대로 출력한다.

예제 입력 
2 7
3 5
예제 출력 
31 35

@see https://www.acmicpc.net/problem/1735
 */
import java.util.Scanner;

class Fraction {
	// 유클리드 호제법...나머지로 제수를 나누어갈때 몫이 0일때의 제수가 최소공약수
	private static int find(int a, int b) {
		if(b == 0) return a;
		return find(b, a%b);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a1 = scan.nextInt();
		int a2 = scan.nextInt();
		int b1 = scan.nextInt();
		int b2 = scan.nextInt();
		scan.close();
		
		int n2 = a2 * b2; // 최소공배수? 이자 분모
		
		int ab_up = (a1 * (n2 / a2)) + (b1 * (n2 / b2)); // 최소공배수?에 맞춘 분자계산
		
		int gongyak = find(ab_up, n2); // 최대공약수 계산
		
		if(n2 % gongyak == 0) System.out.printf("%d %d", ab_up/gongyak, n2/gongyak);
		else System.out.printf("%d %d", ab_up, n2);
		
	}

}
