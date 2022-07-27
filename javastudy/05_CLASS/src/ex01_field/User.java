package ex01_field;

public class User {
	
	// 1. User을 구성하는 속성(Attribute)이 필드(field)
	// => field는 일반변수와 달리 자동으로 초기화(배열과 비슷)
	
	String id;							// => null
	String pw;							// => null
	String email;						// => null
	int point;	   // 회원의 포인트		// 0
	boolean isVip; // vip여부			// => false
	// => 클래스에 소속된 변수들(Main 메소드에 들어가지않았음)
	// & 클래스의 변수들은 '필드'라 부른다 *
	// => 5개의 필드가 있는 것
	
}
