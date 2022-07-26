package practice;

import java.sql.SQLOutput;

public class Day3 {

	public static void main(String[] args) {
		
		// 3일차 연습문제
		
		// [variable]
		
		// 연습1  * 풀/복
		// 순위가 1이면 "금메달", 순위가 2이면 "은메달", 순위가 3이면 "동메달"
		
		int rank = 4;
		String str1 = (rank == 1) ? "금메달" : (rank == 2) ? "은메달" : (rank == 3) ? "동메달" : "없음";
		System.out.println(str1);
		
		// => 조건연산자 문제
		
		//----------------------------------------------------------------------------
		
		// 연습2 * 풀/복
		// 홀수는 "홀수", 짝수는 "짝수"로 출력하기 
		
		int num1 = 1;
		String str2 = (num1 % 2 == 0) ? "짝수" : "홀수";
		System.out.println(str2);
		
		// => 마찬가지로 조건연산자 활용
		// => 홀수는 2로 나눈 나머지값이 1, 짝수는 나머지값이 0임을 이용
		
		//----------------------------------------------------------------------------
		
		// 연습3 * 풀/ 복
		// 홀수는 "홀수", 짝수는 "짝수"로, 3의 배수는 "3의 배수" (0은 고려하지않는다)
		
		int num2 = 1;
		String str3 = (num2 % 3 == 0) ? "3의 배수" : (num2 % 2 == 0) ? "짝수" : "홀수";
		System.out.println(str3);
				
		// => 앞의 조건과 겹치는 특정한 조건일수록 앞으로 명시해야 생략되지 않음 *
		// => 3의 배수는 3으로 나눴을 때 나머지 값이 0임을 이용
	
		//----------------------------------------------------------------------------
		
		// 연습4 * 풀/ 복
		// 주민등록번호 뒷 7자리 중 첫번째 숫자가 1,3,5면 "남자", 2,4,6이면 "여자"
		
		int num3 = 294598;
		String str4 = ((num3 / 100000) % 2 == 0) ? "여자" : "남자";
		System.out.println(str4);
		
		
		
		//----------------------------------------------------------------------------
		//----------------------------------------------------------------------------
		

		//[if]
		
		// 연습1 * 풀/ 복
		// 나이에 따른 결과 출력
		// 0~7: 미취학 아동 / 8~13: 초등학생 / 14~16: 중학생 / 17~19: 고등학생 / 20~: 성인
		
		int age = 13;
		if (age < 0 || age >100) {
			System.out.println("잘못된 나이값입니다");
		} else if(age <= 7) {
			System.out.println("미취학 아동");
		} else if(age <= 13) {
			System.out.println("초등학생");
		} else if(age <= 16) {
			System.out.println("중학생");
		} else if(age <= 19) {
			System.out.println("고등학생");
		} else {
			System.out.println("성인");
		}
		
		
		// => 맨 처음 조건에서 현실적인 큰 제한을 걸면 else if 조건식이 간략해진다 *
		
		//----------------------------------------------------------------------------
		
		// 연습2 * 풀/ 복
		// 월에 따른 계절 출력
		// 봄(3~5) / 여름(6~8) / 가을(9~11) / 겨울(12~2)
		int month = 3;
		if(month < 0 || month > 12) {
			System.out.println("잘못된 값입니다");
		} else if(month == 12 || month <= 2) {
			System.out.println("겨울");
		} else if(month <= 5) {
			System.out.println("봄");
		} else if(month <= 8) {
			System.out.println("여름");
		} else {
			System.out.println("가을");
		} 
		
		// => 모듈러를 이용해 푸는 방법도 있다
		
		int month1 = 3;
		int mod = month1 % 12;
		if(month1 < 0 || month1 > 12) {
			System.out.println("잘못된 값입니다");
		} else if(mod >= 0 || mod <= 2) {
			System.out.println("겨울");
		} else if(mod <=5) {
			System.out.println("봄");
		} else if(mod <=8) {
			System.out.println("여름");
		} else {
			System.out.println("가을");
		}
		
		// => 모듈러는 주기성을 지닌 조건문에 유용하게 사용할 수 있다 *
		
		//----------------------------------------------------------------------------
		
//&		// 연습3 * 풀/ 복
		// 한 달에서, 첫번째 일이 수요일일때, num일후에는 무슨 요일(weekname)인지 출력하기
		
		int day = 8; // 수
		int weekday = day % 7;
		String str5 = ""; 
		if(weekday == 0) {
			System.out.println("화");
		} else if(weekday == 1) {
			System.out.println("수");
		} else if(weekday == 2) {
			System.out.println("수");
		} else if(weekday == 3) {
			System.out.println("수");
		} else if(weekday == 3) {
			System.out.println("수");
		} else if(weekday == 5) {
			System.out.println("수");
		} else {
			System.out.println("월");
		}
		
		
			
		// => 주기성을 띠는 값은 모듈을 이용해 값을 도출하면 된다
		// => 모듈은 반복성이 지닌 횟수를 나눈 나머지값을 이용하는 것 *
		// => for문을 굳이 쓸 필요는 없을 듯 하다 *
	
		//----------------------------------------------------------------------------
		
		// 연습4 * 풀/ 복
		// 점수에 따른 학점
		// score / grade
		// score이 100~90이면 a, 80~89는 b, 70~79는 c, 60~69는 d, 59~0 은 f
		
		int score = 76;
		char grade = 0;
		int mod1 = score / 10;
		if(score < 0 || score > 100) {
			System.out.println("잘못된 값입니다");
		} else if(mod1 >= 9) {
			grade = 'A';
		} else if(mod1 == 8) {
			grade = 'B';
		} else if(mod1 == 7) {
			grade = 'C';
		} else if(mod1 == 6) {
			grade = 'D';
		} else {
			grade = 'F';
		} System.out.println(score + "점은" + grade + "등급 입니다");
		
		
		switch(mod1) {
		case 10 :
		case 9 : grade = 'A'; break;
		case 8 : grade = 'B'; break;
		case 7 : grade = 'C'; break;
		case 6 : grade = 'D'; break;
		default : grade = 'F';
	
		} System.out.println(score + "점은" + grade + "등급 입니다");
		
		// => 모듈과 switch문으로도 해결할 수 있다
	
		//----------------------------------------------------------------------------
		//--------------------------------------------------------------------------------
		
	
		// [switch]
		
		// 연습1 * 풀/ 복
		// 각 층별 관리자를 출력하라
		// 1~2층의 관리자는 전지현, 3~4층은 한지민, 5~6층은 박은빈, 나머지층은 한효주
		
		int floor = 3;
		String manager = "";
		if(floor < 0) {
			System.out.println("잘못된 값입니다");
		} else if(floor == 1 || floor == 2) {
			manager = "전지현";
		} else if(floor <= 4) {
			manager = "한지민";
		} else if(floor <= 6) {
			manager = "박은빈";
		} else {
			manager = "한효주";
		} System.out.println(floor + "층의" + "관리자는" + manager + "이다");
		
		// => swith로도 해결할 수 있다
		
		switch(floor) {
		case 1 : 
		case 2 : manager = "전지현"; break;
		case 3 : 
		case 4 : manager = "한지민"; break;
		case 5 : 
		case 6 : manager = "박은빈"; break;
		default : manager = "한효주"; 
		}
		
		// 대체로 범위가 명확하고 짧은 타입은 switch, 범위가 큰 조건형 타입은 if를 쓴다
		
		//----------------------------------------------------------------------------
		
		// 연습2
		// 짝수, 홀수
		int num = 0;
		String str = "";
		switch(num % 2) {
		case 0 : str = "짝수"; break;
		case 1 : str = "홀수"; break;
		} System.out.println(str);
		
		// 주의 : break 잊지말기
		
		//----------------------------------------------------------------------------
		
		// 연습 3
		// 분기 출력하기
		// => 123, 1분기 456, 2분기 , 789, 3분기 , 101112, 4분기
		int bungi = 3;
		int bungi2 = (bungi -1) / 3;
		String str6 = "";
		if(bungi2 == 0) {
			str6 = "1분기";
		} else if(bungi2 == 1) {
			str6 = "2분기";
		} else if(bungi2 == 2) {
			str6 = "3분기";
		} else {
			str6 = "4분기";
		} System.out.println(bungi + "월은" + str6 + "입니다");
		
		// => switch문으로도 해결가능
		
		switch(bungi2) {
		case 0 : str6 = "1분기"; break;
		case 1 : str6 = "2분기"; break; 
		case 2 : str6 = "3분기"; break;
		default : str6 = "4분기"; break;
		} System.out.println(bungi + "월은" + str6 + "입니다");
		
		// => break문은 단독 조건문에서 switch에서 사용되고
		// => 반복문의 if에서 반복문 탈출을 위해 사용된다
		// * 반복문에서는 if가 사용된다(switch는 제한이 있기 떄문)

		//----------------------------------------------------------------------------		
				
		// 연습 4 
		// 점수에 따른 학점
	
		// A는 90이상 B는 80이상 C는 70이상 D는 60이상 나머진 F 
		int score1 = 100; 
		String grade1;
		
		switch(score1 / 10) {
		case 10: 
		case 9: grade1 = "A"; break;
		case 8: grade1 = "B"; break;
		case 7: grade1 = "C"; break;
		case 6: grade1 = "D"; break;
 		default: grade1 = "F";
		
		} System.out.println(score1 + "점은" + grade1 + "학점입니다");
		
		// => 위에서 해봤음 이미 *
		
		//----------------------------------------------------------------------------
		
		// 연습 5 
		// => break문의 생략과 switch문의 출력 특성을 응용한 문제 
		 
		// 등급(1,2,3) 에 따른 권한 출력
		// 1등급은 쓰기실행읽기, 2등급 실행 읽기, 3등급 읽기, 나머지 없음
		
		int rank1 = 2;
		String str7 = "";
		switch(rank1) {
		case 1 : str7 = "쓰기";
		case 2 : str7 = "실행";
		case 3 : str7 = "읽기";
		} System.out.println(rank1 + "등급은" + str7 + "");
		
		
		
		

			
	
}

}

