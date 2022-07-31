package practice;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		
		// # 배열, 반복문을 이용하여 해결할 것
		
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		int[] count = new int[unit.length];
		// # 배열 선언시 유의
		
		// # length 메소드 => (1) string 문자열 길이, (2) 배열의 길이 
		
		Scanner sc = new Scanner(System.in);
		System.out.println("금액을 입력하시오 >>> ");
		int money = sc.nextInt();
		
		// # 75329
		// # 50000원 짜리의 개수
		// => 75329 / 50000의 몪
		
		// # 5만원을 제외한 10000원짜리의 개수
		// => (75329 % 50000) / 10000
		
		for(int i = 0; i < unit.length; i++) {
			count[i] = money / unit[i];
			money = money % unit[i];	
			System.out.println(unit[i] + "원 짜리 : " + count[i] + "개");
		}
		// # money는 애초에 실행문에 출력되지않음 *
		
		sc.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
