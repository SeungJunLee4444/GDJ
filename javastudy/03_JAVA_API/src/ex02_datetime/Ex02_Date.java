package ex02_datetime;

import java.util.Date; // => import *

public class Ex02_Date {

	public static void main(String[] args) {
		
		// 3. 클래스 명명 규칙
		// 기본적으로 클래스를 부를 때는 패키지를 먼저 불러야함
		// => package.class명.메소드
		
		// java.lang.System.out.print
		// => 보통은 사용안하고 나중에 써야하는 예외적인 경우 있음
		
		// java.util 패키지의 Date 클래스
		// 1. java.util.Date (원래방법)
		
		// 2. import.java.util.Date;
		//    Date => 자바에서 자동으로 import를 진행시킴
		
		// * 예외규칙
		// java. lang 패키지에 소속된 클래스들은 원래 패키지를 생략할 수 있다
		// => import같은 애들이 필요없음
		
		//--------------------------------------------------------------------
		
		// 4. 클래스와 객체
		// 1) 클래스 : 객체를 만들기 위한 설계도
		// 2) 객체 : 클래스를 이용해서 만든 실제 객체
		// 3) 일반적인 객체 생성방법
			//클래스 객체 = new 클래스();
		
		// 4) 메소드 사용 방법 2가지
		// (1) 클래스를 이용해서 호출 => 기존에 하던 방식
		// System.out.println()
		// System.currentTimeMillis()
		// System.nanoTime()
		// Math.random()
		
		// (2) 객체를 이용해서 호출
		// String str = new String("Hello") // 클래스는 String, 객체는 str
		// str.euqls("hello") => str과 같은 문자열이냐?
		
		// Date now = new Date(); // 클래스 이름이 Date, 객체이름은 now
		// now.getMonth()
		
		// StringBuilder sb = new StringBuilder // 클래스이름이 StringBuilder, 객체이름은 sd
		// sb.append()
		
		// => 이런식으로 객체를 만들어 메소드를 호출해야 하는 경우가 있음
		
		// 5. Date 클래스와 now 객체
		// => 객체는 변수같은 것으로 임의로 이름지어도됨
		
		Date now = new Date(); // now는 date 클래스를 참조하여 정보를 출력
		System.out.println(now);
		// 참조타입 = 클래스?
		
	}

}
