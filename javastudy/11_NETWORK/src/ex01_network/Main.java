package ex01_network;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
	
	public static void m1() {
		
		// & 정리
		// 1. url 클래스
		// => url은 인터넷 주소( ex) https://search.naver.com/search.naver?=날씨")
		// => 프로토콜(http), 호스트(서버주소), 서버경로(url mapping), 파라미터(서버로 전송하는 데이터)
		
		try {
		String apiURL = "https://search.naver.com/search.naver?=날씨";
		URL url = new URL(apiURL);	// # 오류발생 : exception
		
		// (1) URL 확인
		System.out.println("프로토콜:" + url.getProtocol());
		// (2) 호스트 확인
		System.out.println("호스트: " + url.getHost());
		// (3) 파라미터
		System.out.println("파라미터: " + url.getQuery());
		// (4) 웹접속용 메서드
		//url.openConnection();
		// => 웹 접속시 httpurlconnection 클래스를 사용할때 사용하는 메서드
		// * ioexception 예외가 발생
		
		} catch (MalformedURLException e) { 	// * uri와 url 혼동 주의
			System.out.println("API 주소 오류");
		} 
		// & 정리 
		// 1) URL 클래스는 생성시 MALFORMEDURLEXCEPTION 오류가 발생한다
		// 2) url의 메서드인 getprotocol => http / gethost => 서버주소 / getquert => 파라미터)를 확인가능
		// 3) 웹 접속에 사용되는 openconnection()도 url 클래스에 있다
	}
	
	public static void m2() {
		
		// 2. httpurlconnection 클래스
		// => 웹 접속을 담당하는 클래스 *
		// => url 클래스와 함께 사용
		// => urlconnection 클래스의 자식 클래스
		// * url 클래스의 openconnection() 메서드를 호출하면 urlconnection이 되며, 이를 httpurlconnection 클래스 타입에 저장 *
		
		// & 정리
		// httpurlconnection 
		// (1) 응답코드		: getresponsecode() -정상(200), 사용자오류(40x), 서버오류(50x)
		// (2) 컨텐트 타입	: getcontenttype() - 영어인지, 한글인지
		// (3) 요청방식		: getresuestedmethod
		// (4) 커넥션 종료  : disconnect();
		// (5) 바이트타입 스트링 : InputStream in = con.getInputStream(); *
		// => 웹 주소의 내용을 바이트 타입 스트링 연결을 할 수 있다
	
		
		
		try {
			String apiURL = "https://www.naver.com/";
			URL url = new URL(apiURL);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection(); // * 타입이 맞지 않아 오류 => 강제 캐스팅
			
			// 1) http 응답 코드 메서드 (httpurlconnection - getresponsecode)
			// (1) 200 : 정상
			// (2) 40x : 요청이 잘못되었음(사용자잘못)
			// (3) 50x : 서버오류
			System.out.println("응답 코드:" + con.getResponseCode());	
			System.out.println("정상: " + HttpURLConnection.HTTP_OK);	// 200	
			System.out.println("not found " + HttpURLConnection.HTTP_NOT_FOUND);	// 404
			System.out.println("internal error" + HttpURLConnection.HTTP_INTERNAL_ERROR);	// 500
			
			// 3) 컨텐트 타입
			System.out.println("컨텐트 타입: " + con.getContentType());
			// text/html; charset=ISO-8859-1(구글) - 영어
			// text/html; charset=UTF-8(네이버) - 한글
			
			// 4) 요청방식
			System.out.println("요청 방식: " + con.getRequestMethod());
			
			
			// 2) 커넥션끊기 메서드
			con.disconnect(); // close 개념
			
			
		} catch (MalformedURLException e) {		// * URL 클래스 생성시 발생
			System.out.println("API 주소 오류");
		} catch (IOException e) {				// * httpURLconnection 때문, openconnection 메서드도 같은 오류발생(주로 연결관련)
			System.out.println("API 접속 오류");
		}
	}
	
	public static void m3() {
		
		// 3. httpurlconnection과 스트림, 웹 정보를 텍스트로 저장
		// => connection으로 스트림 생성
		try {
			String apiURL = "https://www.naver.com";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			// 1) 바이트 입력 스트림
			InputStream in = con.getInputStream();	// 입력스트림(바이트 스트림)		// * 인터넷에서 스트림을 받는건 byte 타입으로,
																						// => 한글이 제대로 표기되도록 reader로 바꿔주야한다
			// 2) 문자 입력 스트림으로 변환
			InputStreamReader reader = new InputStreamReader(in);
			
			// 모두 읽어서 stringbuilder에 저장
			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[100];
			int readCnt = 0; // 실제로 읽은 글자수
			
			while((readCnt = reader.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCnt);
			}
			
			// 4. stringbuilder의 모든 내용을 c:\\storage\\naver.html로 내보내기
			File file = new File("c:\\storage", "naver.html");
			FileWriter fw = new FileWriter(file);
			
			fw.write(sb.toString());
			
			fw.close();
			reader.close();
			con.disconnect();
			
		} catch (MalformedURLException e) {
			System.out.println("api 주소 오류");
		} catch (IOException e) {
			System.out.println("api 접속 및 연결 오류");
		}
		
		
		
	}
	
	public static void m4() {}
	
	
	public static void main(String[] args) {
		
		m1();
		m2();
		m3();
		m4();
		
	}

}
