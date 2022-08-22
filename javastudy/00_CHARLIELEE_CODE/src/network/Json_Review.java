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
import org.json.XML;

public class Json_Review {
	
	public static void m1() {
		
		// 1. 
		// * {프로퍼티 : 값}
		// * 객체는 {} : jsonobject ex body : {
		// * 배열은 [] : jsonarray  ex item : [{
		// * 각 json객체와 배열의 인스턴스는 "" 지정한 태그를 제외한 자식태그의 모든 데이터를 출력한다 *
		// * json은 map처럼 메서드("key")값을 입력하면 데이터가 출력되는 방식이다?
		
		
		// 입력스트림에서 string에 저장 후 사용하면된다(메서드를 호출하는것도 방법) *
		// 2) 객체는 jsonobject, getjsonobject메서드 호출,
		// 3) 마지막 자식태그 element들은 getstring 메서드로 호출 후 string타입에 저장
		
		// 1) jsonobject 인스턴스 생성 후, 입력받은 데이터 저장
		JSONObject obj = new JSONObject(m2());	
		// => jsonobject는 string타입의 값을 매개변수로 받기 때문에, 
		System.out.println(obj);		// * response부터 데이터 전체
	
		JSONObject response = obj.getJSONObject("response");	// response 안의 모든 태그들
		System.out.println(response);
		
		JSONObject obj2 = obj.getJSONObject("response");	// response 안의 데이터
		JSONObject obj3 = obj2.getJSONObject("header");	// header 안의 프로퍼티 + 값
		String resultCode = obj3.getString("resultCode");	
		System.out.println(obj3);
		
		
		JSONObject body = response.getJSONObject("body");		// body 안의 모든 태그들
		JSONObject items = body.getJSONObject("items");
		JSONArray item = items.getJSONArray("item");			// []니 배열타입에 저장, 
		for(int i = 0; i < item.length(); i++) {
			JSONObject element = item.getJSONObject(i);	// item 안의 모든 값을 element라 명칭해 저장
			System.out.println(element.getString("category") + ":" + element.getString("obsrValue"));
		}
	}
	
	
	public static String m2() {
		
		String serviceKey = "g1fjdlcJOfuhukMnsmo79qYkfOFBB5ocbWKYcImwfNqEb/Hja8k8hffCsEV2/sIPC/eylWm9hcE+F709h2AEAg==";
		StringBuilder urlBuilder = new StringBuilder();

		try {

			urlBuilder.append("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&numOfRows=10");
			urlBuilder.append("&pageNo=1");
			urlBuilder.append("&dataType=JSON");
			urlBuilder.append("&base_date=20220821");	// 최근 1일간의 데이터만 가능
			urlBuilder.append("&base_time=1500");
			urlBuilder.append("&nx=55");
			urlBuilder.append("&ny=127");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String apiUrl = urlBuilder.toString();
		URL url = null;
		HttpURLConnection con = null;

		try {
			url = new URL(apiUrl);
			con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 3. 입력

		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();

		try {
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}

			reader.close();
			con.disconnect();

		} catch (IOException e) {
			e.printStackTrace();
		}

		String response = sb.toString();
		
		return response;
		
	} 
	
	public static void m3() {
		
	}
	
//	public static String m4() {
		
		
	//}
	

		
//		// 3. hashmap에 json 데이터 저장하기------------------------------?
//		
//		String Json = "[{\"Product\" : \"Mouse\", \"Maker\":\"Samsung\", \"Price\":23000},"  
//			+ "{\"Product\" : \"KeyBoard\", \"Maker\":\"LG\", \"Price\":12000},"            
//		    + "{\"Product\":\"HDD\", \"Maker\":\"Western Digital\", \"Price\":156000}]";
//		
//		JSONObject obj = new JSONObject(m6());
//		JSONObject header = obj.getJSONObject("header");		// * header 의모든 데이터
//		JSONArray columns = header.getJSONArray("columns");		// * colummns의 배열데이터
//		for(int i = 0; i < columns.length(); i++) {
////			System.out.println(columns.getString(i));
//		}
		// => 배열이니 0부터 배열의 길이까지 
//		
//		JSONObject body = obj.getJSONObject("body");
//		JSONArray items = body.getJSONArray("items");	// * items 배열의 값
//		JSONObject item = items.getJSONObject(0);	// items 배열의 값 {}은 하나뿐이기 때문에 0 **
////		System.out.println(item.toString());
//		System.out.println(item);
//		
//		// * key값은 string으로, value값은 object(문자열, 숫자 등 모든값이 저장될 수 있도록)
//		
//		Map<String, Object> map = new HashMap<>();
//		map.put("상권번호", item.getInt("trarNo"));
//		map.put("상권명", item.getString("mainTrarNm"));
//		// * column에 있는 각 key값의 한글문자열과 key값의 value값을 저장 **
//		
//		String[] p = {"trarNo", "mainTrarNm", "ctprvnCd", "ctprvnNm", "signguCd", "signguNm", "trarArea", "coordNum", "coords", "stdrDt"};
//		// k
//		
//		for(int i = 0; i < columns.length(); i++) {
//		map.put(columns.getString(i), item.get(p[i]));	// * 순서대로 나오지는 않는다
//		// * column의 한글문자열값과, item 
//		
//		// * 아마 컬럼에는 데이터타입의 실제 한글명이 배열에 저장되어있을 것이고(column)
//		// * items
//	
//			
//		}
//		
//		System.out.println(map);
//	}
		
	
		public static String m6 () {
			
			String serviceKey = "g1fjdlcJOfuhukMnsmo79qYkfOFBB5ocbWKYcImwfNqEb/Hja8k8hffCsEV2/sIPC/eylWm9hcE+F709h2AEAg==";
			StringBuilder urlBuilder = new StringBuilder();

			try {

				urlBuilder.append("http://apis.data.go.kr/B553077/api/open/sdsc2/storeZoneOne");
				urlBuilder.append("?servicekey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
				urlBuilder.append("&key=9734");	// * 지역번호
				urlBuilder.append("&type=json");
			
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			String apiUrl = urlBuilder.toString();
			URL url = null;
			HttpURLConnection con = null;

			try {
				url = new URL(apiUrl);
				con = (HttpURLConnection) url.openConnection();

				con.setRequestMethod("GET");
				con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// 3. 입력

			BufferedReader reader = null;
			StringBuilder sb = new StringBuilder();

			try {
				if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
					reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				} else {
					reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}

				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}

				reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			String response = sb.toString();

			// 4. 파일에 저장

			File file = new File("c:\\charlie1", "ch6.json");
			BufferedWriter bf = null;

			try {

				bf = new BufferedWriter(new FileWriter(file));
				bf.write(response);
				bf.close();

				con.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// * string 타입의 반환값을 가진다는 의미
			
		
			
			return response;
			
		}
	
	
	
	public static void m7() {
		
		// 4. xml파일을 json파일로 바꾸기
		// * jsonobject 생성자 매개변수로 파일경로는 불가능
		// * xml과 달리 json은 파일을 직접 받지 못함
		// => string타입에 저장된 데이터값을 보내줘야한다 *
	
		JSONObject obj = XML.toJSONObject(m8());
		// * xml.문서를 json문서로 바꾸는 메서드
		
		System.out.println(obj.toString());
		
		// * 기상청 문서는 처음부터 xml문서만 받을수있었다
		
		JSONArray dataList = obj.getJSONObject("rss")
				.getJSONObject("channel")
				.getJSONObject("item")
				.getJSONObject("description")
				.getJSONObject("body")
				.getJSONArray("data");
		// * 롬복 builder타입을 통해 배열태그인 data까지 접근하는 코드 ***
		
		for(int i = 0; i < dataList.length(); i++) {
			JSONObject weather = dataList.getJSONObject(i);// * 출력문을 깔끔하게 작성하기 위해
			System.out.println(weather.getInt("hour") + "시," + weather.getInt("temp") + "도," + weather.getString("wfKor"));
		// * key 값을 입력하고 value를 얻는다, 이때 value의 타입별로 메서드를 호출한다
	}
	}
	
	public static String m8() {

		// ex) 기상청 rss 자료 내려받기

		// 1. apiurl 저장

		String apiUrl = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=5013061000";

		// 2. url 연결

		URL url = null;
		HttpURLConnection con = null;

		try {

			url = new URL(apiUrl);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 3. 내려받기

		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();

		try {

			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String Line = null;
			while ((Line = reader.readLine()) != null) {
				sb.append(Line + "\n");
			}

			reader.close();
			con.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

		String response = sb.toString();

		// 4. 파일에 출력

		File file = new File("c:\\charlie1", "ch5.json");

		BufferedWriter bw = null;

		try {

			bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);

			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	
	public static void main(String[] args) {
		
		m6();
		//m3();
		//m7();
		
	}

}
