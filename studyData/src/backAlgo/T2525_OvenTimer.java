package backAlgo;

import java.util.Scanner;

class OvenTimer {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int hour = scan.nextInt();
			int minute = scan.nextInt();
			int addtime = scan.nextInt();
			
			hour += (addtime / 60);
			minute += (addtime % 60);
			
			if(minute >= 60) {
				hour += (minute / 60);
				minute = minute % 60;
			}
			
			if(hour >= 24) {
				hour = hour % 24;
			}
			
			System.out.printf("%d %d", hour, minute);
		}
	}

}
