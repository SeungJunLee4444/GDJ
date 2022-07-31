package practice;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("무슨 커피를 드릴까요? >>> "); 
		String order = sc.next();
		
		int price = 0;			// # 가격종류에 따라 출력할 값이 다르니 price 변수 선언
		switch (order) {
		case "에스프레소" :
		case "카푸치노" :
		case "까페라떼" :
			price = 3500; 
			break;
		case "아메리카노" :
			price = 2000; 
			break;	
		default : System.out.println(order + "은 메뉴에 없습니다");
		}
		
		if(price != 0) {
			System.out.println(order + "은" + price + "원입니다");
		}
		// ? 왜 굳이 price가 0이 아니라는 조건을 달았는지?-----------------------------?
		
		
		sc.close();
		// * 아래 default가 있어도 위에 case에 break를 써야 멈춘다 
		
		
		}
		

	

}
