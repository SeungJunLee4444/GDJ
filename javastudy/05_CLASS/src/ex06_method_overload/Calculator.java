package ex06_method_overload;

public class Calculator {

	// 메소드 오버로딩
	// => 같은 이름의 메소드가 두개 이상의 존재한다
	// => 조건 : 같은 이름과 다른 매개변수를 가져야 오버로딩된다
	// => 반환타입은 오버로딩과 상관x, 달라도 상관없다
		
	int add(int a, int b) {
		return a + b;
	}
	
//	double add(int a, int b) {
//		return (double)a + b;
	
	int add(int a, int b, int c) {
		return a + b + c;
	}
	
	int add(int a, int b, int c, int d) {
		return a + b + c + d;
	}
		
	int add(int[] arr) {   // *
		int total = 0;
		for(int n : arr) {
			total += n;
		}
		return total;
		
	}
	
}
