package ex02_datetime;

public class Ex01_System {

	public static void main(String[] args) {

		// [2] 클래스
		// => System.out의 시스템이 바로 클래스 *
		
		// 1. 타임 스탬프 * 중요함
		// 1970-01-01 0:00부터 1초마다 증가하는 long 타입의 정수값
		
		// 1) 현재시간
		long timeStamp = System.currentTimeMillis(); // => 현재시간 천분의 1초
		System.out.println(timeStamp);
		
		// 2) 경과시간
		
		 
		// 2. 나노타임(nanoTime)  * 별로 안중요함
		// s > ms(천분의 1초) > ㎲(백만분의 1초) > ㎱(10억분의 1초) * 
		// 나노초(ns)값을 가지는 long 타입의 정수값 
		// 어떤 기준일자는 없어서 두 개의 나노초 사이에(ns) 경과시간 계산용
		
		long beginTime = System.nanoTime();
		int total = 1 + 2 + 3 + 4 + 5;
		long endTime = System.nanoTime();
		System.out.println(total + "계산에 걸린 시간 : " + (endTime - beginTime) + "ns");
		
		
	}

}
