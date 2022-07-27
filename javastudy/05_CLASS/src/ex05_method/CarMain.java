package ex05_method;

public class CarMain {

	public static void main(String[] args) {
		
		// 연습 2 자동차로 필드, 메소드 동시에 활용하기
		
		// 1) 객체생성
		Car car = new Car();
		
		car.addoil(50);
		car.addoil(5);
		car.addoil(100);
		System.out.println(car.oil);
		
		
		car.pushAccel(); // 엑셀 한번? * 
		car.pushAccel();
		
		System.out.println("기름" + car.oil); // 58
		System.out.println("속도" + car.speed); // 50 (액셀 두번밟음)

		
		car.PushBrake();
		car.PushBrake();
		car.PushBrake();
		
		car.panel();
		
		
		
		
		
		
		
	}

}
