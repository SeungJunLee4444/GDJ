package ex09_upcasting;

public class Main {

	public static void main(String[] args) {
		
		// ex09 : 업캐스팅
		// # 업캐스팅 : 슈퍼클래스 객체로 서브클래스 호출해서 만들기
		Person alba = new Alba();
		alba.eat();
		alba.study();
		alba.work();
		
		// # new student 와 new alba는 모두 person 타입으로 처리할 수 있다
		// => 객체가 다른데 동일한 타입으로 처리 가능하다
		
		// 한 교실에 student와 alba가 섞여있다
		// => person 타입의 배열을 이용해 모두 처리할 수 있다
		
		Person[] people = new Person[10];
		
		people[0] = new Alba();
		people[1] = new Alba();
		people[2] = new Student();
		// # 
		
//		for(int i = 0; i < people.length; i++) {
//			if(people[i] != null) {
//				people[i].eat();
//				people[i].study();
//				people[i].work();
//			}
			// null 오류, 배열에 빈칸이 있기 때문
			// => if문을 통한 해결
		
		for(Person person : people) {
			if(person != null) {
				person.eat();
				person.study();
				person.work();
			}
		}
		
	}
}
