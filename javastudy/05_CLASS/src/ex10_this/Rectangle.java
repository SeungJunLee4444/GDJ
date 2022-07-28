package ex10_this;

public class Rectangle { // & 4각형
	
	// 문제: 직사각형과 정사각형을 다르게 만들어지도록 만들기
	
	// # 필드
	private int width;
	private int height;


	// 2. 생성자
	public Rectangle (int width, int height) { // 생성자의 이름은 클래스의 이름과 같다 *
		this.width = width;
		this.height = height;
	}
	public Rectangle (int n) {
		this(n, n);
		// & this의 두번째 용법
		// (2) 나말고 다른 생성자 호출
		// # int가 2개인 생성자를 호출하기
	}

	// 3. 메소드
	
	public int getArea () {
		return width * height;
	}
	// # 필드값 타입이 int이니, 
	// 값을 받을매개변수 타입도 int고,
	// 메소드의 타입도 int야 한다 *
	
	public int get () {
		return (width + height) * 2;
	}
 	

}
