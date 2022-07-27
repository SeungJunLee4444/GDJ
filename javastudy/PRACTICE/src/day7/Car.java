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
		
		
	}
	
	
	
	// (3) 멈추기
	
	
	
	
	
	// (4) 계기판 (기름, 속도) 확인
			// 반환타입 : void
			// 메소드명 : panel
			// 매개변수 : x
			
	
	
	
	

}