package network;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class UrlData {
	
	public static void m1() {
		
		// 1. 
		
		try {
			
			// 1) url저장
			
			String apiURL = "https://www.naver.com";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.out.println("api 접속 실패");
				return;
			}
			InputStreamReader reader = new InputStreamReader(con.getInputStream());
			// => byte타입을 reader을 통해 문자열로 읽는다
			
			// * urlconnection은 getinpustream, outputstream을 메서드로 가지고 있다
			// => httpurlconnection도 쓸 수 있다
			
			StringBuilder sb = new StringBuilder();
			// => 효율적으로 문자열을 합치기 위해 stringbuilder을 쓴다
			
			int readCnt = 0;		// => 그저 읽은 글자수만큼의 카운트, 유니코드x
			char[] cbuf = new char[100];	// 100글자 단위로
			
			while((readCnt = reader.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCnt);
			}
			reader.close();
			con.disconnect();
			
			// * inputstream 		: 한글을 제외한 문자를 읽음(1byte)
			// * inputstreamreader 	: 한글을 읽을 수 있음(2byte)
			// * bufferedreader 	: 문자열 처리가능
			
		} catch (MalformedURLException e) {		// url 선언
			System.out.println("api 주소오류");
		} catch (IOException e) {
			System.out.println("api 접속 및 연결 오류");
			
		}

	}
	
	public static void m2() {
		
		// 2. 인코딩, 디코딩
		// => 인코딩(utf-8방식으로 암호화)
		// => 디코딩(원본데이터)
		
		// 1. 원본데이터
		try {
			String str1 = "한글 english 12345 !@*^+)";
		
		// 2. 인코딩(암호화)
			String encode = URLEncoder.encode(str1, "UTF-8");
			System.out.println(encode);
			// => %ED%95%9C%EA%B8%80+english+12345+%21%40*%5E%2B%29
			
		// 3. 디코딩(원본화)
			String decode = URLDecoder.decode(str1, StandardCharsets.UTF_8);
			System.out.println(decode);
		
		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩오류");
		}
		
		// & 인코딩은 원본데이터를 암호화, 디코딩은 원본화 하는 것이다
		// * 컴퓨터는 한글, 특수기호를 읽지 못하기 떄문에, 컴퓨터가이해할수 있는 언어로
		// 바꿔주는 것을 인코딩이라 한다
	}
	

	public static void main(String[] args) {
		
		m1();
		m2();
	}

}


