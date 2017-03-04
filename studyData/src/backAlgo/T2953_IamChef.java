package backAlgo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class IamChef {
	
	/** Map콜렉션과 값을 넣어서 값에 해당하는 키를 찾는 메소드*/
	public static Object getKeyFromValue(Map hm, Object value) {
		  for (Object o : hm.keySet()) {	//맵의 키를 set(집합)으로 하나씩 반환
		    if (hm.get(o).equals(value)) {  //반환된 키의 값을 꺼내서 입력한 값과 비교
		      return o;	//같다면 키를 반환
		    } 
		  }
		  return null;
		}

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			Map<Integer,Integer> map = new HashMap<Integer,Integer>();
			int max = 0;
			
			for (int i = 1; i <= 5 ; i++) {	//입력한 값을 더해 순서대로 집어넣고 최대값을 산출함
				int temp = scan.nextInt() + scan.nextInt() + scan.nextInt() + scan.nextInt();
				if(temp > max) max = temp;
				map.put(i, temp);
			}
			
			int rank = (int) getKeyFromValue(map, max); //최대값에 해당하는 키를 맵에서 찾아봄
			
			System.out.printf("%d %d", rank, max);
		}
	}
}
