package prac1;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("무슨 커피 드릴까요? >>> ");
		String order = sc.next();
		int price = 0;
		switch (order) {
		case "에스프레소":
		case "카푸치노":
		case "카페라떼":
			price = 3500;
			break;
		case "아메리카노":
			price = 2000;
			break;
		default:
			System.out.println(order + "는 메뉴에 없습니다.");
		}
		
		
		
		if (price != 0)
			System.out.print(order + "는 " + price + "원입니다.");
		
		// * if price가 0이 아니라는 조건이 있는 이유
		// => 만약 메뉴에는 없는 '마끼야또'를 입력했을 때, 
		
		//(1) 출력문
		// 마끼야또는 메뉴에 없습니다 
		// 마끼야또는 0원입니다
		// => 라고 출력될 것이다 
		// * 따라서 if문이 있어야 한다
		
		//(2) price 변수
		// 현재 price 변수의 값은 0이기 떄문에,
		// (price가 0이 아닌 값) 이라는 조건을 둔다,
		// => 이러면 메뉴에는 없는 입력내용이 출력되었을때 아래의 출력문이 
		// 시행되지 않을 것이다
		
		
		
		
		
		sc.close();
		
	}
	
}