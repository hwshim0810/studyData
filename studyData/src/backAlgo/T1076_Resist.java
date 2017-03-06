package backAlgo;
/**
 * 전자 제품에는 저항이 들어간다. 저항은 색 3개를 이용해서 그 저항이 몇 옴인지 나타낸다.

처음 색 2개는 저항의 값이고, 마지막 색은 곱해야 하는 값이다.

저항의 값은 다음 표를 이용해서 구한다.

색	값	곱
black	0	1
brown	1	10
red	2	100
orange	3	1000
yellow	4	10000
green	5	100000
blue	6	1000000
violet	7	10000000
grey	8	100000000
white	9	1000000000
예를 들어, 저항에 색이 yellow, violet, red였다면 저항의 값은 4,700이 된다.

입력
첫째 줄에 첫번째 색, 둘째 줄에 두번째 색, 셋째 줄에 세번째 색이 주어진다. 색은 모두 위의 표에 써 있는 색만 주어진다.

출력
첫째 줄에 입력을 주어진 저항의 저항값을 출력한다.

예제 입력 
yellow
violet
red

예제 출력 
4700

@see https://www.acmicpc.net/problem/1076
 */
import java.util.Scanner;

class Resist {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			StringBuilder stb = new StringBuilder();
			
			for(int i = 0; i < 3; ++i) {
				String str = scan.nextLine();
				long num = 0;
				
				switch (str) {
				case "black":
					num = 0;
					break;
				
				case "brown":
					num = 1;
					break;
				
				case "red":
					num = 2;
					break;

				case "orange":
					num = 3;
					break;

				case "yellow":
					num = 4;
					break;

				case "green":
					num = 5;
					break;

				case "blue":
					num = 6;
					break;

				case "violet":
					num = 7;
					break;

				case "grey":
					num = 8;
					break;

				case "white":
					num = 9;
					break;
				default:
					break;
				}
				
				if(i < 2) stb.append(num);
				else {
					System.out.println((long)(Integer.parseInt(stb.toString()) * Math.pow(10, num)));
				}
				
			}
		}
	}

}
