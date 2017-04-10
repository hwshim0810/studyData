package designpattern;

public class Singleton {
	private static Singleton current;

	public static Singleton getInstance() {
		if (current == null) {
			current = new Singleton();
		}
		return current;
	}

	public static void freeInstance() {
		// 객체에 null을 대입하면 메모리에서 삭제된다.
		current = null;
	}

	// 기본 생성자를 private로 은닉하게 되면 new를 통한 객체 생성이 금지된다.
	private Singleton() {
		super();
	}
	
	/**
	 * @param min - 범위안의 최소값
	 * @param max - 범위안의 최대값
	 * @return min~max안의 랜덤값
	 */
	public int random(int min, int max){
		int num = (int) ((Math.random() * (max - min + 1)) + min);
		return num;
	}
	
	public static void main(String[] args) {
		String authNum = "";
		
		for (int i = 0; i < 5; ++i)
			authNum += Singleton.getInstance().random(0, 9);
		System.out.println("인증번호 = "+authNum);
	}

}

