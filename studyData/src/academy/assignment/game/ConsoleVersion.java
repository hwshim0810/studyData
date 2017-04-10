package academy.assignment.game;

import java.util.Scanner;

/**
 * @author Shim Hyun-Woo
 * @Created 2016.10
 */
public class ConsoleVersion implements GameInterface {
	static int myScore = 0;
	static int computerScore = 0;
	static int playCount = 0;
	
	private static void printResult(int myHand, int res) {
		String[] hands = {"가위", "바위", "보"};
		String[] gameResults = {"비겼습니다.", "이겼습니다.", "졌습니다."};
		String computerHand = "";
		
		++playCount;
		if (res == 1) ++myScore;
		if (res == 2) ++computerScore;
		
		switch (res) {
		case 0:
			computerHand = hands[myHand];
			break;
		case 1:
			computerHand = hands[myHand == 0 ? 2 : myHand - 1];
			break;
		case 2:
			computerHand = hands[(myHand + 1) % 3];
			break;
		}
		
		System.out.println("당신은 " + hands[myHand] + "를 냈습니다.");
		System.out.println("컴퓨터는 "+ computerHand +" 를 냈습니다.");
		System.out.println("-------------------");
		System.out.println("게임결과 : "+ gameResults[res]);
		System.out.println("===================");
	}
	
	static int getZeroToRange(int range) {
		return ((int)(Math.random() * 10)) % range ;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(">> 가위바위보 게임 <<\n");
		
		while (true) {
			System.out.print("입력 (종료는 q, 가위는 0, 바위는 1, 보는 2) : ");
			String input = scan.nextLine();
			System.out.println("-------------------");
			if (input.equalsIgnoreCase("Q")) break;
			
			int gameResult = getZeroToRange(3);
			
			try {
				int myHand = Integer.parseInt(input);
				if (myHand > 2 || myHand < 0) throw new Exception();
				
				printResult(myHand, gameResult);
				
			} catch (Exception e) {
				System.err.println("0에서 2사이의 값 혹은 알파벳 q 또는 Q를 넣어주십시오.");
				System.err.println("비정상 입력으로 인하여 게임을 종료합니다.");
				System.exit(0);
			}
		} 
		scan.close();
		
		if (playCount == 0) {
			System.out.println("게임이 이루어지지 않았습니다.\n");
			System.out.println(">> 게임 종료 <<");
			System.exit(0);
		}
		
		String winner = "비겼습니다"; 
		if (myScore > computerScore) winner = "당신 WIN!!!";
		else if (myScore < computerScore) winner = "컴퓨터 WIN!!!";

		System.out.printf("당신 %d : 컴퓨터 %d => %s \n", myScore, computerScore, winner);
		System.out.println(">> 게임 종료 <<");
	}
}
