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
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class Z {
	
public static void m5() {
		
		// 소상공인시장진흥공단_상가(상권)정보
		
		// 인증키(Decoding)
		String serviceKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ==";

		// API 주소	(주소 + 요청 파라미터)
		StringBuilder urlBuilder = new StringBuilder();
		try {
			urlBuilder.append("http://apis.data.go.kr/B553077/api/open/sdsc2/storeZoneOne");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&resId=").append(URLEncoder.encode("store", "UTF-8"));
			urlBuilder.append("&key=9994");
			urlBuilder.append("&type=json");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String apiURL = urlBuilder.toString();
		
		// API 주소 접속
		URL url = null;
		HttpURLConnection con = null;
		
		try {			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("API 접속 실패");
		}
		
		// 입력 스트림 생성
		// 1. 서버가 보낸 데이터를 읽어야 하므로 입력 스트림이 필요
		// 2. 서버와 연결된 입력 스트림은 바이트 스트림이므로 문자 스트림으로 변환해야 함
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
				sb.append(line);
			}
			
			// 스트림 종료
//			reader.close();
			
		} catch(IOException e) {
			System.out.println("API 응답 실패");
		}
		
		// API로부터 전달받은 json 데이터
		String response = sb.toString();
		
		// JSON File 생성
		File file = new File("C:\\charlie1", "ch4.json");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
//		return response;
		
	}
//	
//	public static void m6() {
//		 try {
//		JSONObject obj = new JSONObject(m5());
//		JSONObject header = obj.getJSONObject("header");
//		JSONArray columns = header.getJSONArray("columns");
//		
//		JSONObject body = obj.getJSONObject("body");
//		JSONArray items = body.getJSONArray("items");
//		JSONObject item = items.getJSONObject(0);
//		
//		String[] p = {"trarNo", "mainTrarNm", "ctprvnCd", "ctprvnNm", "signguCd", "signguNm", "trarArea", "coordNum", "coords", "stdrDt"};
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		for(int i = 0; i < columns.length(); i++) {
//			map.put(columns.getString(i), item.get(p[i]));
//		}
//		
//		System.out.println(map);
//		
//	} catch (Exception e) {
//		// TODO: handle exception
//	}
//	}

	public static void main(String[] args) {
		
		m5();
		//m6();
		
	
	}
}
