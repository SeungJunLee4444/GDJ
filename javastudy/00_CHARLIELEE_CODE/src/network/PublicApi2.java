package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PublicApi2 {

	// 2. 보건복지부 코로나 현황

	public static void m1() {

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
			// TODO: handle exception
		}

	}

	public static void m2() {

	}

	public static void main(String[] args) {

		m1();
		m2();

	}

}
