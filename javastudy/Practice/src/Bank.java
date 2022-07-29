import javax.management.monitor.Monitor;

public class Bank {
	
	// # 필드
	private String accNo;
	private long balance;
	
	// # 생성자
	
	public Bank(String accNo, long balance) {	// new Bank("1234, 50000)
		this.accNo = accNo;
		this.balance = balance;	
	}
	
	// # 입금	(마이너스 입금만 불가하게끔)
	
	public void deposit(int money) {	// * b.deposit(50000) : b계좌에 5만원 입금
		if(money <= 0 ) {
			return;						// * 반환타입이 void일때 return은 메서드 종료용도
		}								// 그 외에는 반환값을 리턴할때 사용
		balance += money;
	}
	
	// # 출금	(마이너스 출금x, 잔액보다 큰 금액 인출은 불가)
	// => 실제로 출금된 금액을 반환(boolean 예시와는 다르게 만들기) *
	
	public long withdrawl(long money) { // long 출금액 = b.withdrawal(50000);
		if(money < 0 || money > balance) {
			return 0;
			// # 반환값이 있는 long타입은 반환값을 작성해줘야한다
		}
		balance -= money;
		return money;
		// # 특정 조건이 안될 때 0원 출금, 아니면 호출한 만큼 출금

		}
	
	// # 이체(출금도 되고, 입금도 되어야함)
	public void transfer(Bank other, long money) {
		
		// # 내 계좌에서 출금, 상대계좌에 입금
//		long withdrawlMoney = withdrawl(money); // # 출금 메서드 호출
//		other.deposit(withdrawlMoney); // 다른 객체에게 그만큼 입금해라
		other.deposit(withdrawl(money)); 
		// * 한번에 입력하는법
		// * 위 입금,출금의 코드를 재활용
		// 메서드() : 괄호안은 매개변수 => 매개변수에 따라 메서드를 실행 시킴*
	}
	// # 누구에게 얼마를 이체할건지? 
	
	// # 계좌정보 확인
	public void accInfo() {
		System.out.println("계좌번호:" + accNo + "잔액:" + balance + "원");
	}
	
	public static void main(String[] args) {
		
		// # 메인은 어디서든 만들 수 있다
		// * 메인 메서드 안에서는 해당 위치 클래스를 선언할 수 없다
		// 클래스만 있을 떄는 가능
		
		Bank me = new Bank("1234", 50000);
		Bank mom = new Bank("4567", 100000);
		
		mom.transfer(me, 50000);
		
		me.accInfo();
		mom.accInfo();
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
