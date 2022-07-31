package day7;

public class VendingMachine {
	
//&	// 연습1
	// 커피뽑기
	// 한잔 1000원
	// 종류(1) 아메리카노, (2)까페라떼
	// 아메리카노 한잔, 까페라떼 두잔 출력하기
	
	String getcoffee(int money, int button) {
		
		String[] menu = {" ", "아메리카노", "까페라떼"};

		return menu[button] + (money / 1000) + "잔";
		// * return : 반환하려는 값의 형태
		
	
	}
}
