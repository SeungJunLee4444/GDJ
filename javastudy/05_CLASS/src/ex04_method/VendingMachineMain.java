package ex04_method;

public class VendingMachineMain {

	public static void main(String[] args) {
		
		VendingMachine machine = new VendingMachine();	// => 객체 생성
		
		// 연습1
		// 커피뽑기
		// 한잔 1000원
		// 종류(1) 아메리카노, (2)까페라떼
		
		String coffee1 = machine.getCoffee(1000, 1);	// 아메리카노 1잔
		
		String coffee2 = machine.getCoffee(2000, 2);	// 까페라뗴 2잔
		
		System.out.println(coffee1);
		System.out.println(coffee2);
		
	}

}
