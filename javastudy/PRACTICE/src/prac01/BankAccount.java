package prac01;

public class BankAccount {

	// # 필드
	private String accNo;
	private long balance;
	
	// * 매개변수명을 무조건 필드에도 쓸필요는 없다
	
	
	
	// # 생성자
	public BankAccount(String accNo, long balance) {
		this.accNo = accNo;
		this.balance = balance;
	}
	
	
	// # 입금 메서드
	
	public void deposit(long money) {
		if(money < 0) 
			return;
			balance += money;	
	}
	// * if문이 중괄호를 생략하면 첫번째 문장만 실행한다
	
	
	// # 출금 메서드
	// => 출금이 불가능하다는 키워드를 담음 *
	
	public boolean withdraw(long money) {
		if(money < 0 || money > balance) 
			return false;
		balance -= money;
		return true;
		
		// # 출금 성공, 실패 여부를 리턴
	
	}
	// * 매개변수는 이름이 같아도 상관없다 
	
	// # 이체 메서드
	public void transfer(BankAccount other, long money) {
		//long bankaccountmoney = withdraw(money);// 타입이 달라서 저장x
		
		other.deposit(withdraw(money)));	// * boolean타입과 충돌해서 사용불가
		
//		if(this.withdraw(money)) {	// # 이 필드의 출금이 이루어지면
//			other.deposit(money);	// # 다른 계좌주인에게 입금해라
//		}
	} 
	// * 클래스명을 매개변수로 부를 수 있다?
		
	
	
		
		
	
		
	
	
	
}
