package ex03_method;

public class Calculator {
	
	// 2. 메소드 
	// => 클래스 내부에 포함된 함수를 메소드라 한다
	
	// 계산 기능(메소드)
	
	// add 메소드 정의
	// 1. int : 반환타입(add 메소드를 실행하면 int타입의 결과값이 반환된다
	// 2. add : 메소드명(임의로 지음)
	// 3. int a, int b : 매개변수(add 메소드를 호출할 때, int타입 값 2개가 전달되어야 한다고 규정)
	int add(int a, int b) {			//
		int result = a + b;			//
		return result;				// => add 메소드의 연산값을 반환한다 *
	}
	
	int sub(int a, int b) {
		int result = a - b;
		return result;
	} 
	
	int mul(int a, int b) {
		int result = a * b;
		return result;
	} 
	
	double div(int a, int b) {		// => 소수점 표현을 위해 double 선언
		double result = (double)a / b;
		return result;
	} 

}
