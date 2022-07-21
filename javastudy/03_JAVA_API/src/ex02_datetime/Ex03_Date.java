package ex02_datetime;

import java.sql.Date;

public class Ex03_Date {

	public static void main(String[] args) {
		
		// java.sql.Date 클래스 *
		// => java sql이라는 패키지의 Date 클래스
		// * util 패키지의 Date와는 다른것
		// sql은 데이터베이스에서 나오는 말
		// 데이터베이스의 날짜 표시방식에 맞춰놓은 클래스
		// => 객체 선언후 데이터베이스에서 데이터를 받겠지?
		
		
		// oracle 데이터베이스의 날짜타입("/", "-"과 매칭해서 사용할 것
		
		Date now = new Date(System.currentTimeMillis()); // => 사용법이 틀렸다
		// => long 타입의 date값은 timeStemp뿐이다
		System.out.println(now);
		
		// 위 쓰임 안외어도됨
		
		
		
		
		
		
		
		
		
		
	}

}
