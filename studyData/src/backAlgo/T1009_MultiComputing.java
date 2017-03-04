package backAlgo;

import java.util.Scanner;

class MultiComputing {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			
			int rptNum = scan.nextInt();
			int dataNum = 0;
			
			for(int i = 0; i < rptNum; i++) {
				double mit = scan.nextInt();
				double jisu = scan.nextInt();

//				if(jisu % 4 == 1) dataNum = (int)Math.pow(mit, 1) % 10;
//				else if(jisu % 4 == 2) dataNum = (int)Math.pow(mit, 2) % 10;
//				else if(jisu % 4 == 3) dataNum = (int)Math.pow(mit, 3) % 10;
//				else dataNum = (int)Math.pow(mit, 4) % 10;
//				
//				if(dataNum == 0) dataNum = 10;
				
				int n = 1;
				int m = (int) mit;
				for (int j = 0; j < (int) jisu; j++) {
					n *= m;
					n %= 10;
				}
				dataNum = n;
				
				System.out.println(dataNum);
			}
		}
	}
}
