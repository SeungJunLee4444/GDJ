package week04_1;


public class Seat {
	
	private String name;
	
	// # 예약한 사람 이름 가져오기
	
	public String getName() {
		return name;
	}
	
	// # 예약한 사람 확인 하기	=> 좌석의 이름과 현재 이름이 같은가?
	
	public boolean isMatched(String name) {
		return this.name.equals(name);
	}
	
	// # 예약하는 메서드
	public void reserve(String name) {
		this.name = name;
	}
	
	// # 예약 취소
	public void cancel(String name) {
		this.name = null;
	}	
	// # 예약좌석 메서드 => 좌석이 이미 차있는지?
	public boolean isOccupied() {
		return name != null;
	}
	

	
	

}
