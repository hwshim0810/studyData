package backAlgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cmd {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			
			List<String> lst = new ArrayList<String>();
			StringBuilder stb = new StringBuilder();
			boolean flag = true;
			
			int rpt = Integer.parseInt(scan.nextLine()); //테스트 케이스를 입력받는다.
			
			for(int i = 0; i < rpt; ++i) lst.add(scan.nextLine()); //파일명들을 리스트에 추가
			
			int strLength = lst.get(0).length(); //파일의 길이는 모두같다고했기때문에 하나에서 길이추출
			
			for (int i = 0; i < strLength; ++i) { //파일명 만큼 1차반복

				for (int j = 1; j < rpt; ++j) { //테스트 케이스만큼 2차반복
					if (lst.get(0).charAt(i) != lst.get(j).charAt(i)) { //첫번째파일명의 첫번째글자와 줄단위로 비교
						flag = false; //만약 틀린글자가있다면 더 비교할필요없음
						break;
					}
				}
				
				if(flag) { // 틀린글자가 없었다면 비교한 글자를 따로 스트링빌더에 추가
					stb.append(lst.get(0).charAt(i));
				} else {
					stb.append("?"); //틀린글자가있었다면 ?로 추가
				}
				flag = true; //플래그를 원상태로
			}

			System.out.println(stb.toString());
		}
	}

}
