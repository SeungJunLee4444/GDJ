package ex02_writter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// * ctrl + shift + o : import 정리, 필요한 내용 만들어주고, 필요없는 내용 가져와줌

public class Main {
	
	public static void m1() {
		
		File dir = new File("c:\\storage");
		if(dir.exists() == false) {
			dir.mkdir();
		} 
		File file = new File(dir, "m1.txt");
		// * 경로를 string 말고도, 파일 이름으로도 받아올 수 있다
		
		// 1. 파일 생성
		
		// 1. Filewritter(스트림)로 폴더, 파일 만들기
				// * 출력 스트림을 이용해 파일을 만들면 마지막에 수정된 타이밍을 기준으로 최신화된다
		
		// 1) filewritter로 출력스트림으로 폴더와 파일 생성
		
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);	// = new FileWritter(c:\\storage\\m1.txt) *1 위와 동일
//			fw.close(); // 문제3 아래에 close를 두는것이 정석이나, 실제로는 예외가 잘 발생하지 않기 때문에, 여기에 써도되긴함
			// *2 stream의 생성은 언제나 exception이 필요하다
			
			// *3 
			// 코드
			// 코드 (문제1)	: 오류, 이러면 예외가 있는 코드 이후의 코드들이 실행되지 않는다
			// 코드
			
			// *4 fw resource leak 오류
			// => fw.close를 작성해주면된다
		} catch (IOException e) {
			e.printStackTrace();	
		} finally {			
			try {
				if(fw != null) {	// 문제2 해결
					fw.close();	// *문제1해결책 finally에 작성하면, 예외가 발생하든 말든 종료된다
				}
				// * trycatch에서 null값이 메서드로 던져지면 null 오류가 발생한다
				// => if문을 사용해 해결
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
		
		// createnewfile(파일생성코드) 없이 실행된 상태
		
		
	}
		
	public static void m2() {
		
		// 2. 데이터를 파일에 저장하기
		
		File file = new File("c:\\storage", "m2.txt");
		
		FileWriter fw = null;
		
		try {
			// 1) 출력 스트림 생성
			fw = new FileWriter(file);
			
			// 2) 데이터를 출력
			// => 한글자일때는 int / 여러글자일때는 char[], String에 담는다
			
			int c = 'i';
			char[] cbuf = {' ', 'a', 'm'};
			String str = " IronMan";
			
			// 3) 출력스트림으로 보내기
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
		
		// 3. try-catch-resources 문
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
		
		// 3-1. 일부내용만 파일에 저장하기
	
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
		
			// 4. filewritter은 속도가 느리기 때문에, bufferedwriter을 추가해서 함께 사용한다
			
			File file = new File("c:\\storage", "m5.txt");
			
			FileWriter fw = null;
			BufferedWriter bw = null;
			
			try {
				
				fw = new FileWriter(file); // *1 출력 메인스트림
				bw = new BufferedWriter(fw); // *2 속도 향상을 위한 보조스트림(메인스트림이없으면 사용x)
				
			  //fw.write(null);	
				bw.write("오늘은 수요일인데 수업이 안끝나요 ㅎㅎㅎ");	// * 만들고 나면 이걸로 사용
				
			} catch (IOException e) {
				e.printStackTrace();	// * 정밀한 오류내역 출력
			} finally {
				try {
					// *3 메인스트림은 닫을 필요가 없다(보조를 닫으면, 메인은 자동으로 닫힘)
					if(bw != null) {	// * 시작값이 null이라서?
						bw.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
			
		}
		

	public static void main(String[] args) {
		
		//m1();
		//m2();
		//m3();
		//m4();
		m5();
		
		

	}

}
