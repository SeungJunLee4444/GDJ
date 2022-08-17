package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class PulbicApi_o {

	public static void main(String[] args) {
		
		// [공공 API]

		// 1. 데이터 요청
		// 1) api 저장 
		String apiURL = "http://api.data.go.kr/openapi/tn_pubr_public_weighted_envlp_api";
		
		try {
			
			// 2) 인증키 저장
			String serviceKey = "g1fjdlcJOfuhukMnsmo79qYkfOFBB5ocbWKYcImwfNqEb/Hja8k8hffCsEV2/sIPC/eylWm9hcE+F709h2AEAg==";
			// * 디코딩된 상태로 저장
			
			// 3) 요청을 위한 파라미터 샘플 작성
			apiURL += "?pageNo=" + URLEncoder.encode("0", "UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("100", "UTF-8");
			apiURL += "&type=" + URLEncoder.encode("xml", "UTF-8");
			apiURL += "&CTPRVN_NM=" + URLEncoder.encode("인천광역시", "UTF-8");
			apiURL += "&SIGNGU_NM=" + URLEncoder.encode("계양구", "UTF-8"); 
			apiURL += "&WEIGHTED_ENVLP_TYPE=" + URLEncoder.encode("규격봉투", "UTF-8"); 
			apiURL += "&WEIGHTED_ENVLP_MTHD=" + URLEncoder.encode("소각용", "UTF-8"); 
			apiURL += "&WEIGHTED_ENVLP_PRPOS=" + URLEncoder.encode("생활쓰레기", "UTF-8"); 
			apiURL += "&WEIGHTED_ENVLP_TRGET=" + URLEncoder.encode("기타", "UTF-8");
			
			// 4) 인증키 인코딩
			apiURL += "&serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩오류");
		}
		
		// 2. api 주소 연결
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
//			if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
//				System.out.println("접속 오류");
//				return;
//			}
			con.setRequestMethod("GET");
			// => url 요청을 위한 메서드(get, post 등)
			// (기본값은 get)
		
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF8");
			// => key, value 쌍의 일반요청 속성 설정
			// => 어떤 데이터 타입을 요청하는지 작성하는데 사용
			
		} catch (MalformedURLException e) {
			System.out.println("api 주소 오류");
		} catch (IOException e) {
			System.out.println("접속 실패");
		}

		// 3. 입력받기(입력스트림)
		
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
			
			String response = sb.toString();
			System.out.println(response);
			con.disconnect();
			
		} catch (IOException e) {
			System.out.println("API 응답실패");
		} 
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

	}

}
