package ex03_method;

public class CalculatorMain {

	public static void main(String[] args) {
		
		
		// 1) 객체 생성
		Calculator calculator = new Calculator();
		
		// 2) Calculator의 add 메소드 호출
		// (1) add 메소드로 전하는 숫자값은 '인수'라 한다
		// => 인수는 매게변수에 저장된다
		// (2) answer : add 메소드의 반환값(return result)
		int answer1 = calculator.add(2, 3);
		int answer2 = calculator.sub(2, 3);
		int answer3 = calculator.mul(2, 3);
		double answer4 = calculator.div(2, 3);
		System.out.println(answer1);
		System.out.println(answer2);
		System.out.println(answer3);
		System.out.println(answer4);
		
		
	}

}
