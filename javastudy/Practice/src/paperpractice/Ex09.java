package paperpractice;

public class Ex09 {

	public static void main(String[] args) {
		
		BankAccount me = new BankAccount("1234", 10000);
		BankAccount mom = new BankAccount("4321", 100000);
		
		me.deposit(10000);
		me.deposit(-100);
		
		me.withdraw(5000);
		me.withdraw(100);
		
		me.inquiry();
		
		mon.transfer(me, 50000);
		mon.transfer(me, -100);
		mon.transfer(me, 1000000000);
		
		mom.inquiry();
		mom.inquiry();
		
		
	}

}
