package backAlgo;
/**
 * 문제
서울의 오늘 날짜를 출력하는 프로그램을 작성하시오.

입력
입력은 없다.

출력
서울의 오늘 날짜를 "YYYY-MM-DD" 형식으로 출력한다.
@see https://www.acmicpc.net/problem/10699
 */
import java.util.Calendar;

class PrintToday {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH) + 1;
		int dd = cal.get(Calendar.DAY_OF_MONTH);
		
		System.out.printf("%04d-%02d-%02d", yy, mm, dd);
		
	}

}
