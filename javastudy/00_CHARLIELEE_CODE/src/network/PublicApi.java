package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;

public class PublicApi {
	
	// 요청과 응답
	// => 클라이언트가 서버에 요구하는 것이 요청, 서버가 클라이언트에게 반응하는 것을 응답
	
	public static void m1() {
		
		// * xml이면 직접 api를 작성해야하며, json은 사이트를 통해 자동으로 만들 수 있다
		// * json -> postman
		
		// ex) 보건복지부 코로나 현황(공공데이터)
		
		// 1. 필요한 데이터에 맞는 api 작성 
		// * encoding이 필요한건 파라미터가 한글, 문자를 가질 경우(컴퓨터는 한글, 문자를 인식x)
		
		String serviceKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ==";
		StringBuilder urlBuilder = new StringBuilder();
		
		try {
			
			urlBuilder.append("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&startCreateDt=20220808");
			urlBuilder.append("&endCreateDt=20220812");
			
			// * 필수입력파라미터가 적다면 url 주소에 직접 입력하는 것도 방법이다
			
			// * 빌더패턴 용도
			// JSONArray dataList = obj.getJSONObject("rss")
//			.getJSONObject("channel")
//			.getJSONObject("item")
//			.getJSONObject("description")
//			.getJSONObject("body")
//			.getJSONArray("data");
			// => 동일한 객체를 연속으로 사용해야 하는 경우가 발생할 때 사용된다
			// ex) obj의 반복을 최소화할 수 있다
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String apiURL = urlBuilder.toString();
		
		// 2. url 연결	
		
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			// * 요청사항 설정 (GET, 또는 POST)
			// => POST는 제이슨 타입에서 특정 정보를 BODY에 입력해야 한다, 보안용
			con.setRequestProperty("Content-type", "application/xml; charset=UTF-8");
			// * 요청할 문서타입 (xml, json)
			
		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");	// * new url에서 오류
		} catch (IOException e) {			
			System.out.println("접속실패");			// * url, openconnection에서 오류
		}
		
		// 3. 입력스트림
		
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}	
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String response = sb.toString();
		
		// 4. 파일생성 후 출력
		File file = new File("c:\\charlie1", "ch1");
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			
			bw.close();
			con.disconnect();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// * 이후 xml 또는 json에 따라 파일을 분석한다	
	}
	
	public static void m2() {
			
	}
	
	public static void m3() {
		
	}
	
	public static void m4() {
		
	}
	
	public static void m5() {
		
	}
	
	public static void m6() {
		
	}
	
	public static void m7() {
		
	}
	
	public static void m8() {
		
	}
	
	public static void main(String[] args) {
		
		m1();
		m2();
		m3();
		m4();
		m5();
		m6();
		m7();
		m8();
		
	}

}
