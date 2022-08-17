package ex02_api;

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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {
	
	public static void m1() {
		
		// & 정리
		// 1. 요청 => request, 클라이언트가 서버에게 요청
		// 2. 응답 => response, 서버가 클라이언트에게 응답하는것
		
		// [공공데이터 수집을 위한 객체지향 프로그램 구현]
		
		// 1. 요청하기 (api주소와 요청 파라미터 만들기)
		// => client가 server측으로 요청하는 데이터

		// ex) 전국종량제봉투가격표준데이터
	
		// 1) apiurl 만들기
		String apiURL = "http://api.data.go.kr/openapi/tn_pubr_public_weighted_envlp_api";
		
		// 2) 요청을 위한 파라미터 샘플 작성
		try {
			
			// 3) serviceKey서비스키
			// * 인증키는 대체로 decording 원본키를 주기 때문에, 인코딩이 필요
			String serviceKey = "g1fjdlcJOfuhukMnsmo79qYkfOFBB5ocbWKYcImwfNqEb/Hja8k8hffCsEV2/sIPC/eylWm9hcE+F709h2AEAg==";
			
			// * 파라미터 추가방식 : 주소창에 붙여서 붙이는 방식을 get, 아니면 post
			// * 파라미터 추가는 stringbuilder를 통해 효율적으로 코드를 짤 수 있다
			
			apiURL += "?pageNo=" + URLEncoder.encode("0", "UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("100", "UTF-8");
			apiURL += "&type=" + URLEncoder.encode("xml", "UTF-8");
			apiURL += "&CTPRVN_NM=" + URLEncoder.encode("서울특별시", "UTF-8");
			apiURL += "&SIGNGU_NM=" + URLEncoder.encode("금천구", "UTF-8"); 
			apiURL += "&WEIGHTED_ENVLP_TYPE=" + URLEncoder.encode("규격봉투", "UTF-8"); 
			apiURL += "&WEIGHTED_ENVLP_MTHD=" + URLEncoder.encode("소각용", "UTF-8"); 
			apiURL += "&WEIGHTED_ENVLP_PRPOS=" + URLEncoder.encode("생활쓰레기", "UTF-8"); 
			apiURL += "&WEIGHTED_ENVLP_TRGET=" + URLEncoder.encode("기타", "UTF-8"); 

			
			// * 인증키 인코딩
			apiURL += "&serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			
			// * 요청시에 필요한 모든 샘플 데이터는 전부 encording해라(데이터 이름은 제외)
			
			// (영어, 숫자는 인코딩 필요없음, 한글, 특수기호는 필요있음)
			// * 호출할때 요구되는 요쳥변수를 작성해 요청해야한다
			// (필수인지 선택인지 해당 api사이트에서 확인) 
		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
		
		// 2. api 주소 접속
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection(); 
			con.setRequestMethod("GET");
			// * 파라미터 입력방식 표현 메서드
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF8"); 
			// 해석: xml 데이터 타입을 요청
			// * content-type : 리소스의 타입을 나타내는 정해진 키워드
			// html, xml, json인지 적을때 사용
			// ex) text/html, application/xml, application/json
			
		} catch (MalformedURLException e) {
			System.out.println("api 주소 오류");
		} catch (IOException e) {
			System.out.println("접속 실패");		// => openconnection에서 발생
		} 
		
		// 3. 응답(입력스트림)
		// => server가 client한테 응답하는 것을 말한다
		// => 응답 성공시 정상 스트림 사용, 실패했을 때는 에러 스트림을 사용
		// => 응답 데이터는 stringbuilder에 저장(텍스트 기반의 string)
		
		// *요약:ㅣ 서버에서 데이터를 읽어와 stringbuilder
		
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));	// 정상스트림
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));	// 에러스트림
			}	
					// * inputstreamreader은 byte타입의 데이터를 문자타입으로 변환시킨다
					// * stringbuilder을 쓰는 이유: string타입을 직접더하는 것보다 stringbuilder을 이용해 문자를 합하는것이 효율적이기 때문에
			
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");						
			}
			reader.close();
			
		} catch (IOException e) {
			System.out.println("API 응답실패");	// => inputstream
		}
		
		// * 나중에 파일 생성과 xml 분석은 안쓰게됨
		// => 자바만 사용하고있기 때문, 다른 도구로 해결가능
		
		
		// * response는 api로부터 전달받은 xml 데이터
		String response = sb.toString();
		
		// file 생성 및 데이터 저장된 파일 생성
		File file = new File("c:\\storage", "api.xml");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// * xml 태그별로 하나씩 분석해보기
		
		try {
		
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();   // <response> (최상위 태그)
			System.out.println(root.getNodeName());
			
			NodeList nodeList = root.getChildNodes();  // <response>의 자식 태그(<header>, <body>)
			for(int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);          // <header>와 <body>
				System.out.println("  " + node.getNodeName());
				NodeList nodeList2 = node.getChildNodes();        // <header>의 자식 태그(<resultCode>, <resultMsg>), <body>의 자식 태그(<items>, <numOfRows>, <pageNo>, <totalCount>)
				for(int j = 0; j < nodeList2.getLength(); j++) {
					Node node2 = nodeList2.item(j);
					System.out.println("    " + node2.getNodeName());
					if(node2.getNodeName().equals("items")) {     // <items> 태그 대상
						NodeList items = node2.getChildNodes();   // <items>의 자식 태그(<item>)
						for(int k = 0; k < items.getLength(); k++) {
							Node item = items.item(k);
							System.out.println("      " + item.getNodeName());
							NodeList itemChildren = item.getChildNodes();        // <item>의 자식 태그
							for(int l = 0; l < itemChildren.getLength(); l++) {
								Node itemChild = itemChildren.item(l);
								System.out.println("        " + itemChild.getNodeName() + ":" + itemChild.getTextContent());
							}
						}
					}
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
			// * document, emelemnt면 전부 w3c.dom 소속
	
		con.disconnect();
		
	}
	



	public static void main(String[] args) {

		m1();
		
		
		
		
		
		

	}

}
