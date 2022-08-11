package ex02_writter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// * ctrl + shift + o : import 정리, 필요한 내용 만들어주고, 필요없는 내용 가져와줌

public class Main {
	
	public static void m1() {
		
		// 1. 폴더 생성
		
		File dir = new File("c:\\storage");
		if(dir.exists() == false) {
			dir.mkdir();
		} 
		File file = new File(dir, "m1.txt");
		// * 경로 외에도 폴더의 객체명을 사용해도된다
		
	
		// 2. 스트림으로 파일만들기
	
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);	// = new FileWritter(c:\\storage\\m1.txt) *1 위와 동일
			
		// & 기타 -----------------------?
		// 코드
		// 코드  => 예외가 발생하면 아래의 예외사항이 실행되지않는다
		// 코드	 => 공통된 예외는 언제나 멀티플하게 사용할것 *
			
			// *4 fw resource leak 오류
			// => fw.close를 작성해주면된다
		} catch (IOException e) {
			e.printStackTrace();	
		} finally {			
			try {
				if(fw != null) {	
					fw.close();	 // * close를 작성하지않으면 resource leak 경고가 뜬다(생략가능)
				}
				// * trycatch에서 null값이 메서드로 던져지면 null 오류가 발생한다
				// => if문을 사용해 해결
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
		
		
		
		
	}
		
	public static void m2() {
		
		// 3. 데이터를 파일에 작성하기
		// * 데이터 저장시, 한글자씩 읽을때는 int, 여러글자를 한번에 읽을때는 char[], string을 쓴다
		// * 데이터작성은 filewriter과 write() 메서드
		
		File file = new File("c:\\storage", "m2.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			
			int c = 'i';
			char[] cbuf = {' ', 'a', 'm'};
			String str = " IronMan";
			// * 데이터는 빈공간도 1byte 취급한다
			
			// 3) 출력스트림으로 문서에 데이터를 작성
			fw.write(c);
			fw.write(cbuf);
			fw.write(str);

			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null)  {	// * filewriter은 파일에 내용을 저장하는 메서드, 내용이 null이 아닐때 멈춤
					fw.close();
				} 
				}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		}
	
	public static void m3() {
		
		// 4. try-catch-resources 문
		// => resource는 자원으로, 여기서는 스트림을 의미한다
		// * 스트림의 종료(close)를 자동으로 처리하는 try-catch문을 의미한다
		
		// 1) 형태
		// (기존)
		try {} catch (Exception e) {e.printStackTrace();}
		// * finally의 존재이유는 오직 close를 넣기 위해서다
		// (변화)
		//try (스트림 생성자) {} 
		// => close를 자동으로 진행해주는 try문이 t-c-r문이다
		
		File file = new File("c:\\storage", "m3.txt");
		try(FileWriter fw = new FileWriter(file)) {
			
			fw.write("나는 아이언맨이다.");
			fw.write("\n");
			fw.write("너는 타도스냐? \n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		// 5. 일부내용만 파일에 저장하기
	
		public static void m4() {
			File file = new File("c:\\storage", "m4.txt");
		
		
		try(FileWriter fw = new FileWriter(file)) {
			char[] cbuf = {'a', 'b', 'c', 'd'}; 
			String str = "abcde";
			
			fw.write(cbuf, 0, 2);	// 인덱스0부터 2글자		// * 일부만 내용 저장하기
			fw.write(str,2, 3); 	// 인덱스 2부터 3글자
		} catch (IOException e) {e.printStackTrace();
		}
	}
		
		public static void m5() {
		
			// 6. filewritter은 속도가 느리기 때문에, bufferedwriter을 추가해서 함께 사용한다
			
			File file = new File("c:\\storage", "m5.txt");
			
			FileWriter fw = null;
			BufferedWriter bw = null;
			
			try {
				
				fw = new FileWriter(file); 
				bw = new BufferedWriter(fw); // *2 속도 향상을 위한 보조스트림(메인스트림이없으면 사용x)
				
			  //fw.write(null);	
				bw.write("오늘은 수요일인데 수업이 안끝나요 ㅎㅎㅎ");	
				
			} catch (IOException e) {
				e.printStackTrace();	// * 정밀한 오류내역 출력
			} finally {
				try {
				
					if(bw != null) {	// * 시작값이 null이라서?
						bw.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
			
		}
		

	public static void main(String[] args) {
		
		m1();
		m2();
		//m3();
		//m4();
		//m5();
		
		

	}

}
