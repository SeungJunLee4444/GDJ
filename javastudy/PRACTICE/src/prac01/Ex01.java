package prac01;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("점수를 입력하세요(0~100) >>> ");
		int score = sc1.nextInt();
		System.out.println("점수를 입력하세요(0~100) >>> ");
		int year = sc1.nextInt();
		
		// # scanner로 입력한 값을 각각 score과 year에 저장해주세요
		
		if(score >= 60) {						// # 60점 이상이면 합격
			System.out.println("합격");			
			if(year != 4) {						
				System.out.println("합격");			// # 60점 이상일 때 +  4학년이 아니면 합격
			} else if(score >= 70) {					
				System.out.println("합격");			// # 60점 이상, 4학년일 때 +  70점 이상이면 합격 
			} else {
				System.out.println("불합격");		// # 그 외에는 불합격
			}
		}
		else {
			System.out.println("불합격");		// # 60점 미만이면 불합격
		}
		
		// * if문 안의 if문
		// => 안의 if문은 밖의 if문을 기본조건으로 깔고 있음을 고려 * 
		// * if문에서 특정 조건이 주어질 때
		// => 최대한 넓은 범주를 먼저 해결하도록 코드를 작성할 것

	}

}
