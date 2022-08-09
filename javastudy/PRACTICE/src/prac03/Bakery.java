package prac03;

public class Bakery {
	
	// prac03 : 객체지향 + exception
	
	// ? 반환타입이 직접만든 클래스?
	// ? return반환값이란?
	
	private int price;		// 빵가격
	private int cnt;		// 빵개수
	private int money;		// 자본금
	
	public Bakery(int price, int count, int money) {
		super();
		this.price = price;
		this.cnt = count;
		this.money = money;
	}

	public BreadAndChange sell(int custMoney) {		 // 나가는건 빵, 받는건 돈
			
			// # 판매불가
			if(cnt == 0) {
				throw new RuntimeException("재고가 없습니다");
				// * runtime이라서 throws 생략가능
			}
			if(price > custMoney) {
				throw new RuntimeException("판매불가");
			} 
			
			// # 판매할 수 있는 빵은 몇개인가?
			// => money를 price로 나눈 몫
			// => 나눈 나머지는 잔돈
			int sellCnt = money / price;
			
			// # 잔돈은 얼마인가?
			int change = custMoney % price;
			
			// # 매장 내부처리
			cnt -= sellCnt;
			money += (custMoney - change);
			
			// # 고객에게 빵과 잔돈을 반환
			return new BreadAndChange(sellCnt, change);	// * breadandchange클래스 활용법
		
	}
	
	public void info() {
		System.out.println("빵" + cnt + "개");
		System.out.println("자본금" + money + "원");
		
	}

}
