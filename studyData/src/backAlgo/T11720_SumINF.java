package backAlgo;

/**
 * 문제
N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.

출력
입력으로 주어진 숫자 N개의 합을 출력한다.

예제 입력 
1
1
예제 출력 
1
예제 입력 2 
5
12345
예제 출력 2 
15

@see https://www.acmicpc.net/problem/11720
 */
import java.math.BigInteger;
import java.util.Scanner;

class SumINF {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int rpt = scan.nextInt();
			
			BigInteger sum = new BigInteger("0"); // 합계
			BigInteger[] arr = new BigInteger[rpt]; // 자리수별로 넣을 배열
			BigInteger ten = new BigInteger("10"); // 걍 10
			
			BigInteger line = scan.nextBigInteger();
			
			for(int i = rpt-1; i >= 0; --i) {
				BigInteger pow = new BigInteger("1"); 
					for(int j = 0; j < i; ++j){
						pow = pow.multiply(BigInteger.valueOf(10)); // 입력받을수를 자리수별로 뺄려고 10의 i승을 만듬
					}
				arr[i] = line.divide(pow).remainder(ten); // 10의 i승으로 나누고 10나머지로 뺌
			}
			
			for(BigInteger x : arr) sum = sum.add(x); // 더함
			
			System.out.println(sum.toString());
		}
    }
}