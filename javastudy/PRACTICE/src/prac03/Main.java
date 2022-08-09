package prac03;

public class Main {
	
	public static void main(String[] args) {
		
		Bakery paris = new Bakery(500, 100, 10000);	// 빵1개 500원, 빵 100개, 자본금 1만원
		
		Bakery tour = new Bakery(1000, 50, 10000);	// 빵1개 1000원, 빵 50개, 자본금 1만원
		
		Customer customer = new Customer(20000);	// 자본금 2만원
		
		try {
			customer.buy(paris, 30000);	// 구매불가
			customer.buy(tour, 500);	// 판매불가
			// ** try는 위에서 오류가 걸리면 다음 오류는 작동 안하기 때문에, 확인 후 주석처리 해야함
			customer.buy(paris, 10000);	// 구매한 빵 20개, 남은 돈은 1만원
			customer.buy(tour, 5000);	// 구매한 빵 5개, 남은 돈은 5000원
		}	catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		// => throws가 다시 여기로 던져짐
		// * main에서 던지면 jvm에서 자동으로 해결
		// * throw는 메서드가 선언되는 곳으로 날아간다
		
		
		paris.info();  	// 빵80개, 자본금 20000원
		tour.info();	// 빵 45개, 자본금 15000원 
		
		
	}

}
