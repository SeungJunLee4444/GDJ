package ex02_datetime;

import java.util.Calendar;

public class Ex04_Calendar {

	public static void main(String[] args) {
		
		// [클래스 종류]
		// 4. java.util.Calendar 클래스
			// 용도 : 현재날짜나 특정날짜 표현
			// => 날짜의 특정요소(년,월,일,시,분,초)를 쉽게 사용할 수 있음(앞의 date클래스와는 다른점)
		
		// ex)
		Calendar cal = Calendar.getInstance(); // 객체 cal은 현재날짜와 시간으로 구성
		System.out.println(cal);
			// 형태: 클래스 + 객체(오브젝트) =
			// 클래스는 선택해야함
			// => 이유 : 직접 입력하면 import를 불러오지 않기 때문
	
			// * 자바에서는 기본타입 8개를 제외하면 전부 클래스타입이다
		
		// ex)
			// 년, 월, 일
			// int year = cal.get(1); => 원래는 클래스파일에 직접 들어가 상수값을 입력해야함
		
		// (1) 년
		int year = cal.get(Calendar.YEAR); // => 상수값을 호출하는 방법
			// * 이유: 사람들은 숫자를 잘 못외운다 ex) ip주소를 못외우니 domain주소로 바꿈(네이버)
		
		// (2) 월
		int month = cal.get(Calendar.MONTH);
		
		// (3) 일
		int date = cal.get(Calendar.DAY_OF_MONTH); // 5, 한달 중에 몇번째 일인지
		
		// (4) 요일
		int weekNo = cal.get(Calendar.DAY_OF_WEEK); // 일주일 기준 몇번째 날짜
		
		System.out.println(year);
		System.out.println(month + 1); // * 월은 하나씩 적게 출력된다 / 반환값이 0~11
		System.out.println(date);
		switch(weekNo) {
		case 1: System.out.println("일요일");
		case 2: System.out.println("월요일");
		case 3: System.out.println("화요일");
		case 4: System.out.println("수요일");
		case 5: System.out.println("목요일");
		case 6: System.out.println("금요일");
		default: System.out.println("토요일");
		}
		
		// * 일(1), 월(2) ~ 토(7) => if,switch를 이용해 요일로 표현할 수 있음
		
		
		// * 초록색 글자는 평소에는 함수, 클래스와 사용되면 메소드라 부른다(자바에서는 대체로 메소드)
		// => 객체의 기능을 메소드라 말한다
		
		// * ctrl + 클래스 클릭 => 해당 클래스 파일 열람 가능
		// => 여기서 해당 필드값을 찾아내 입력 
		
		// * 상수 : 변하지 않는 값
					
		
		// 오전/ 오후 시, 분, 초
		// (5) 오전오후
		int ampm =cal.get(Calendar.AM_PM); // 오전은 0, 오후는 1
		
		// (6) 시
		int hour12 = cal.get(Calendar.HOUR); // 시(1~12)
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); // 시0시부터 23시까지(공공기관)
		
		// (7) 분
		int minute = cal.get(Calendar.MINUTE); // 0~59분
		
		// (8) 초
		int second = cal.get(Calendar.SECOND);
		
		switch(ampm) {
		case 0 : System.out.println("오전"); break;
		case 1 : System.out.println("오후"); break;
		} 
		System.out.println(hour12);
		System.out.println(hour24);
		System.out.println(minute);
		System.out.println(second);
		
		// 캘린더를 이용한 timestamp값 구하기
		long timestamp = cal.getTimeInMillis();
		System.out.println(timestamp); 
		
		// & 정리
		// ctrl + 클래스를 클릭하면 클래스 파일을 확인할 수 있다
	
		
	
		
	}

}
