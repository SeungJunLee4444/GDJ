package schedule;

import java.util.Scanner;

public class WeekScheduler {
	
	private int nthWeek;
	private Day[] week;
	private String [] dayNames = {"일", "월", "화", "수", "목", "금", "토"};
	private Scanner sc;
	
	public WeekScheduler(int nthWeek) {
		this.nthWeek = nthWeek;
		week = new Day[7];
		sc = new Scanner(System.in);
	}
	
	private void makeSchedule() {
		System.out.println(" === 등록 ===");
		System.out.println("요일 입력 >>.");
		String dayName = sc.next().substring(0, 1); // * 목요일이라 쳐도 '목'까지만 출력
		sc.nextLine();		// * int 뿐 아니라 next에서도 쓰임
		for(int i = 0; i < week.length; i++) {
			if(dayName.equals(dayNames[i])) {
				if(week[i] == null) {
					System.out.print("스케줄 입력 >>>");
					String schedule = sc.nextLine(); // * 스케줄은 문장으로 공백도 포함될 경우를 생각해야함
					Day day = new Day();	// * day
					day.setSchedule(schedule); // (1) 클래스는 배열로 통째로 넣든 
											   // (2) 입력한 스케줄을 메서드로 넣은후, 배열에 저장하든
												// * 두가지 방법이 있다고 생각
					week[i] = day;
					System.out.println(dayName + "요일에 새 스케줄이 등록되었습니다");
				} else {
					System.out.println(dayName + "요일에는 이미 스케줄이 있습니다");
				}
				return; // * 등록되든 안되든 메서드 종료시켜야함
						// => manage로 다시 돌아간다
			}
		} System.out.println(dayName + "요일은 없는 요일입니다");
		
	}
	
	private void changeSchedule() {
		
				
		
		
		
		
		
	}
	
	private void removeSchedule() {
		System.out.println(" === 삭제 ===");
		System.out.println(" 삭제할 요일 입력>>>");
		String dayName = sc.next().substring(0, 1);
		sc.nextLine();
		for(int i = 0; i < week.length; i++) {
			if(dayName.equals(dayNames[i])) {
				if(week[i] == null) {
					System.out.println("요일에 스케줄이 없습니다");
					return;
				} else {
					System.out.println(dayName + "요일의 스케줄은" + week[i].getSchedule() + "입니다");
					System.out.println("삭제할까요(y/n)? >>>");
					String yesNo = sc.next().substring(0, 1); // * yse no를 y,n으로
					sc.nextLine();
					if(yesNo.equalsIgnoreCase("y")) {
						week[i] = null;
						System.out.println(dayName + "요일의 스케줄이 취소되었습니다");
					} else {
						System.out.println("스케줄 삭제가 취소되었습니다");
					}
					
				} 
				return;
			} 
		
		}
		System.out.println(dayName + "요일은 없는 요일입니다");
		
	}
	
	private void printWeekSchedule() {
		System.out.println(" === 전체조회 ===");
		System.out.println(nthWeek + "주차 스케줄 안내");
		for(int i = 0; i < week.length; i++) {
			System.out.println(dayNames[i] + "요일 -" );
			System.out.println(week[i] == null ? "x" : week[i].getSchedule());	
																// ? day 클래스 메서드를 사용해야 제대로 문자열값이 출력된다
																// day클래스에 @tostring이 있기 때문아닐까?		
		}
		
		
	}
	
	
	public void manage() {
		while(true) {
			System.out.println("1. 등록 2. 수정 3. 삭제 4. 전체조회 0. 종료 >>>");
			int choice = sc.nextInt();
			sc.nextLine();	// * next는 단어출력, nextline은 문장출력
							// * nextint는 엔터값이 인식될 수 있어, nextline으로 처리
			switch(choice) {
			case 1 : makeSchedule(); break;
			case 2 : changeSchedule(); break;
			case 3 : removeSchedule(); break;
			case 4 : printWeekSchedule(); break;
			case 0 : System.out.println("프로그램 종료"); return;
			default : System.out.println("인식할 수 없는 명령입니다");
			}	// * default 되면 switch 문을 나가 다시 while문으로 돌아간다
		
		}
		
	}

}
