package backAlgo;

import java.util.Scanner;

class FindAlphabet {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			char[] arr = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
			String a = s.nextLine();
			for(int i =0; i < arr.length; i++){
				int count = 0;
				int count2 = 0;
				for(int j = 0; j < a.length(); j++){
					if(arr[i] == a.charAt(j)){
						count = j;
						if(count == 0){
							count2++;
						}
					}
				}
				if(count == 0 && count2 == 0){
					System.out.print("-1" + " ");
				}else if (count !=0 || count2 !=0){
					System.out.print(a.indexOf(a.charAt(count)) + " ");
				}
			}
		}
	}
}
