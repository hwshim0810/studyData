package backAlgo;
/**
 * 문제
1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다. 

규칙(1) 같은 눈이 3개가 나오면 10,000원+(같은 눈)*1,000원의 상금을 받게 된다. 

규칙(2) 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)*100원의 상금을 받게 된다. 

규칙(3) 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)*100원의 상금을 받게 된다.  

예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3*100으로 계산되어 1,300원을 받게 된다. 
또 3개의 눈이 2, 2, 2로 주어지면 10,000+2*1,000 으로 계산되어 12,000원을 받게 된다.
 3개의 눈이 6, 2, 5로 주어지면 그중 가장 큰 값이 6이므로 6*100으로 계산되어 600원을 상금으로 받게 된다.

3개 주사위의 나온 눈이 주어질 때, 상금을 계산하는 프로그램을 작성 하시오.

입력
첫 째 줄에 3개의 눈이 빈칸을 사이에 두고 각각 주어진다. 

출력
첫째 줄에 게임의 상금을 출력 한다.  

예제 입력 
3 3 6
예제 출력 
1300

@see https://www.acmicpc.net/problem/2480
 */
import java.util.Arrays;
import java.util.Scanner;

class ThreeDice {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int count = 0;
			int sameNum = 999;
			int[] arr = new int[3];
			
			for(int i = 0; i < arr.length; ++i) arr[i] = scan.nextInt();
			
			for(int i = 0; i < arr.length; ++i) {
				if(i == 2){
					if(arr[0] == arr[2]) {
						count++;
						sameNum = arr[0];
					}
				}else{
					if(arr[i] == arr[i+1]) {
						count++;
						sameNum = arr[i];
					}
				}
			}
			
			Arrays.sort(arr);
			
			switch (count) {
			case 3:
				System.out.println(10000 + (sameNum*1000));
				break;
				
			case 1:
				System.out.println(1000 + (sameNum*100));
				break;
			
			case 0:
				System.out.println(arr[arr.length-1] * 100);
			

			default:
				break;
			}
		}
	}

}
