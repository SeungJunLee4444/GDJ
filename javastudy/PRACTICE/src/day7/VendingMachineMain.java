package day7;


public class VendingMachineMain {

	public static void main(String[] args) {
		
		VendingMachine machine = new VendingMachine();
		
		String coffee1 = machine.getcoffee(1000, 1);	// 아메리카노 1잔
		String coffee2 = machine.getcoffee(2000, 2);	// 까페라떼 2잔
		
		System.out.println(coffee1);
		System.out.println(coffee2);
		
		
	}

}
