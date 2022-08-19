package network;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Url_o {
	
	public static void m1() {
		
		// 1. url 저장 및 연결
		String apiURL = "https://www.naver.com";
		
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			// * url과 httpurlconnection의 소속
			// object - url
			// object - urlconnection - httpurlconnection
			// => 소속이 완전히 달라고 캐스팅이 가능한듯
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
			// * con은 httpurlconnection의 객체다
				System.out.println("api 접속 실패");
				return;
			}
			InputStreamReader reader = new InputStreamReader(con.getInputStream());
			// * 연결된 con을 통해 입력스트림을 받아야한다
			StringBuilder sb = new StringBuilder();
			
			int readCnt = 0;			// * 읽은 문자의 개수! (유니코드x)
			char[] cbuf = new char[100];
			while((readCnt= reader.read(cbuf)) != -1) { 
				sb.append(cbuf, 0, readCnt);
			}
			// * 문자를 100개단위로, 남은 글자도 남은 글자수만큼 stringbuilder로 더해 저장
			
			reader.close();
			con.disconnect();
			
		} catch (MalformedURLException e) {
			System.out.println("url 주소 오류");
				
		} catch (IOException e) {
			System.out.println("api 접속 및 연결 오류");
		}
	}
	
	public static void m2() {
		
		// 2. 인코딩, 디코딩
		// => 인코딩(utf-8방식으로 암호화)
		// => 디코딩(원본데이터)
		
		// 1. 원본데이터
		
		String str = "한글 english 12345 !@*^+)";
		
		try {
			
			// 1) 인코딩	: 한글, 특수기호를 컴퓨터가 읽을 수 있도록 컴퓨터의 언어로 변화 
			String encode1 = URLEncoder.encode(str, "UTF-8");
			// => %ED%95%9C%EA%B8%80+english+12345+%21%40*%5E%2B%29
			
			String decode1 = URLDecoder.decode(str, "UTF-8");
			// => 
			// * utf-8방식으로 인코딩 : 한글을 3바이트로 변환하기 때문에, 한글변환에 유용
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩 오류");
			// * UnsupportedEncodingException이 인코딩과 디코딩 오류를 전부 처리한다
		}
	}
	

	public static void main(String[] args) {
		
		m1();
		m2();
	}

}


