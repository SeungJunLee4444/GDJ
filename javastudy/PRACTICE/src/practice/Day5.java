package practice;

import java.sql.SQLOutput;
import java.util.Scanner;

import javax.sql.rowset.serial.SQLOutputImpl;

public class Day5 {

	public static void main(String[] args) {
		
		//----------------------------------------------------------------------
		
		// [String]
				
		// 연습1
		// 파일이름을 파일명과 확장자로 분리
		// 단, jpg, git, png 이미지인 경우에만 작업을 진행한다
		String fullName = "apple.jpg";
		String fileName = ""; // apple
		String extName = ""; //jpg
		
		int idxOfDot = fullName.lastIndexOf(".");
		fileName = fullName.substring(0, idxOfDot);
		extName = fullName.substring(idxOfDot + 1);
		System.out.println(fileName);
		System.out.println(extName);
		
		
				
		// 연습2
		// 문자열 "abc12345def67890ghijk"에서, 
		// 아라비아 숫자 12345. 67890을 제외하고 한글자씩 화면에 출력하기
		String str = "abc12345def67890ghijk";
		
//		for(int i = 0; i <= str.length() -1; i++) {
//			System.out.println(str.charAt(i));
//		}
		
		for(int i = 0; i < str.length(); i++) { // =을 빼버리고 +1 *
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9' ) {
				continue;
			}
			System.out.println(str.charAt(i));
		} // => 개발자는 두번째 코드를 쓴다 *
		
		// 연습2-2
		
		
//		for(int i = 0; i < str.length(); i++) { // =을 빼버리고 +1 *
//			char ch = str.charAt(i);
//			if(ch >= '0' && ch <= '9' ) {
//				continue;
//			}
//			System.out.println(ch);
			
			// => 반복되는 charAt값을 별도의 변수에 저장하여 단축시키기 *
		
		
		// {1} 아라비아 숫자를 제외하라
				
		//----------------------------------------------------------------------
		
		// [StringBuilder]
		// 연습1 대문자 6자리로 구성된 인증코드 만들기
		StringBuilder sbcode = new StringBuilder();
		//String code = sbcode.toString();
		//System.out.println("인증코드:" + code);
		
		for(int t = 0; t < 6; t++) {
			sbcode.append((char)(int)Math.random() * 26 + 'A');
			
		} 
		String code = sbcode.toString();
		System.out.println("인증코드:" + code);
		
		//-----------
		
		// => 아래의 방식은 랜덤한 숫자를 출력하는 방식이다
		String str4 = "";
		for(int p = 0; p < 6; p++) {
			str4 += (char)(int)(Math.random() * 26 +'A');
		} System.out.println("인증코드" + str4);
		
		//-----------
		
		// 연습2 1 2 3 4 5 6 7 8 9 10 만들기
		StringBuilder sbPaging = new StringBuilder();
		for(int n =1; n <=10; n++) {
			sbPaging.append(n + " ");
		}
	
		
		String paging = sbPaging.toString();
		System.out.println(paging);
		
		//----------------------------------------------------------------------
		
		// [Scanner]
		
		// 연습1 char 타입의 성별을 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.println("성별(남/여)을 입력하세요 >>> ");
		char gender = sc.next().charAt(0);
		System.out.println(gender);
		
		sc.close(); // 생략 가능하다
		
		
		
	}

}
