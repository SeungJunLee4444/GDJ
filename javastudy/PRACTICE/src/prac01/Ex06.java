package prac01;

public class Ex06 {

	public static void main(String[] args) {
		
		

		// string배열에 도개걸웇모 생성
		// string 배열의 인덱스값을 이동칸 수로 이용
		// * string 배열에 0번째 인덱스를 ""로 하면 1부터 시작할 수 있다
	
		// while 반복문
		// 이동한 칸수를 표현할 int 변수 선언 후 
		// int에 담긴 랜덤한 값에 따라 
		
		
		// 6
		String[] arr = {"", "도", "개", "걸", "윷", "모"};
		// # 인덱스값을 이동칸으로 이용하기 위해 0idx에 공백부여
		
		// # 계속 랜덤 생성을 하는것이 전제조건 while(true)
		
		int total = 0; 
		//# 윷을 던진 횟수
		
		while(true) {
			int move = (int)(Math.random() * 5 + 1); // # 1에서 5 숫자 랜덤발
			
			total += move;
			// # 윷을 던진 칸수를 전부 더할 값이 필요하다
			
			if(move <= 3) {
				System.out.println(arr[move] + ", " + total + "칸" + "이동한다");
				break;
				
				// # 특정 조건을 제외한 범위를 위에 먼저 선언
			}
			
			System.out.print(arr[move] + ", ");
		} 
		
		
		
		
	

	}

}
