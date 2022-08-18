package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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




public class Main {
	
	public static void main(String[] args) {
		
		String key = "f0ff9ed325466d9b5e6bcb33348e7096";
		StringBuilder urlBuilder = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("날짜(yyyymmdd) >>> ");
		String targetDt = sc.next();				// * key, targetDt가 요청필수
		
		// => 파라미터가 얼마없으면 직접 추가도 가능
		// * 파라미터에 공백은 있어서는 안된다 * (공백도 문자로 인식하기 때문)
		try {
			
			key = URLEncoder.encode(key, "UTF-8"); // UTF-8 안해도됨
			targetDt = URLEncoder.encode(targetDt, "UTF-8");
			
			
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("인코딩실패", e);	// main이 throw하는것은 jvm이 처리한다는 뜻
		}													// => (e) : (인코딩 실패의 이유는 e객체라는 의미)
		
		String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=" + key + "&targetDt=" + targetDt;
		
		String response = getResponse(apiURL);
		System.out.println(response);
		
		createFile(response);
	
	}
	
	public static String getResponse(String apiURL) {
		// * static 메서드를 사용하는 클래스는 stati
		
		HttpURLConnection con = getConnection(apiURL);
		try {
		if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
			return readBody(con.getInputStream());
		} else {
			return readBody(con.getErrorStream());
		}
		} catch (IOException e) {
			throw new RuntimeException("API 요청 오류", e);
			// TODO: handle exception
		}
		// * inputstream, errorstream 둘다 inputstream으로 저장할 수 있다
		// * 메서드가 string타입이니 readBody는 string으로 구현되야한다?
	}
	
	public static HttpURLConnection getConnection(String apiURL) {
		
		try {
		URL url = new URL(apiURL);
		return (HttpURLConnection)url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API 주소 오류", e);
		} catch (IOException e) {
			throw new RuntimeException("API 연결 오류");
		}
	}
	
	public static String readBody(InputStream in) {
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			return sb.toString();
			
		} catch (IOException e) {
			throw new RuntimeException("API 응답 오류", e);
		}
	}
	
	public static void createFile(String response) {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\storage\\boxoffice.xml"))) {
			// * file 없이 경로(스트림)를 적어도된다
			bw.write(response);
//			bw.flush();			// * 혹시 스트림에 남아있는 자료 밀어버리기(해도 그만, 안해도그만, 안전하게 코드를 짜고싶을때)
			
		} catch (IOException e) {
			throw new RuntimeException("파일생성 오류");
		}
		
	}
	
	
	

	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


