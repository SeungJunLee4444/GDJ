package ex01_field;


public class UserMain {
	
	int a; // => 0으로 초기화

	public static void main(String[] args) {
		
		int b;
		// System.out.println(a); // Main 메소드라 실행 안되는 것 , 초기값 : 0
		
		// 2) 클래스 user : 데이터타입
		// => 객체를 만들기 위한 수단
		// => 정보를 담고있는 것이 
		// 3) 객체 user : 변수명
		
		// 1. 생성과정
		// 1). 객체 선언
		// User user = null;
		
		// 2). 객체 생성
		// user = new User();	
		// 선언과 생성은 위처럼 나눠서도, 한꺼번에 할 수 있다 *
		// => 
		User user = new User();
		
		// 3) 모든 User 객체는 필드값을 가지고 있다
		// 마침표(.)를 이용해서 필드값을 호출한다
		System.out.println(user.id);
		System.out.println(user.pw);
		System.out.println(user.email);
		System.out.println(user.point);
		System.out.println(user.isVip);
		
		// 4) 필드값 변경
		user.id = "admin";					// => 위 셋은 String타입이라 문자열입력
		user.pw = "123456";
		user.email = "admin@web.com";
		user.point = 1000;					// => int타입이니 정수입력
		user.isVip = (user.point >= 10000); // => 10000 포인트 이상은 vip
		
		System.out.println(user.id);
		System.out.println(user.pw);
		System.out.println(user.email);
		System.out.println(user.point);
		System.out.println(user.isVip);
		

	}

}
