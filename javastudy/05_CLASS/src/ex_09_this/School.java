package ex_09_this;

public class School {
	
	// 1. 필드
	private Student[] students;
	private int idx; // 0, 
	// = student 배열의 인덱스이자, student 배열에 저장된 학생수와 같다
	
	//-----------------------------------------------
	
	// 2. 생성자
	public School(int cnt) {
		students = new Student[cnt]; 
	} 
	// (1) school 생성자를 만들고
	// (2) cnt 정수값이 배열의 길이가 되는 student 클래스 선언 *
	
	
	// & 생성자 메소드는 반환타입 없음 *
	
	//-----------------------------------------------
	
	// 3. 메소드
	public void addStudent(Student student) {
	
		if(idx == students.length) {
			System.out.println("Full");
			return; 
			// => 메소드가 void일때 메소드를 종료시키는 것 *
			//# 만약 배열의 길이가 2면 아래 식으로 이행되지 않고 메소드 자체를 종료
			//# 즉 1까지만 계산 *
			//* break는 해당if문만 종료, return은 메소드 자체를 종료시킴 *
			
		// idx 인덱스의 길이가 	
		}
		students[idx++] = student; 
		// * student 클래스에 입력된 문자열값을 
		// * students[idx = 0] 에 넣고 idx는 1씩 증가
		// & idx++ 밖에 써도됨
		
		//# index가 0이였으니 0 과 1인덱스의 자리에, student1, 2를 
		//# addstudent 두번을 실행해 값을 저장
		
	}
	public void printStudents() {
//		for(int i = 0; i < idx; i++) { // idx로하면 학생수가 0일떄 오류 x
//			System.out.println(students[i].getName() + ", " + students[i].getStuNo());
//		}
		// length 2고정, 학생수0이면 null값이 
		// * students.lengt든 idx든 값은 같을텐데
		//# students[i].getName => 만약 배열에 저장된 값이 0일떄,
		//# .getname값은 null이 나오기 떄문?
		
		// * 향상 for문
		for(Student student : students) { 
			if(student != null) {
				System.out.println(student.getName() + ", " + student.getStuNo());
			}
			
		}
		
	}
}
