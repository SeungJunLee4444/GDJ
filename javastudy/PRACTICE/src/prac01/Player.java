package prac01;

import java.util.Scanner;

public class Player {
	
	// # 필드
	private String name;
	private Scanner sc;
	// # 스캐너 클래스를 play클래스 안에 담음
	
	
	
	
	// # 메소드
	
	public Player(String name) {
		this.name = name;
		if(sc == null) {
			sc = new Scanner(System.in);
		}
		// # play 메서드를 사용하면 새로운 스캐너 형성
		// * 생성자는 반환값이 없다
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// # 시간 계산기
	
	public double turn() {
		System.out.println(name + "님 시작하려면 <Enter> 을 누르세요!");
		sc.nextLine();
		long begin = System.currentTimeMillis();
		System.out.println("10초가 된 것 같으면 <Enter>을 누르세요!");
		sc.nextLine();
		long end = System.currentTimeMillis();
		return (end - begin) * 0.001;
		
		// currenttimemillis를 빼고 0.001을 곱하면
		// 초단위 시간을 구할 수 있다
		
		
	}
	
	
	
	
	
	
	

	
	
	
	
	
}
