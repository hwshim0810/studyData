package backAlgo;

import java.util.Scanner;

class RepeatString {

	public static void main(String[] args) {
		try(Scanner s = new Scanner(System.in)){
			int num = Integer.parseInt(s.nextLine());
			for(int i = 0; i < num; i++){
				String[] line = s.nextLine().split(" ");
				int Rnum = Integer.parseInt(line[0]);
				String str = line[1];
				StringBuilder stringbulider = new StringBuilder();
				for(int j = 0; j < str.length(); j++){
					for(int k = 0; k < Rnum; k ++){
						stringbulider.append(str.charAt(j));
					}
				}
				System.out.println(stringbulider.toString());
			}
		}
	}
}
