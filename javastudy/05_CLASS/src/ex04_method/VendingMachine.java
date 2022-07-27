package ex04_method;



public class VendingMachine {

//	String getCoffee(int money, int button) {
//		for(int i = 0; i < (money / 1000); i++) {
//			if(button == 1) {
//				String result1 = "아메리카노 i잔";
//				return result1;
//			} else {
//				String result2 = "까페라떼 i잔";
//				return result2;
//			}
//
//			}
//		// 연습1
		// 커피뽑기
		// 한잔 1000원
		// 종류(1) 아메리카노, (2)까페라떼
//		
		// * 배열을 이용한 풀이
		
	String getCoffee(int money, int button) {
		
		String[] menu = {"아메리카노", "까페라뗴"};
		return menu[button -1] + " " + (money / 1000) + "잔";
		
//		String[] menu2 = {" ", "아메리카노", "까페라뗴"};
//		return menu2[button] + " " + (money / 1000) + "잔";
//		// => 인덱스값을 맞춤
	
}
}