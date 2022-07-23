package practice;

public class Day2 {

	public static void main(String[] args) {
		
		// 1. 사칙연산 시 유의할 점
		
		// 1) 범위고려

		int result = 10 + 15;
		long result2 = 15 + 10;
		char result3 = 12 + 15;
		short result4 = 15 + 14;
		
		// 정수간(의 연산은 선언한 변수 타입의 범위를 고려한다
		
//		int result5 = 1.5 + 12;
		double result6 = 1.5 + 12;
		System.out.println(result6);
		
		// 값중에 하나라도 실수면 값은 실수로 인식되기 때문에
		// => 변수선언도 실수타입으로 선언해야한다사
		
		// 2) 타입 고려
		int a = 500;
		int b = 3;
		
		int result7 = a + b;
		byte result8 = (byte)(a + b);
		System.out.println(result8);
		long result9 = a + b;
		double result10 = a + b;
		
		// 변수간의 연산의 경우에, 자바에서는 값을 int로 인식하기 때문에
		// => (1) 변수 선언을 int 이상의 범위로 바꿔주거나
		// => (2) int보다 작은범위인 경우에는 캐스팅해주면 된다
		
		// 3) 실수 고려
		
		long balance = 10000;
		balance *= 1.05;
		
		double balance2 = balance + 1.05;
		
		// 값에 하나라도 실수가 있으면 변수 선언도 실수타입으로 맞춰줘야 한다
		// => (1) 복합대입연산자 사용
		// => (2) long으로 강제 캐스팅
		// => (3) double타입 새로운 변수 생성
		
		
		long aa = 10;
		
		
		
		
		String str = "";
		for(int i = 0; i < 6; i++) {
			str += (int)(Math.random() * 10);
			
		} System.out.println(str);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
