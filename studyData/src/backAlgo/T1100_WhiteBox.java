package backAlgo;

import java.util.Scanner;

class WhiteBox {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {

			char[][] chessPlate = new char[8][8];
			int ans = 0;

			for (int i = 0; i < 8; i++) {
				String chessPlateLine = scan.nextLine();

				for (int j = 0; j < 8; j++) {
					chessPlate[i][j] = chessPlateLine.charAt(j);
					
					if ((i + j) % 2 == 0 && chessPlate[i][j] == 'F') ans++;
				}
			}
			System.out.println(ans);
		}
	}
}
