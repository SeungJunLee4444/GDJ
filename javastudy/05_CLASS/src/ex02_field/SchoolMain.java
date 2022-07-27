package ex02_field;

public class SchoolMain {

	public static void main(String[] args) {
		
		// 학교명
		School school = new School();
		school.name = "경인중학교";
		
		// --------------------------
		
		// 학생정보
		Student student1 = new Student();
		student1.name = "전지현";
		student1.stuNo = "11023";
		
		Student student2 = new Student();
		student2.name = "정우성";
		student2.stuNo = "14923";
		
		// --------------------------
		
		// students 배열요소 = student1, 2 반환값
		school.students[0] =student1;
		school.students[1] =student2;
		
		// --------------------------
		
		// 학생이름 출력
		for(int i = 0; i < school.students.length; i++) {
			System.out.println(school.students[i].stuNo);
			System.out.println(school.students[i].name); // 다른 클래스에서 메소드를 가져올 수 있는건가? ㅇㅇ
			
//&		// * 오류
		// student 클래스의 student1,2에는 각자 값이 저장되있지만,
		// school 클래스의 students 배열요소에는 아무런 반환값이 없다(초기값) *
		// => 따라서 student1,2의 값을 students 배열요소에 저장해줘야한다
		}
	}

}
