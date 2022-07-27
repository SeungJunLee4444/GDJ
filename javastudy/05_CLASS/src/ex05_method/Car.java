package ex05_method;

public class Car {
	
	// 연습 2 자동차로 필드, 메소드 동시에 활용하기
	
	// 자동차 = 기름, 속도,  

	// 1) 필드
	int oil;
	int speed;
	
	// 2) 메소드
	// (1) 기름넣기
	// 반환타입		: void		// 반환값이 없는 타입 *
	// 메소드 이름	: addoil
	// 매개변수		: int o
	void addoil(int o) {
		oil += o;
		if(o > 60) {
			oil = 60; 			// => 60이 한계치임을 처음부터 정함 *
		}
	}
		
	
	
	
	// (2) 달리기
	// 반환타입 : void
	// 메소드 이름 : pushAccel 
	// 매개변수 : X
	void pushAccel() {
		// 예시
		// 액셀 한번 밟으면 속도는 25씩 증가, 최대 120제한
		// 기름은 1씩 사용
		
		// * 특정상황에 애초에 식이 진행될 필요가 없는 경우를 구상
		// {1} 예외 1기름이 애초에 0일때
		if(oil == 0) {
			return;				// => 반환타입이 void일때만 가능
			}					// * return 강제중지
		
		// {2} 예외2 경우의수2
		if(speed == 120) {
			oil--;
			return;
		// 애초에 속도가 120이면 가속할 필요가없음
		
		}
	
		// {3} 경우의수3 일반적으로 가속할 때
		speed += 25;
		if(speed > 120) {
			speed = 120;
		}
		oil--;
	}
		
		// * 액셀을 5번 밟으면 125만큼 늘어나는 것이 아니라 120을 유지
		// {2} 공식이 없으면 속도가 
		
	
	
	// (3) 멈추기
		void PushBrake() {
			
			// * 브레이크를 애초에 밟을 필요가 없는 순간
			// {1} 예외1 애초에 기름이 0일떄 
			if(oil == 0) {
				return;				
				}	
			
			// {2} 예외2 애초에 속도가 0이면 작동할필요x
			if(speed == 0) {
				//oil--;
				return;
			}
			
			// {3} 정상작동 속도를 0까지 줄임
			speed -= 25;
			if(speed < 0) {
				speed = 0;
			}
			oil--;

		}
		
	// (4) 계기판 (기름, 속도) 확인
		// 반환타입 : void
		// 메소드명 : panel
		// 매개변수 : x
		
	void panel() {						// => 자동 실행창을 메소드로
		System.out.println("기름" + oil);
		System.out.println("속도" + speed);
	}
}
		
		
			
	
	

		
		
		
	

	


