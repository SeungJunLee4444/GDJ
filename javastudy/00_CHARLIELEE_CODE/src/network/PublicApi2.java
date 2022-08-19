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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PublicApi2 {
	
	public static void m1() {
		
		// [공공 API]

				// 1. 데이터 요청
				// 1) api 저장 
				String apiURL = "http://api.data.go.kr/openapi/tn_pubr_public_weighted_envlp_api";
				
				try {
					
					// 2) 인증키 저장
					String serviceKey = "g1fjdlcJOfuhukMnsmo79qYkfOFBB5ocbWKYcImwfNqEb/Hja8k8hffCsEV2/sIPC/eylWm9hcE+F709h2AEAg==";
					// * 디코딩된 상태로 저장
					
					// 3) 요청을 위한 파라미터 샘플 작성
					// * request(요청메시지)  : 클라이언트가 서버로 보내줄 데이터, 파라미터)
					// * response(응답메시지) : 서버가 클라이언트한테 보내주는 메시지
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
//					if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
//						System.out.println("접속 오류");
//						return;
//					}
					con.setRequestMethod("GET");
					// => url 요청을 위한 메서드(get, post 등)
					// (기본값은 get) => get방식이면 생략가능
					// * 보안이 필요한 방식은 post, 아니면 get방식
				
					con.setRequestProperty("Content-Type", "application/xml; charset=UTF8");
					// => key, value 쌍의 일반요청 속성 설정
					// => 어떤 데이터 타입을 요청하는지 작성하는데 사용
					// => utf8은 생략가능
					
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
					
					con.disconnect();
					
				} catch (IOException e) {
					System.out.println("API 응답실패");
				} 
				
				String response = sb.toString();

				
				// 4. 파일 생성
				
				File dir = new File("c:\\charlie1");
				if(dir.exists() == false) {
					dir.mkdir();
				}
				File file = new File("c:\\charlie1", "ch1.xml");
				
				
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(file));
					bw.write(response);
					bw.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// 5. xml 문서구조 분석
				
				// => 노가다로 xml 분석 뜯어보기
				// * getnodename 메서드를 이용
				
				try {
				
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = factory.newDocumentBuilder();
					Document doc = builder.parse(file);
					
					Element root = doc.getDocumentElement();	// <response>
					System.out.println(root);  
					
					NodeList nodeList = root.getChildNodes();	// <head>, <body>
					for(int i = 0; i < nodeList.getLength(); i++) {
						Node node = nodeList.item(i);
						System.out.println(node.getNodeName());
						NodeList nodeList2 = node.getChildNodes(); // 각각 head의 자식, 바디의 자식들
						for(int j = 0; j < nodeList2.getLength(); j++) {
							Node node2 = nodeList2.item(j);			// head의 자식, 바디의 자식들 결과
							System.out.println(node2.getNodeName());
							if(node2.getNodeName().equals("items")) {
								NodeList items = node2.getChildNodes();	// items 태그의 자식태그들
								for(int k = 0; k < items.getLength(); k++) {
									Node item = items.item(k);
									System.out.println(item.getNodeName());
									NodeList itemChildren = item.getChildNodes();
									for(int l = 0; l < itemChildren.getLength(); l++) {
										Node itemChild = itemChildren.item(l);
										System.out.println(itemChild.getNodeName());
									}
								}
								
							}
						}
					}
					
				} catch (Exception e) {
				}
				con.disconnect();
		
	}
	
	

	// 2. 보건복지부 코로나 현황

	public static void m2() {

		String serviceKey = "g1fjdlcJOfuhukMnsmo79qYkfOFBB5ocbWKYcImwfNqEb/Hja8k8hffCsEV2/sIPC/eylWm9hcE+F709h2AEAg==";
		StringBuilder urlBuilder = new StringBuilder();
		StringBuilder sb = new StringBuilder();

		try {

			urlBuilder.append("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson");
			// * 서비스 url 주소를 꼭 사용할 것
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&startCreateDt=20220808");
			urlBuilder.append("&endCreateDt=20220812");
			// * 영문과 숫자는 인코딩이 필요없다
			// * 샘플값을 입력하여 원하는 데이터를 한정하여 요청할 수 있다

			String apiUrl = urlBuilder.toString();

			// 2. api 주소 연결

			URL url = new URL(apiUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml");
			// * get이 아니라 set이다

			// 3. 입력스트림

			BufferedReader reader = null;

			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}

			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
			con.disconnect();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String response = sb.toString();

		// 4. 출력

		File file = new File("c:\\charlie1", "ch2.xml");

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();

			// 5. xml 분석

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			StringBuilder sb2 = new StringBuilder();

			Element root = doc.getDocumentElement(); // 최상위 태그 생성

			// * node와 tag는 다르다

			NodeList items = root.getElementsByTagName("item");
			// * items는 item 태그들을 지니고 있다?
			// * node는 기본적으로 하나만 있어야한다

			for (int i = 0; i < items.getLength(); i++) {
				Node item = items.item(i);
				NodeList itemChildren = item.getChildNodes();
				// * item(한개) 이라는 노드의 자식태그들

				Node stateDt = itemChildren.item(4);
				// * item 노드의 5번째 자식태그가 stateDt

				for (int j = 0; j < itemChildren.getLength(); j++) {
					Node itemChild = itemChildren.item(j);

					// * 왜 인덱스가 아니라 equals를 쓰는지?--------------------?
					// => 엔터, 띄어쓰기를 하면 자식태그로 인식못한다는건?

					if (itemChild.getNodeName().equals("stateDt")) {
						sb2.append(" 날짜 : ").append(itemChild.getTextContent());
						// * gettextcontent는 태그의 내용을 호출한다
					} else if (itemChild.getNodeName().equals("decideCnt")) {
						sb2.append(" 확진자수 : ").append(itemChild.getTextContent());
					} else if (itemChild.getNodeName().equals("deathCnt")) {
						sb2.append(" 사망자수 : ").append(itemChild.getTextContent());
					}
				}
				
				sb2.append("\n");
				// * 여기 있어도 되는 이유 => 중첩 for문 ***
				System.out.println(sb2.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void m3() {
		
		// 3. 기상청 단기예보 api
		// * node와 element의 차이
		// => node는 문서의 태그, 텍스트, 주석을 전부 포함한다
		// => element는 오직 태그만을 가리킨다
		// => element를 통해 원하는 태그에 정확히 접근할 수 있다
		// * node는 명확히 태그를 의미하지 않으면 태그 접근 메서드를 호출할수없음
		
		String serviceKey = "g1fjdlcJOfuhukMnsmo79qYkfOFBB5ocbWKYcImwfNqEb/Hja8k8hffCsEV2/sIPC/eylWm9hcE+F709h2AEAg==\r\n";
		StringBuilder urlBuilder = new StringBuilder();
		
		try {
			
			urlBuilder.append("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst");
			urlBuilder.append("?ServiceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&pageNo=1");
			urlBuilder.append("&numOfRows=1000");
			urlBuilder.append("&base_date=20210628");
			urlBuilder.append("&base_time=0600");
			urlBuilder.append("&nx=55");
			urlBuilder.append("&ny=127");
			
			String apiURL = urlBuilder.toString();
			
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml");
			
			BufferedReader reader = null;
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));	
			}
			
			StringBuilder sb = new StringBuilder();
			
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			reader.close();
			con.disconnect();
			
			String response = sb.toString();
			
			File file = new File("c:\\charlie1", "ch3.xml");
			BufferedWriter bf = new BufferedWriter(new FileWriter(file));
			bf.write(response);
			bf.close();
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File file = new File("c:\\charlie1", "ch3.xml");
		
		try {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(file);
		
		Element root = doc.getDocumentElement();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	
	}

	public static void main(String[] args) {

		//m1();
		//m2();
		m3();

	}

}
