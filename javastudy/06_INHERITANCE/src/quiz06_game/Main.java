package quiz06_game;

public class Main {

	public static void main(String[] args) {
		
		GameUnit unit1 = new Tank("탱크");		// # gameunit가 부모클래스, tank와 marine이 자식클래스
		GameUnit unit2 = new Marine("마린");
		
		unit1.info(); // 탱크 에너지 100, 공격력 10
		unit2.info(); // 마린 에너지 50, 공격력 5
		
		System.out.println("===전투 시작===");
		
		// 공격 차례 정하기
		boolean myTurn = Math.random() < 0.5;	// 누가 공격할지 모름
		
		// 한 대씩 주고 받기
		// 두 유닛이 모두 살아있으면 계속 싸움
		while(unit1.isAlive() || unit2.isAlive()) {		
			// while(unit.getEnergy() > 0 && unit2.getEnergy() > 0 ) 
			if(myTurn) {
				System.out.println(unit1.getName() + "의 공격!");
				unit1.attack(unit2);	// unit1이 unit2를 공격한다 (탱크는 10퍼의 확률로 한번에 상대를 죽임)
						// 공격기회를 상대에게 넘김
			} else {
				System.out.println(unit1.getName() + "의 공격!");
				unit2.attack(unit1);	// unit1이 unit2를 공격한다 (마린은 40퍼의 확률로 한번에 상대를 죽임)
			}
			myTurn = !myTurn; // true였으면 false로, false면 true로
			
			
			System.out.println("===전투 종료===");
			
			// 승자확인
			if(unit1.isAlive()) {
				System.out.println(unit1.getName() + "의 승리! 남은 에너지" + unit2.getEnergy());
			} else {
				System.out.println(unit2.getName() + "의 승리! 남은 에너지" + unit1.getEnergy());
			}
		}
		
		

	}

}
