package prac2;

public class Seat {
	
	private String name;
	
	// # 생성자
//	public SeatGroup(String name) {	// * 빈 좌석을 확인하는 것이 목적이라 생성자가 부적합
//		super();
//		this.name = name;
//	}
	
	// # 예약한 사람 확인
	public String getName() {
		return name;
	}
	
	// * 예약한 사람 확인 2
	public boolean isMatched(String name) {
		return this.name.equals(name);			// * 받아온 이름과 , 현재 좌석의 이름과 일치하는가?
		
	}

	// # 예약
	public void reserve(String name) {
		this.name = name;
	}
	
	// # 예약 취소
	public void cancel() {
		name = null;
	}
	
	// # 예약여부 확인(* boolean 타입의 반환명은 is를 붙인다)
	public boolean isoccupied() {
		return name != null;	// * null이 아니면 true 반환 (= 예약했다는 의미)
	}
	
	

	
	

}
