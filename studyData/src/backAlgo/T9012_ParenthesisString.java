package backAlgo;

import java.util.Scanner;

class ParenthesisString {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int rpt = Integer.parseInt(scan.nextLine());
			
			for(int i = 0; i < rpt; ++i) {
				String str = scan.nextLine();
				int right = 0;
				int left = 0;
				
					for(int j = 0; j < str.length(); ++j) {
						if(str.charAt(j) == '(') left++;
						else right++;
					}
				
				if(left != right) System.out.println("NO");
			}
		}
	}

}
