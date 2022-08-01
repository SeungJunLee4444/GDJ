package quiz_03;

public class Seat {
	
	// # 몇명이 앉는지 저장
	
	private Person person;
	// person 업캐스팅
	// => person, student, alba를 모두 저장할 수 있는 타입은 person
	// * 셋 중 부모 클래스는 person
	
	// * is a 상속과 has a 상속을 혼합한 형태?
	
	
	// # Seat 생성자 생략하면
	// punlic Seat() {
	// } // => 디폴트 생성자
	// => new seat 선언시 자동 생성

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
		// => 
	}

}
