package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.XML;

public class Public_Api_Method_o {
	
	
	public static void m1() {
		
		// 1. xml 데이터 출력
		
		// 1) api 생성
		
//		String url = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson";
		String serviceKey = "g1fjdlcJOfuhukMnsmo79qYkfOFBB5ocbWKYcImwfNqEb/Hja8k8hffCsEV2/sIPC/eylWm9hcE+F709h2AEAg==";
		StringBuilder urlBuilder = new StringBuilder();
		
		try {
			urlBuilder.append("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&numOfRows=10");
			urlBuilder.append("&pageNo=1");
			urlBuilder.append("startCreateDt=20220816");
			urlBuilder.append("&endCreateDt=20220819");
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩오류");
		}
		
		String apiURL = urlBuilder.toString();
		
		// ------------------------------------------
		
		
		// 2) api 연결

	
		HttpURLConnection con = null;
		try {
			con = (HttpURLConnection)new URL(apiURL).openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8"); // *
			
		} catch (MalformedURLException e) {
			System.out.println("api 주소오류");	// * url클래스
		
		} catch (IOException e) {
			System.out.println("연결오류");		// * httpurlconnection 관련
		}
		
		// ------------------------------------------
		
		// 3) 입력스트림
		
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
			
		
		// 4) 출력
		
		String sep = File.separator;	// * 구분자 대체
		File file = new File("c:" + sep + "charlie1" + sep + "ch1.xml");
		
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);	// 배열의 객체를 통째로 넣는 data 스트림과 구분, response는 string타입
			bw.close();
			con.disconnect();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void m2() {
		
		// 2. json 데이터 출력
		
		// 1. api 생성
		
		String serviceKey = "g1fjdlcJOfuhukMnsmo79qYkfOFBB5ocbWKYcImwfNqEb/Hja8k8hffCsEV2/sIPC/eylWm9hcE+F709h2AEAg==";
		StringBuilder urlBuilder = new StringBuilder();
		
		try {
			
			urlBuilder.append("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&numOfRows=10");
			urlBuilder.append("&pageNo=1");
			urlBuilder.append("&dataType=JSON");
			urlBuilder.append("&base_date=20220820");	// 최근 1일간의 데이터만 가능
			urlBuilder.append("&base_time=2000");
			urlBuilder.append("&nx=55");
			urlBuilder.append("&ny=127");
		
		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩오류");
		}
		
		
		String apiURL = urlBuilder.toString();
//		System.out.println(apiURL);			* api 확인용
		
		// 2. api 연결
		
		HttpURLConnection con = null;
		
		try {
			
			con = (HttpURLConnection)new URL(apiURL).openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
		} catch (MalformedURLException e) {
			System.out.println("api 주소 오류");
		} catch (IOException e) {
			System.out.println("api 연결오류");
		}
		
		// 3. 입력스트림
		
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();				// * 입력스트림에는 꼭 stringbuilder 쓰기
		try {
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line = reader.readLine()) != null) { 
				sb.append(line);
			}
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();							// * 오류 문제점 발견을 위해 경로별로 찾아내는 빨간경고
		}
		
		String response = sb.toString();
		
		// 4. 출력스트림
		
		File file = new File("c:\\charlie1", "ch2.json");
		
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		con.disconnect();				// * con 종료는 제일 마지막에
	}
	
	
	public static void m3() {
		
		// 3. api scanner, 메서드응용(영화 흥행 데이터, xml)
		// * 출력에서 flush는 생략 가능하지만 출력오류의 원인일 수 있음을 주의
		
		// 질문
		// 1) 스트림들 close는 쓰지 않아도 되는지? 	=> 메서드가 종료되면 알아서 꺼질려나?
		// 2) get요청과 conenttype메서드는 사용안했는데 이유는?

		
		String key = "f0ff9ed325466d9b5e6bcb33348e7096";
		Scanner sc = new Scanner(System.in);
		System.out.println("날짜(yyyymmdd) >>> ");
		String targetDt = sc.next();
		
		try {
			
			key = URLEncoder.encode(key, "UTF-8");
			targetDt = URLEncoder.encode(targetDt, "UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("인코딩실패", e);
		}
		
		String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=" + key + "&targetDt=" + targetDt;
		
		String response = getResponse(apiURL);
		
		createFile(response);
		
	}
	
	public static String getResponse(String apiURL) {
		
		HttpURLConnection con = getConnection(apiURL);
		
		try {
			
//			con.setRequestMethod("GET");
//			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				return readBody(con.getInputStream());
			} else {
				return readBody(con.getErrorStream());
			} 
			
		} catch (IOException e) {
			throw new RuntimeException("api 요청 오류", e);	// * getresponse코드
		}
		
		
	}
	
	public static HttpURLConnection getConnection(String apiURL) {
		
		try {
			URL url = new URL(apiURL);
			return (HttpURLConnection)url.openConnection();
			
		} catch (MalformedURLException e) {
			throw new RuntimeException("api 주소 오류", e);		// * url 오류
		} catch (IOException e) {
			throw new RuntimeException("api 연결오류", e);		// * openconnection  
		}		
	}
	
	public static String readBody(InputStream in) {
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))){
			
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			return sb.toString();
			
		} catch (IOException e) {
			throw new RuntimeException("api 응답 오류", e);
		}
		
		
	}
	
	public static void createFile (String response) {
		
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\charlie1\\ch3.xml"));
			// * stream은 데이터 저장을 위해 빨때를 꼳는 것, 즉 직접 경로를 작성해도된다
			// * 입력스트림에서 stream메서드를 쓰는건 꼳는 데이터가 공공 사이트같은 외부에 있기 때문
			bw.write(response);
			bw.flush();			// * 생성오류이 이유
			
		} catch (IOException e) {
			throw new RuntimeException("파일생성오류");
		}
		
	}
	
	public static void main(String[] args) {
		
		//m1(); 
		//m2();
		m3();
	
		
		
	}
	

}
