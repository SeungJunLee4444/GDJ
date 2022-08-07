package prac02_seat;

import java.util.Scanner;

public class SeatGroup {
	
	// [3주차 보충학습 : 클래스와 배열]
	
	private String seatType;
	private Seat[] seats;
	private Scanner sc;

	// * idx의 사용여부 
	// => 순차적으로 값을 집어넣어야 하는 케이스에서 사용 (번호목록)
	// => 좌석은 원하는 자리를 고르는 케이스로 이 경우에는 쓸 필요가 없다
	
	// # 생성자 : 타입별 몇개의 좌석을 만들건지?
	
	public SeatGroup(String seatType, int cnt) {
		this.seatType = seatType;
		seats = new Seat[cnt];
		sc = new Scanner(System.in);
	// => new SeatGroup("S", 10) 선언 시 null값만 10개 들어있음(배열만 형성됨)
	// ex) 마치 의자를 놓진 않고, 의자놓을 자리만 놓은것처럼
	
	// 해결 : 각 배열의 인덱스값에 seat 추가
		for(int i = 0; i < cnt; i++) {				// * 배열의 길이도 되고, cnt도 되고
			seats[i] = new Seat();					// * 빈 좌석에 의자 가져다놓기
		}
	
	}
	
	// # 예약
	public boolean reserve() {
		reserveInfo();	// * 예약현황 보여주기
		
		System.out.println("예약할 시트 번호 >>>");
		int seatNo = sc.nextInt();
		sc.nextLine();
		if(seatNo < 1 || seatNo > seats.length) {	// # 시트번호는 1부터 시작, 지정된 배열보다는 작아야한다
			System.out.println(seatNo + "번 좌석은 없는 좌석입니다");
			return false;	
		}
		
		// # 예약한 시트인지 확인 ( * 시트넘버와 인덱스값 주의하기)
		if(seats[seatNo -1].isoccupied()) {
			System.out.println(seatNo + "번 좌석은 이미 예약된 좌석입니다");
			return false;			// * isoccupied는 비어있지 않으면 true가 도출되기 때문에,
		}							//   조건이 성립되면 좌석이 찬 출력문이 나와야한다
		
		// 예약진행
		System.out.print("예약자 진행>>>");
		String name = sc.next();
		seats[seatNo - 1].reserve(name);
		System.out.println(seatNo + "번 좌석 예약 완료");
		return true;
		
	}

	// # 예약 취소
	public boolean cancel() {
		reserveInfo();	// * 예약현황 보여주기
		
		System.out.println("취소자 이름 >>>");
		String name = sc.next();
		sc.nextLine();
		for(int i = 0; i < seats.length; i++) {
			// * 이름이 있는 좌석만 비교하기
			//if(seats[i] != null) # 오류 : 배열선언 후, new seat를 했기 때문에 이미 좌석이 있음(nullx)
			if(seats[i].isoccupied()) {
				if(seats[i].isMatched(name)) {	// * 예약한 사람과 취소하려는 사람의 이름이 같으면 취소완료
					seats[i].cancel();
					// * seat 객체를 지운게 아니라 name값만 null로 바꾼것
					System.out.println("예약자" + name + "의 예약이 취소되었습니다");
					return false;
				}
			}
		}
		System.out.println(name + "으로 예약된 좌석이 없습니다");
		return false;
	}
	
	// # 예약 현황
	public void reserveInfo() {
		System.out.println("[" + seatType + "]");
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isoccupied()) {
				System.out.print(seats[i].getName().substring(0, 1) + "* ");	// * 첫번째 이름만 보이고, 나머지는 암호처리
			} else {
				System.out.print((i + 1) + (i < 9 ? "  " : " ")); // * 예약이 없는 곳에는 숫자만 표현
			}
			if((i + 1) % 10 == 0) {		// * 출력시 10칸 넘어갈때마다 줄바꿈
				System.out.println();
			}
		} System.out.println();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
