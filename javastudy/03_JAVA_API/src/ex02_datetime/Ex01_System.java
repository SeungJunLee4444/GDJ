package ex02_datetime;

public class Ex01_System {

	public static void main(String[] args) {

		// [2] System 클래스
			
		// 1. 타임 스탬프 * 중요함
			// 컴퓨터 처리시간 단위:  s > ms(천분의1초) > ㎲(백만분의1초) > ㎱(10억분의1초) 
		
			// 1) System.currentTimeMillis
				// 1970-01-01 0:00부터 ms(밀리초)를 단위로 현재까지 카운트된 시간을 말한다
				// long 타입
				// 날짜와 관련된 계산을 위해 사용하는데 적합 *
		
		long timeStamp = System.currentTimeMillis(); // => 현재시간 천분의 1초
		System.out.println(timeStamp);
		
			// 2) System.nanoTime ( * 별로 안중요하다) 
				// => ns단위의 long타입값을 지닌 메소드
				// => 코드의 수행시간을 측정하는데 적합 *
					
				// ex) 활용법
		
		long beginTime = System.nanoTime();
		int total = 1 + 2 + 3 + 4 + 5;
		long endTime = System.nanoTime();
		System.out.println(total + "계산에 걸린 시간 : " + (endTime - beginTime) + "ns");
		
	}

}
