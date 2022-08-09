package prac04_o;

public class KoreaTour implements Tour {

	@Override
	public void sightseeing() {
		System.out.println("광화문여행");

	}

	@Override
	public void leisure() {
		System.out.println("한강유람선");

	}
	
	// * 클래스 생성시, add를 사용하면 인터페이스에서 구현해야할
	// 모든 메서드들을 자동으로 만들어준다

}
