package ex01_random;

public class Ex01 { // => 클래스

	public static void main(String[] args) { // => 메소드
		
		 //1. 난수발생
		  
		  
		
		
		
		//System.out.println(Math.random()); // => 추천창에 초록색 공들은 전부 메소드
		
		// => Math는 클래스, random는 메소드 *
		// => Math.random 0에서 1사이의 수를 랜덤으로 출력
		
		// 용도
		// => 0.0 <= Math.random() < 1.0
		// => 0% <= Math.random() < 100% => 확률처럼 인식할 수 있다 
		
		// 용도(1) 확률처리
		// 10퍼센트의 확률로 "대박", 90%의 확률로 "쪽박"
		if(Math.random() < 0.1) {
			System.out.println("대박");
		} else {
			System.out.println("쪽박");
		}
		
		// 용도(2) 난수값 생성
		// Math.random()             	0.0 <= n < 1.0
		// Math.random() *5       		0.0 <= n < 5.0
		// (int)(Math.random() *5) 		  0 <= n < 5
		
		// 연습1
		// 주사위 출력 *
		
		System.out.println((int)((Math.random()*6) +1));
		
		
	
		for(int n = 0; n < 2; n++) {  // => 두번 돌린다, 0에서 1 
			int dice = (int)(Math.random() * 6) + 1; 
			System.out.println("주사위" + dice);
		}
		
		// 연습2
		// 6자리 숫자로 된 인증번호 만들기 
		// String code "512345"
		
		String code = "";
		for(int n = 0; n < 6; n++) {
			code += (int)(Math.random() * 10); // => 인증번호는 0부터 9까지 있음
			
		} System.out.println(code);
		
		// => int로 하면 안되는 이유: (1) 숫자는 전부 합해지는 데다가, (2) 앞자리가 0일 경우(?)
		
		// 연습3 --------------------------------------------------------------------------------?
		// 65에서 90까지 랜덤으로 유니코드값을 생성
		// * 아스키코드 
		
		System.out.println((char)((int)(Math.random() * 26) + 'A')); // 26은 왜 곱하지?-----------8
		// => 영문대문자는 총 26개로 코드값은 65~90이다
		// => 0 <= Math < 1 ==> 0 <= Math < 26 ==> 65 <= Math < 91
		// => 이러면 유니코드 대문자 범위값인 65에서 90까지 임의의 수를 출력 가능하다
		// => 여기에 char을 캐스팅하면 문자값으로 출력가능

		int a = 1 + 'A'; // => 컴퓨터 입장에서는 A는 65랑 똑같다
		
		
		// 연습4 --------------------------------------------------------------------------------?
		// 6자리 영문(대문자, 소문자) 인증번호 만들기
		code = "";
		for(int n =0; n <6; n++) {
			if(Math.random() < 0.5) {
				code += (char)((int)(Math.random() * 26) +'A');  // 문자로도 바꿔서 더할 수 있다
			} else {
				code += (char)((int)(Math.random() * 26) +'a'); // a시작값으로 자바에서 알아서 계산
			}
		} System.out.println(code);
		
		
		
	}

	}
