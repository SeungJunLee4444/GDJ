package week04_1;

import java.util.Scanner;

public class SeatGroup {
	
	private String seatType;
	private Seat[] seats;
	private Scanner sc;			// * idx를 안쓴건 순서대로 배열값에 넣을 것이 아니기 때문
	
	// * has_a관계는 상속이 아니다(클래스의 특성을 이용했을 뿐)
		// => 따라서 생성자가 상속되지 않는다
	
	public SeatGroup(String seatType, int cnt) {
		this.seatType = seatType;
		seats = new Seat[cnt];
		sc = new Scanner(System.in);
		
		for(int i = 0; i < cnt; i++) {
			seats[i] = new Seat();
		}
	}
	
	public boolean reserve() {
		System.out.println("예약할 시트번호 >>> ");
		int seatNo = sc.nextInt();
		sc.nextLine();
		if(seatNo < 1 || seatNo > seats.length) {
			System.out.println(seatNo + "번 좌석은 없습니다");
			return false;
		}
		
		// * manage swithcm 반복문이 없어도, boolean을 쓰면 다시 돌아간다?
		
		if(seats[seatNo-1].isOccupied()) {
			System.out.println(seatNo + "번 좌석은 이미 예약된 자석입니다");
			return false;
		}
		
		System.out.println("예약자 진행 >>>");
		String name = sc.next();
		seats[seatNo - 1].reserve(name);
		System.out.println(seatNo + "번 좌석 예약완료");
		return true;
		
	}
	
	public boolean cancel() {
		
		System.out.println("취소자 이름 >>>");
		String name = sc.next();
		sc.nextLine();
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isOccupied()) {	// * 공석이 아님
				if(seats[i].isMatched(name)) {	// * 이름이 일치
					seats[i].cancel(name);
					System.out.println("예약자" + name + "의 예약이 취소되었습니다");
					return false;
				}
			}
		}
		System.out.println(name + "으로 예약된 좌석이 없습니다");
		return false;
	}
	
	public void reserveInfo() {
		System.out.println("[" + seatType + "]");
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isOccupied()) {
				System.out.println(seats[i].getName().substring(0, 1));
			} else {
				System.out.println((i + 1) + (i < 9 ? "  " : " "));	// * 한글자일때는 두칸벌리기, 두글짜일때는 한칸 벌리기
			}														// => 한글자 두글자 보폭맞추기
			if((i + 1) % 10 == 0) {
				System.out.println();
			}
		} System.out.println();
		
	}
	
	
	

	

}
