package prac01;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 개의 랜덤을 생성할까요? >>> ");
		int count = sc.nextInt();
		
		if(count < 1 || count > 100) {
			System.out.println("다음에는 1~100 사이로 입력하세요");
			return;
			// # 메소드 자체를 끝내야함
		}
		
		int[] arr = new int[count];
		// * 배열 선언 주의
		
		for(int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random() * 100 + 1);
			
			if(exists(arr, i, random)) {
				i--;
				// # 만약 겹치는게 나오면 i하나 빼서, 다시 실행하라 *
				continue;
				// # 반복문을 탈출 안하고 다시 위로 돌아감
				}
			arr[i] = random;
			} 
		
		for(int i = 0; i < arr.length; i++) {
			if(i != 0 && i % 10 == 0) {		// # 값이 10의 배수일때마다가 나올떄마다 줄바꿈
			System.out.println();			// * 세부적인 조건은 위로, 공통조건은 아래로
			}
			System.out.print(arr[i] + "\t");
		}	
}

	// # random 검사 메소드
	// 랜덤으로 생성된 정수값이 겹치는 값이 없도록 임의의 메소드 만들기
	public static boolean exists(int[] arr, int idx, int random) {	
		// # boolean 타입의 반환값이 있는 exists 메서드 생성
		for(int i = 0; i <= idx; i++) 
			if(arr[i] == random) 
				return true;
			
			return false; 
		// 
		}
	


}