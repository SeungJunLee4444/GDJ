package ex_09_this;

public class SchoolMain {

	public static void main(String[] args) {
		
		// 1. student 클래스 선언과 필드값 입력
		
		Student student1 = new Student();
		
		student1.setStuNo("11025");
		student1.setName("전지현");
		
		Student student2 = new Student("11925", "정우성");
		
		// 2명의 학생이 있음
		
		// --------------------------------------
		
		// 2. school 클래스 생성
	
		School school = new School(2); 					// * 길이가 2인 student 배열 생성
		// => school 클래스에서 student배열
		// school.printStudents();
		school.printStudents();
		school.addStudent(student1);
		school.addStudent(student2);
	
		
		school.printStudents();
		
	}

}
