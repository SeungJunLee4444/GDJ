package practice;

public class Watch {
	
	
	// # 필드
	private int hour;
	private int min;
	private int sec;
	
	// # 생성자 메서드
	
	public Watch(int hour, int min, int sec) {
		this.hour = hour;
		this.min = min;
		this.sec = sec;
	}
	// * 생성자는 클래스명과 동일해야한다
	
	// # add 메서드들
	
	public void addHour(int hour) {
		if(hour < 0) {
			return;
		}
		this.hour += hour;
		this.hour %= 24;
		// # 24시간 반복 코드
		// ex) 24시에 24를 나눈값은 0시 *
	}
	public void addMin(int min) {
		if(min < 0) {
			return;
		}
		this.min += min;
		addHour(this.min / 60);
		this.min %= 60;
		}
	// # addHour 메서드 선언과 60이상의 분이 입력될때
	// # 60이상은 0분
	
	public void addSec(int sec) {
		if(sec < 0) {
			return;
		}
		this.sec += sec;
		addMin(this.sec / 60);
		this.sec %= 60;
		}

	// # 시계 메서드
	public void see() {
		System.out.println(hour + "시간" + hour + "분" + hour + "초");
	}
}
	
	
	
	
	
	
	
	



	
