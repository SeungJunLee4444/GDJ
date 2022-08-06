package prac01_answer;

public class Ex07 {

	public static void main(String[] args) {
		
		Player p1 = new Player("철수");
		Player p2 = new Player("영희");
		
		double res1 = p1.turn();
		double res2 = p2.turn();
		
		// # res1,2는 철수와 영희의 경과시간값
		
		// 10초가 되었다 싶으면 정지해라
		// res1,2 둘다 10초 이상일 경우
		//	=> 10초를 빼면  
		
		// res1,2 둘중 하나가 10이상, 10이하일 경우
		// res1, 2둘다 10초 이하일경우
		
		
		// ? 이게뭔데------------------------------------------------?
		if(Math.abs(res1 - 10) < Math.abs(res2 - 10))
			System.out.println(p1.getName() + "님 승리. " + res1 + "초 소요.");
		else
			System.out.println(p2.getName() + "님 승리. " + res2 + "초 소요.");
		
		
		// * abs는 음수값을 절대값으로 반환하는 메서드다 
		// ex) -5 를 5
	}
	
}
