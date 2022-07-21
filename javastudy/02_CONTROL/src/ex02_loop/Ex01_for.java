package ex02_loop;

public class Ex01_for {

	public static void main(String[] args) {

		// [ 4일차 ]
		
		// 1. for문
		// 연속된 숫자를 생성할 때 주로 사용
		// 배열과 함께 사용
		// 형태: for(초기문; 조건문; 증감문) {
		// 실행문
		//}
		
		// 1부터 10까지 
		for(int n =1; n <=10; n++) { // ++n하든 상관없음 
		System.out.print(n);
		} // System.out.println(n); // n값은 최종적으로 11이며, 실행은 되지않음
		
		// System.out.println(); // 줄바꿈의 용도, // * print => 가로로나열 / println => \n 줄바꿈
		
		
		// for 작동순서: 초기문 => 조건문 => 실행문 => 증감문 => (반복) 조건문~
		//-----------------------------------------------------------------------------
		
		// 연습1--------------------------------?
		// 10~1
		for(int i = 10; i <= 10; i--) {
		//	System.out.println(i);
		} 
		
		// => 정답
		for(int t = 10; t >= 1; t--) { //=> 10에서 1로 거꾸로 출력해야하니까 초기값과 조건식을 다르게 작성해야함 *
		//	System.out.println(t);
		}
		
		//-----------------------------------------------------------------------------
		
		// 연습2
		// 구구단 7단 출력
//		for(int s = 7; s % 7 == 0; s++) {  
//			System.out.print(s);
//		} System.out.println();  // => 오류, 무한히 계산
//		 
		// => 정답
		for(int q = 1; q <= 9; q++) {
		 System.out.println("7x" + q + "=" + (7 * q));
		} 
		
		// 실행문을 안에 넣거나 밖에 넣거나는 q값 하나의 차이 *
		
		//-----------------------------------------------------------------------------
		
		// 연습3
		// 1에서 100 사이의 모든 3의 배수만 출력
		for (int a = 1; a <= 100; a++) {
			if(a % 3 == 0) {
				System.out.println(a + " ");
			}
		}
		
		//-----------------------------------------------------------------------------
		
		// 연습4----------------------------------------------?
		// 1에서 100 사이의 모든 정수 더하기 5050
		// 
		int num = 0;
		for(int b = 1; b <=100; b++) {
			num += b;
			System.out.println(num);
		} 
		
		// => 정답
		int total = 0;
		for (int p =1; p <=100; p++) {
			total += p; // 모든 값을 더하기 *
		} System.out.println(total); // 괄호 밖으로 나가면 p값은 하나 더 증가한다 *
		
		// -----------------------------------------------------------------------
		
		// 연습5 -------------------------------------------------?
		// begin부터 end 사이의 모든 정수 더하기
		// begin과 end 중에서 누가 큰지 모름
		// 누가 큰지 모르니 begin을 end보다 항상 작은 값으로 바꾼 뒤 begin부터 ~end 모두 더하기 진행
		// begin이 end보다 크다면 둘을 교환하라
		// ex) 네이버의 목차
		
		int begin = 100;
		int end = 1; // => 일단 선언하고 해야함
		
		if(begin > end) { // => (1) begin을 end보다 항상 작도록 한다 *
			int temp;
			temp = begin;
			begin = end;
			end = temp;
		} 
		int sum = 0;
		for(int n = begin; n <= end; n++) {
			sum += n;
		} System.out.println(sum); // 5050
//		
		// --------------------------------------------------------------------------
		
		// 연습6 ---------------------------------------------------?
		// 평점(1~5)에 따른 별(★) 출력하기
//		int sta = 5;
//		String strStar = sta + "";
//		for(sta =1; sta < 6; star++) {
//			if(star == 1) {
//				strStar = "★";
//			} else if(sta == 2) {
//				strStar = "★★";
//			} else if(star == 3) {
//				strStar = "★★★";
//			} else if(star == 4) {
//				strStar = "★★★★";
//			} else {
//				strStar = "★★★★★";
//			} 
//		} System.out.println(star + "점은" + strStar + "입니다");
		
		// => 정답
		int point = 3;
		String star = "";
		
		//String star = "★"; => 연속으로 저장되지 않음
		
		for(int c = 1; c <= point; c++) {
	//	for(int c = 0; c < point; c++) {	=> 둘이 값이 똑같음 , 반복문은 0으로 시작되는 경우가 일반적 *
			star += "★"; // => 연속으로 추가됨
		} System.out.println(star);
			
		
		
		
		
			
		
		
		
		
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


