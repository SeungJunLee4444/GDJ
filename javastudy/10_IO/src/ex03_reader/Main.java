package ex03_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	
	public static void m1() {
		
		// [1] FileReader 클래스
		
		// 1. 
	
		
		// 1) 생성
		File file = new File("c:\\storage", "m2.txt");
		FileReader fr = null;	
		try {
			fr = new FileReader(file);
			// * filewriter 생성자 파라미티에 file객체를 넣으면 파일을 생성해주지만,
			// 읽는 입장에서는 파일이 없으면 오류가 발생한다
			
			// * 입력데이터 **
			// {1} 한글자 	: int
			// {2} 여러글자	: char[], (* filereader에서는 String[]은 안됨)
			
		// 2) 출력	 ***
			// (1) read 메서드
			// => 읽은 문자 전체를 하나의 문자열로 반환
			// => 모두 읽어서 읽은 문자가 없으면 -1 반환
	
			// # 받은 데이터를 String str에 파일 내용 저장하기
			
			StringBuilder sb = new StringBuilder();	// * string + 연산은 효율이 좋지 않기 때문에, builder을 사용한다 **
			int c; 
			while((c = fr.read()) != -1) {
				sb.append((char)c); // * true 무한루프 대신 쓰는것
			}
		
			while(true) {
				c = fr.read();
				if(c == -1) {
					break;
				}
				sb.append((char)c); 	// * 알파벳을 int에 저장하기 때문에 변한 아스키코드를 char로 캐스팅
			}
			String str = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fr != null) {
				try {
				fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void m2() {
		
		// 3) 여러글자 받아오기
		File file = new File("c:\\storage", "m3.txt");
		FileReader fr = null;
		
		try {
			fr = new FileReader(file);
			
			// 1) 5글자를 저장할 배열
			char[] cbuf = new char[5];	// * 한번에 5글자 씩 읽으라는 뜻
			
			// * m3.txt 파일 읽는 과정
			// 		readCnt		cbuf
			// 1	5			a	p	p	l	e
			// 2	5			\n	m	a	n	g
			// 3	2			o	\n	a	n	g
			// 4 	-1
			// (* 엔터도 포함)
			// => cbuf.length 대신 readCnt를 써야하는 이유
			
			
			
			// (1) read(char[]) 메서드
			// => 읽은 글자는 cbuf 배열에 저장
			// => 실제로 읽은 글자 수를 반환
			// => 읽은 글자가 없으면 -1 반환
			while(true) {
				int readCnt = fr.read(cbuf); // * 글자수를 readCnt에 반환
				System.out.println(readCnt);
			// ex) 나는 아이 => cbuf 배열에 들어가고, 5가 반환되어 readCnt에 저장
				if( readCnt == -1) {	// * 반환할 글자가 없으면 while문 멈춤
					break;
				}
				for(int i = 0; i < readCnt; i++) {	// * 문제 : 3글자만 읽을꺼면 3글자만 보여줘야하는데 배열의 길이는5
					System.out.print(cbuf[i]);		// => 해결 : 읽은 글자수만큼 for문 돌리기
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fr != null) {
				try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
		}
		}
	
	public static void m3() {
		
		// 3. m3.txt를 읽어서 String str에 저장
		File file = new File("c:\\storage", "m3.txt");
		
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			/*
			char[] cbuf = new char[5];
			StringBuilder sb = new StringBuilder();
			while(true) {
				int readCnt = fr.read(cbuf);
				if(readCnt == -1) {
					break;
				} 
				sb.append(cbuf);
				sb.append(cbuf, 0, readCnt);	// 마지막 2개의 글자만 읽을 수 있도록 stringbuilder에 일부분만 추가
			}
			String str = sb.toString();
			*/
			char[] cbuf = new char[5];
			StringBuilder sb = new StringBuilder();
			int readCnt;
			while((readCnt = fr.read(cbuf)) != -1) { // * 5글자면 5글자, 3글자면 3글자 **
				sb.append(cbuf, 0, readCnt);	// * 이걸로 공부하길 권장
			}
			
			sb.append(cbuf);
			sb.append(cbuf, 0, readCnt);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fr != null)
			try { 
				fr.close();
					} catch (IOException e) {
					e.printStackTrace();
				
				}
			}
		}
	
	public static void m4() {
		
		// 4. 
		// => filereader은 느리기 때문에, bufferedReader를 추가해서 속도를 향상시킨다
		
		// 1) bufferedReader은 readline(); 메서드를 지원한다
		// => 한줄씩 읽어서 String에 저장한다 *
		// => 읽은 내용이 없으면 null(문자열이기 때문에)을 반환한다
		
		File file = new File("c:\\storage", "m4.txt");
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			StringBuilder sb = new StringBuilder();
			String line = null;
			
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");//append("\n"); 			// * readline은 줄바꿈 기호를 못가져온다
																// => 별도로 추가해줘야함
			}
			String str = sb.toString();
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
			if(br != null) {
				br.close();
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void m5() {
		
		// 5. m4번을 try catch resource타입으로 만들기
		// => "내려받는 코드"라 생각하고 외우기
		
		
		try(BufferedReader br = new BufferedReader(new FileReader("c:\\storage")))  {
			StringBuilder sb = new StringBuilder();
//			File file = new File("c:\\storage", "m4.txt");  * filebuilder에 file 대신 경로를 써도 된다
		
			String line = null;
			
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			String str = sb.toString();	// * stringbuilder을 string으로 다시전환(다른 클래스타입이니까)
			System.out.println(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// => filereader의 주소를 통해 받은 데이터를 str에 저장하는 코드
	
	

	public static void main(String[] args) {

		m1();
		m2();
		//m3();
		//m4();
		//m5();
	}

}
