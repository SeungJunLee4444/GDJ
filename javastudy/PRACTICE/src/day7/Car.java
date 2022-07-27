package day7;

public class Car {

	// 연습 2 자동차로 필드, 메소드 동시에 활용하기
	// 1) 필드 구성
	// ex) 자동차에 필요한건 기름, 속도
	int oil;
	int speed;
	

	// 2) 메소드 구성 
	
	// (1) 기름넣기(60이 최대)
		// 반환타입		: void		
		// 메소드 이름	: addoil
		// 매개변수		: int o
	
	void addoil(int o) {
		oil += o;
		if(o > 60) {
			oil = 60;	
		}	
	}
	
	// (2) 달리기
		// 반환타입 : void
		// 메소드 이름 : pushAccel 
		// 매개변수 : X
		// 예시
		// 액셀 한번 밟으면 속도는 25씩 증가, 최대 120제한
		// 기름은 1씩 사용
	
	void pushAccel() {
		
		// {1} 경우1: 애초에 기름이 없을때
		
		if(oil == 0) {
			return;
		}
		
		// {2} 경우2: 애초에 120 이상이면 엑셀을 밟을 필요없음
		if(speed > 120) {
			oil--;
			return;
		}
		
		// {3} 경우3: 정상작동시 120까지 제한
		speed += 25;
		if(speed > 120) {
			speed = 120;
		}
		oil--;
		
		
	}
	
	
	
	// (3) 멈추기
	void pushBrake() {
		
	// {1} 경우1: 애초에 기름이 없을때
		
		if(oil == 0) {
			return;
		}
		
	// {2} 경우2: 애초에 정지중일때
		if(speed == 0) {
			return;
		}
	
	// {3} 경우3: 정상작동 	
		speed -= 25;
		if(speed < 0) {
			speed = 0;
		}
		oil--;
		
		// * 이걸 생각할 때 진짜 차가 아니라 컴퓨터 수치라는 점을 
		// 명심할 것
		// => 그러니 0 이하도 값이 나올수 있는 것 *
		
	}
	
	// (4) 계기판 (기름, 속도) 확인
			// 반환타입 : void
			// 메소드명 : panel
			// 매개변수 : x
	void panel() {
		System.out.println("기름:" + oil);
		System.out.println("속도:" + speed);
		
	}
			
	
	
	
	

}