package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class UrlApi {

	public static void main(String[] args) {
		
		// [1] 데이터  요청
		
		// 1. aplURL 저장
		String apiURL = "http://api.data.go.kr/openapi/tn_pubr_public_weighted_envlp_api";
		
		try {
			
			// 2 ) 인증키 저장
			String serviceKey = "g1fjdlcJOfuhukMnsmo79qYkfOFBB5ocbWKYcImwfNqEb/Hja8k8hffCsEV2/sIPC/eylWm9hcE+F709h2AEAg==";
			// => 인증키는 보통 encording 원본상태
			
			
			// 3) 요청을 위한 파라미터 샘플 작성
			apiURL += "?pageNo=" + URLEncoder.encode("0", "UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("100", "UTF-8");
			apiURL += "&type=" + URLEncoder.encode("xml", "UTF-8");
			apiURL += "&CTPRVN_NM=" + URLEncoder.encode("서울특별시", "UTF-8");
			apiURL += "&SIGNGU_NM=" + URLEncoder.encode("금천구", "UTF-8"); 
			apiURL += "&WEIGHTED_ENVLP_TYPE=" + URLEncoder.encode("규격봉투", "UTF-8"); 
			apiURL += "&WEIGHTED_ENVLP_MTHD=" + URLEncoder.encode("소각용", "UTF-8"); 
			apiURL += "&WEIGHTED_ENVLP_PRPOS=" + URLEncoder.encode("생활쓰레기", "UTF-8"); 
			apiURL += "&WEIGHTED_ENVLP_TRGET=" + URLEncoder.encode("기타", "UTF-8"); 
			
			// 3.1) 인증키 인코딩
			apiURL += "&serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"); 
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩오류");
			
		}
		
		// [2] API 주소 접속
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			// 1. url 연결
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			// * 파라미터 추가방식 = 요청방식
			// => 대표적으로 GET과 POST가 있다
			// => 이중 하나를 설정하는 메서드
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF8");
			// => XML 타입을 요청하는 코드
			
		} catch (MalformedURLException e) {
			System.out.println("api 주소 오류");
		} catch (IOException e) {
			System.out.println("접속 실패");	// * 설명칸을 누르면 어디에서 오류가 발생하는지 확인가능
		}
		
		
		// [3] 응답(입력스트림)
		
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			// * inputstreamreader은 byte타입의 데이터를 string타입으로 변환시킨다
			
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
				// * readline은 줄바꿈을 포함하지 않기 때문에 별도로 추가
			}			
			
			reader.close();
			
		} catch (IOException e) {
			System.out.println("API 응답실패");
		} 
		String response = sb.toString();
		System.out.println(response);
		con.disconnect();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

	}

}
