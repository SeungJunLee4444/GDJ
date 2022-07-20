package practice;

public class Day3 {

	public static void main(String[] args) {
		
		// 3일차 연습문제
		
		// [variable]
		
		// 1  p
		// 순위가 1이면 "금메달", 순위가 2이면 "은메달", 순위가 3이면 "동메달"
		// 나머지 순위는 없음
		
		int rank = 4;
		String str1 = (rank == 1) ? "금메달" : (rank == 2) ? "은메달" : (rank == 3) ? "동메달" : "없음";
		System.out.println(str1);
		// => 조건연산자 문제
		
		//----------------------------------------------------------------------------
		
		// 연습2 p
		// 홀수는 "홀수", 짝수는 "짝수"로 출력하기 
		int n = 0;
		String str2 = (n % 2 == 1) ? "홀수" : "짝수";
		System.out.println(str2);
		
		// => 마찬가지로 조건연산자 활용
		// => 홀수는 2로 나눈 나머지값이 1, 짝수는 나머지값이 0임을 이용
		
		//----------------------------------------------------------------------------
		
		// 연습3 p
		// 홀수는 "홀수", 짝수는 "짝수"로, 3의 배수는 "3의 배수" (0은 고려하지않는다)
		int a = 6;
		
		String str3 = (a % 3 == 0) ? "3의 배수" : (a % 2 == 0) ? "짝수" : "홀수"; 
		System.out.println(str3);
				
		// => 앞의 조건과 겹치는 특정한 조건일수록 앞으로 명시해야 생략되지 않음 *
		// => 3의 배수는 3으로 나눴을 때 나머지 값이 0임을 이용
	
		//----------------------------------------------------------------------------
		
		// 연습4 p
		// 주민등록번호 뒷 7자리 중 첫번째 숫자가 1,3,5면 "남자", 2,4,6이면 "여자"
		int serial = 1234567;
		String str4 = ((serial / 1000000) % 2 == 0) ? "짝수" : "홀수";
		System.out.println(str4);
		
		
		
		//----------------------------------------------------------------------------
		//----------------------------------------------------------------------------
		
		
		
		//[if]
		
		// 연습 1 p
		// 나이에 따른 결과 출력
		// 0~7: 미취학 아동 / 8~13: 초등학생 / 14~16: 중학생 / 17~19: 고등학생 / 20~: 성인
		int age = 60;
		if(age < 0 || age > 100) {
			System.out.println("잘못된 값");
		} else if(age <=7) {
			System.out.println("미취학 아동");	
		} else if(age <=13) {
			System.out.println("초등학생");	
		} else if(age <=16) {
			System.out.println("중학생");	
		} else if(age <=19) {
			System.out.println("고등학생");	
		} else {
			System.out.println("성인");
		}
		
		// => 맨 처음 조건에서 현실적인 큰 제한을 걸면 else if 조건식이 간략해진다 *
		
		//----------------------------------------------------------------------------
		
		// 연습 2 p
		// 월에 따른 계절 출력
		// 봄(3~5) / 여름(6~8) / 가을(9~11) / 겨울(12~2)
		int month = 1;  
		
		if(month < 1 || month > 12) {
			System.out.println("잘못된 값입니다");
		} else if(month == 12 || month <=2) {
			System.out.println("겨울");
		} else if(month <= 5) {
			System.out.println("봄");
		} else if (month <= 8){
			System.out.println("여름"); 
		} else {
			System.out.println("가을");
		}
		
		// => 범위를 정할 때, 더 간결하게 하는 방법이 무엇인지를 파악할 것
		// => 원래대로라면 문제 대로의 범위를 그대로 대입하려 했으나
		// => 최대한 앞의 조건에서 해결하도록 하고, 뒤의 조건은 간결하게 작성 *
		
		// * 모듈러 응용하기 (1) *---------------------------------------------------?
		
		int mod = month % 12; // 0~11
		if(month < 1 || month > 12) {
			System.out.println("잘못된 값입니다");
		} else if(mod <= 2) {
			System.out.println("겨울");
		} else if(month <= 5) {
			System.out.println("봄");
		} else if (month <= 8){
			System.out.println("여름"); 
		} else {
			System.out.println("가을");
		}
		
		// => 모듈을 이용하면 거슬리는 범위값 12를 0으로 바꿀 수 있고 보다 간결하게 
		// 코드를 작성할 수 있다
		
		//----------------------------------------------------------------------------
	
		// * 모듈러 응용하기 (2)  
		
		// 연습 3 ** => 이해하면 생각보다 간단히 풀수 있다----------------------------------*
		// 한 달에서, 첫번째 일이 수요일일때, num일후에는 무슨 요일(weekname)인지 출력하기
		int day =1;
		int num =1;
		day += num; // => 이거 며칠 후에는 무슨 요일이냐고 묻는 그냥 문제다 *
		String weekName; // 목
		if (day % 7 == 0) {
			System.out.println("화요일");  // day 1,7,14
		} else if(day % 7 == 1) {
			System.out.println("수요일");
		} else if(day % 7 == 2) {
			System.out.println("목요일");
		} else if(day % 7 == 3) {
			System.out.println("금요일");
		} else if(day % 7 == 4) {
			System.out.println("토요일");
		} else if(day % 7 == 5) {
			System.out.println("일요일");
		} else {
			System.out.println("월요일");
		}
				
		// => 요일단위는 일주일이므로, 일주단위로 나누어 나머지값을 통해 구분할 수 있다
		
		//----------------------------------------------------------------------------
		
		// 연습 4
		// 점수에 따른 학점
		// score / grade
		// score이 100~90이면 a, 80~89는 b, 70~79는 c, 60~69는 d, 59~0 은 f
		int score = 60;
		char grade;
		if(score <0 || score > 100) {
			grade = 'X';
		} else if(score <=90) {
			grade = 'A';
		} else if(score <=80) {
			grade = 'B';
		} else if(score <=70) {
			grade = 'C';
		} else if(score <=60) {
			grade = 'D';
		} else {
			grade = 'F';
		} System.out.println(score + "점은" + grade + "입니다");
		
		
		
		//----------------------------------------------------------------------------
		//--------------------------------------------------------------------------------
		
		
		
		// [switch]
		
		// 연습 1
		// 각 층별 관리자를 출력하라
		// 1~2층의 관리자는 전지현, 3~4층은 한지민, 5~6층은 박은빈, 나머지층은 한효주
		
		int floor = 4;
		String manager;
		switch(floor) {
		case 1 : 
		case 2 : manager = "전지현"; break;
		case 3 :
		case 4 : manager = "한지민"; break;
		case 5 :
		case 6 : manager = "박은빈"; break;
		default : manager = "한효주";
		} System.out.println("매니저는" + manager + "입니다");
		
		//----------------------------------------------------------------------------
		
		// 연습 2
		// 짝수, 홀수
		int nume = 1;
//		int number = (nume % 2);
		switch(nume % 2) { //=> 이게 표현식이다! -----------------------------------*
		case 0: System.out.println("짝수");
		case 1: System.out.println("홀수");
		} 
		
		//----------------------------------------------------------------------------
		
		// 연습 3 -------------------------------------------------------------------*
		// * 덩이리채 나누는걸 이용해 분리하기?
		// 분기 출력하기
		// => 123, 1분기 456, 2분기 , 789, 3분기 , 101112, 4분기
		int monthy = 1;
		String str5; 
				
		switch((monthy-1) / 3) {
		case 0: str5 = "1분기"; break;
		case 1: str5 = "2분기"; break;
		case 2: str5 = "3분기"; break;
		default: str5 = "4분기";
		} System.out.println(monthy + "월은" + str5 + "분기입니다");
				
		//----------------------------------------------------------------------------		
				
		// 연습 4
		// 점수에 따른 학점. 
		// => 앞에서 필요한 단위의 숫자만 뽑고싶을 때 뽑을려는 대상의 단위수만큼 나누면 된다고
		// 학습하였음 *
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
		
		
		//----------------------------------------------------------------------------
		
		// 연습 5 
		// => break문의 생략과 switch문의 출력 특성을 응용한 문제 
		 
		// 등급(1,2,3) 에 따른 권한 출력
		// 1등급은 쓰기실행읽기, 2등급 실행 읽기, 3등급 읽기, 나머지 없음
		
		int level = 2;
		String right = "";
		
		switch(level) {
		case 1: right = "쓰기"; // 1등급은 여기서부터 밑으로 출력
		case 2: right = "실행"; // 2등급은 여기서부터 밑으로 출력
		case 3: right = "읽기"; break; // 3등급은 여기서부터 밑으로 출력
		default: right = "없음";
		} System.out.println(level + "등급은 " + right + "를 할 수 있습니다");
		
		
		
		
		
		
	}
}
