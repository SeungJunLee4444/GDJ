package ex02_datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex05_LocalDateTime {

	public static void main(String[] args) {
		
		// 5. java.time.LocalDateTime 클래스
			// jdk 1.8부터 사용할 수 있음
			// 특정 날짜 요소 사용 가능
			// 날짜의 패턴 지정이 가능
			// * calendar보다 효율적이나 아직 과도기
		
			// * ctrl + 스페이스바 : 메소드 추천목록
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		// => 현재 날짜와 시간 *
		
		// 1) 용도
			// (1) 특정날짜요소 사용
		int year = now.getYear();
			// Calendar보다 더 직관적이다/좀더 쉬운 방식
		int month = now.getMonthValue(); // 1~12 month가 아니라 monthvalue를 선택해야함
			// Calendar처럼 +1할 필요없음
		int day = now.getDayOfMonth(); // 1~31
//		int day2 = now.getDayOfWeek(); // int타입으로 반환 불가능
		int hour = now.getHour();
		
		int minute = now.getMinute();
		int second = now.getSecond();
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(hour);
//		System.out.println(day2);
		System.out.println(minute);
		System.out.println(second);
		
		System.out.println(now);
		// => 위의 모든 값을 한꺼번에 출력
		
		// (2) 출력할 날짜의 패턴 지정
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("a h:mm yyyy-MM-dd");
		// => 패턴이 적용되면 시간타입이 아니라 String타입이 된다
		
		String date = dtf.format(now); //format은 형식, 형식을 string타입에 저장
		System.out.println(date);
		
		
		
		
		
		
		
		
		
		

	}

}
