package practice;

import java.util.Date;

public class Day4 {

	public static void main(String[] args) {
		
		// [4일차 연습문제]

		// [for]
		
		// 연습1 * 풀/
		// 10에서 1까지 거꾸로 출력하기
	
		for(int a = 10; a >=1; a--) {
			System.out.println(a);
		}
		
		// 주의 : for문 내에서 선언된 로컬변수는 for문 밖에서 출력 불가능하다
		
		
		//--------------------------------------------------------------------------------
		
		// 연습2 * 풀/
		// 구구단 7단 출력
		
		int num1 = 7;
		for(int b = 1; b <= 9; b++) {
			System.out.println(num1 + "x" + b + "=" + (num1 * b));
		}
		
		// 주의 : 7은 굳이 변수선언 안해도 된다
		
		//--------------------------------------------------------------------------------
		
// &	// 연습3 * 풀/
		// 1에서 100 사이의 모든 3의 배수만 출력
		
		for(int c = 1; c <=100; c++) {
			if(c % 3 == 0) {
				System.out.println(c);
			}
		}
		
		//--------------------------------------------------------------------------------
		
		// 연습4 * 풀/
		// 1에서 100 사이의 모든 정수 더하기 5050
	
		int sum = 0;
		for(int c =1; c <=100; c++) {
			sum += c;
		} System.out.println("총합:" + sum);
		
		//--------------------------------------------------------------------------------
		
//&		// 연습5 * 풀/
		// begin부터 end 사이의 모든 정수 더하기
		// begin과 end 중에서 누가 큰지 모름
		// 누가 큰지 모르니 begin을 end보다 항상 작은 값으로 바꾼 뒤 begin부터 ~end 모두 더하기 진행
		// begin이 end보다 크다면 둘을 교환하라
		
		int begin = 50;
		int end = 100;
		int sum2 = 0;
		if(begin > end) { 
			int temp;
			temp = begin;
			begin = end;
			end = temp;
			}
		for (int d = begin; d <= end; d++) {
			sum2 += (end - begin);
		} System.out.println("합:" + sum2);

		
		//--------------------------------------------------------------------------------
		
//&		// 연습6 * 풀/
		// 평점(1~5)에 따른 별(★) 출력하기
		
		String str1 = "";
		int num2 = 1;
		switch(num2) {
		case 1 : str1 += "★"; break;
		case 2 : str1 += "★★"; break; 
		case 3 : str1 += "★★★"; break; 
		case 4 : str1 += "★★★★"; break; 
		default : str1 += "★★★★★"; break; 
		} System.out.println(str1);
		
		// => switch를 이용한 방법도 있으나 for을 이용한 방법도 있다
		
		
		String str2 = "";	
		for(int e = 1; e < 6; e++) {
			if(e == 1) {
				str2 = "★";  
			} else if(e == 2) {
				str2 = "★★"; 
			} else if(e == 2) {
				str2 = "★★★";
			} else if(e == 2) {
				str2 = "★★★★" ;
			} else {
				str2 = "★★★★★";
			} 
		} System.out.println(str2);
		
		// => 위 방법은 결국 별 다섯개만 출력되는 잘못된 방법이다
		
		String str3 = "";
		int point = 3;
		for (int f = 1; f <= point; f++) {
		str3 += "★";
		} System.out.println(str3);
		
		//--------------------------------------------------------------------------------
		//--------------------------------------------------------------------------------
		
		// [continue]
		
//&		// 연습1
		// 3의 배수를 제외한 1에서 100까지의 합
		
		int sum3 = 0;
		for(int g = 1; g <= 100; g++) {
			if(g % 3 == 0) {
				continue; }	//break
			sum3 += g;
			
		} System.out.println("총합:" + sum3);
		
		// => break를 넣으면 식 자체가 작동을 중지하기 때문에 이는 잘못된 방법이다 *
		// => continue는 if조건에 해당하면 아래 값을 이행하지 않고 다시 for문으로 돌아간다 *
		
		//--------------------------------------------------------------------------------
		//--------------------------------------------------------------------------------
		
		// [while]
		

		int balance = 79350; // 통장 잔액
		int money = 450;  // 450원 단위로 출금됨
		while(balance >= money) { // => 450원보다 작으면 출금되지 않는점을 고려
			

		
		while(balance >= money) {
			balance -= money; 
			System.out.println(balance);
		} 
		
		// 주의 1 : for, while, if 안에 들어가는건 조건식 / switch가 표현식이다
		// 주의 2 : switch는 double과 boolean을 쓸수없다 
		// 주의 3 : switch는 명제를 표현식에 써서 case별로 나누는 타입이다
		
		//--------------------------------------------------------------------------------
		//--------------------------------------------------------------------------------
		
		// [break]
		
//&		// 연습1 
		// 모금목표: 100000원
		// 한번에 30원씩 모금
		// serial + "회 모금액" + money + "\t현재" + total + "원" 출력하기
		
//		int giving = 0;
//		int won = 30;
//		int goal = 100000;
//		int serial = 0;
//		while(giving >= goal) {
//			serial++;
//			giving += won;
//		} System.out.println(serial + "회 모금액" + won + "원" + "현재" + giving + "원");
		
		// => while에서 giving >= goal은 계산을 멈춰야할 조건으로 당연히 값이 안나온다
		
		int giving = 0;
		int won = 30;
		int goal = 100000;
		int serial = 0;
		while(true) {
			if(giving >= goal) {
				break; 
			}
			serial++;
			giving += won;
		} System.out.println(serial + "회 모금액" + won + "원" + "현재" + giving + "원");
		
		// 주의 1 : while(true)는 무한 반복문 이다 *
		
		
		//--------------------------------------------------------------------------------
		//--------------------------------------------------------------------------------
		
		// [중첩for]
		// 연습1
		// 전체 구구단 a x b = 0
		for(int g = 2; g <=9; g++) {
			for(int h = 1; h <=9; h++) {
				System.out.println(g + "x" + h + "=" + (g * h));
			}
		}

		//--------------------------------------------------------------------------------
		
//&		// 연습2
		// 2단에서 5x5까지 출력하기
		int i;
		int j;
		label : for(i = 2; i <= 5; i++) {
			for(j = 1; j <= 9; j++) {
				 System.out.println(i + "x" + j + "=" + (i*j));
				if(i == 5 && j == 5) {
					break label;
				}
			}  
		} 
		// => break가 실행되면, if가 아니라 가장 가까운 반복문을 빠져나가게 된다 *
		// => 이때 출력되는 값은 if 조건 이상의 값은 나올 수 없다
		// ex) 5 x 5면 5 x 5를 포함해 그 이상이 값이 될 수 없음
		
		// 조건값까지 출력되게 할려면 조건 이전에 실행문을 선언해야함
		
		// for 중첩문에서 아에 반복문을 벗어나고 싶으면 label을 활용하면 된다
	
		//--------------------------------------------------------------------------------
		
		// 연습3
		// 옆으로 출력하는 구구단
		// 2x1 3x1 4x1....
		// 2x2 3x2 4x2.... 식으로 나오게 출력
		
		for(int l = 1; l <=9; l++) {
			for( int k = 2; k <= 9; k++) {
		
				System.out.print(k + "x" + l + "=" + (k * l) + "\t");
				
				if(k == 9) {
					System.out.println();
				}
			} 
		}
		
		// 주의 1 : for중첩에서 넓은 범위의 for문은 하위 for문을 통과할떄까지 값이 고정된다 *
		// 주의 2 : System.out.println();은 '줄바꿈'을 의미한다
		
		//--------------------------------------------------------------------------------
		//--------------------------------------------------------------------------------
		
		// [클래스]
		
		// 연습1 * 풀/복
		// 주사위 출력 
			
			System.out.println((int)(Math.random() * 6 +1));
			
			for(int n = 0; n < 2; n++) {
				System.out.println((int)(Math.random() * 6 +1));
			}
			
			// 주의 : int 캐스팅 시, Math random~에도 괄호를 쳐야 제대로 값이 도출된다
		
		// 연습2 * 풀/복
		// 6자리 숫자로 된 인증번호 만들기 
				// String code "512345"
			
			String str = "";
			for(int p = 0; p < 6; p++) {
				str += (int)(Math.random() * 10);
				
			} System.out.println(str);
			
		// 연습3 * 풀/
		// 65에서 90까지 랜덤으로 유니코드 문자를 도출
	
		System.out.println((char)(int)(Math.random() * 26 + 'A'));
		
//*		// 연습4 * 풀/ 
		// 6자리 영문(대문자, 소문자) 인증번호 만들기
		
		String code = "";
		for(int t = 0; t < 6; t++) {
			if(Math.random() < 0.5) {
				code += (char)((int)((Math.random() * 26) + 'A'));
			} else {
				code += (char)((int)((Math.random() * 26) + 'a'));
			} 
		} System.out.println(code);
		
		// 주의 1 : += 잊지말기
		// 주의 2 : char선언을 통해 String 클래스에 저장할 수 있음을 잊지말기
		// 주의 3 : 실행문을 for문 밖에 써야함을 잊지말기
		// 주의 4 : if문의 확률조건 주의
		// 주의 5 : 문자를 출력할 떄는 char, 숫자로 출력할 떄는 int 캐스팅
		
		//--------------------------------------------------------------------------------
		//--------------------------------------------------------------------------------
 		
		// [클래스와 메소드]
		
		// 연습1
		// 1970년 기준 현재시간 출력하기
		long timeStamp = System.currentTimeMillis();
		System.out.println(timeStamp);
		
		// => 천분의 1초단위의 현재까지의 경과시간을 timeStamp에 저장
		// 이때 변수타입은 long타입이어야 한다
		// currentTimeMillis는 주로 날짜, 시간을 구할떄 사용
		
		// 연습2 
		// 1에서 5까지 모두 더하는 연산시간 구하기
		
		long beginTime = System.nanoTime(); 
		int sum4 = 1 + 2 + 3 + 4 + 5;
		long endTime = System.nanoTime();
		
		// => nanotime은 10억분의 1초를 단위로 1ong타입에 저장해야하는 메소드로,
		// 특정 작업의 소요시간을 구할 때 사용된다
		
		// 연습3
		// Date 객체 선언해보기
		Date date = new Date();
		System.out.println(System.currentTimeMillis());
		
		// 
	
		}
		
	}
}
		
	

