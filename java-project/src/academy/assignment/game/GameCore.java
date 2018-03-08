package academy.assignment.game;

/**
 * @author Shim Hyun-Woo
 * @Created 2016.11
 */
class GameCore implements GameInterface {
	static int myScore = 0;
	static int computerScore = 0;
	static int playCount = 0;
	static final String[] HANDS = {"가위", "바위", "보"};
	static final int[] NUM_HANDS = {0, 1, 2};
	static final String[] gameResults = {"비겼습니다.", "이겼습니다.", "졌습니다."};
	
	public static int printResult(int myHand, int gameResult) {
		int computerHand = 0;
		
		++playCount;
		if (gameResult == 1) ++myScore;
		if (gameResult == 2) ++computerScore;
		
		switch (gameResult) {
		case 0:
			computerHand = myHand;
			return computerHand;
		case 1:
			computerHand = NUM_HANDS[myHand == 0 ? 2 : myHand - 1];
			return computerHand;
		case 2:
			computerHand = NUM_HANDS[(myHand + 1) % 3];
			return computerHand;
		default :
			return -1;
		}
	}
	
	static int getZeroToRange(int range) {
		return ((int)(Math.random() * 10)) % range ;
	}
}
