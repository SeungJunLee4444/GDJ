package prac03;

public class Customer {
	
	private int money;	// 지갑에 있는 돈
	private int cnt; 	// 구매한 빵의 개수
	
	public Customer(int money) {
		super();
		this.money = money;
	}

	// 구매
	// => bakery에서 판매한 빵을 가질수 있다(bakery의 sell메서드를 어떻게 쓸 건지 고민)
	public void buy(Bakery bakery, int buyMoney) throws RuntimeException{	// 빵 살때 내는 돈
		
		if(money - buyMoney < 0) { // * 구매했는데 잔고가 0미만이라면 구매못해
			throw new RuntimeException("구매불가");
		}
		
		BreadAndChange bnc = bakery.sell(buyMoney);	// *1throws는 메서드 sell로 날라온다
		// => 빵이 얼마, 잔돈이 몇개	
		
		// *2 try-catch 쓰기
		// *2 여기도 예외가 있을 수있으니 다시 던지기
		
		cnt += bnc.getBread();	// 구매한 빵의 개수
		
		money -= buyMoney;	// 구매한 금액은 빠짐
		money += bnc.getChange();	// 잔돈은 회수
		
		System.out.println("구매한 빵" + cnt + "개, 남은돈" + money + "원");
	}
}
