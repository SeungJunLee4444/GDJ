package network;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Xml_Review {
	
	public static void m1() {
		
		// 1. 연속for문
		
		// * 정리
		// node를 통해 getnodename으로 태그명호출
		// getelementbytagname은 태그명을 직접 호출 가능하며 root태그가 element타입일때 가능
		// 같은 위치에 태그가 하나뿐이면 node, 여러개면 nodelist + for문
		
		try {
		
		File file = new File("c:\\charlie1", "ch1.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(file);
		
		Element root = doc.getDocumentElement();
		System.out.println(root.getNodeName());					// response
		// * getnodename은 태그의 이름 호출
		// * getelementbytagname은 태그의 이름을 입력해 호출
		// => elementname은 객체가 node일떄 호출 불가능 *
		
		NodeList nodeList = root.getChildNodes();
		for(int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			System.out.println("  " + nodeList.item(i).getNodeName());	// header, body
			NodeList nodeList2 = node.getChildNodes();
			for(int j = 0; j < nodeList2.getLength(); j++) {
				Node node2 = nodeList2.item(j);
				System.out.println("    " + node2.getNodeName());	// resultcode, resultmsg, items.....
				if(node2.getNodeName().equals("items")) {
					NodeList items = node2.getChildNodes();	
					for(int k = 0; k < items.getLength(); k++) {
						Node item = items.item(k);
						System.out.println("      " + item.getNodeName());	//item
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
			e.printStackTrace();
		}
		
	}
	
	public static void m2() {
		
		// 2. getemelemtbytagname으로 직접 태그 호출후 값도 출력하기
		// * gettextcontent를 통해 태그의 내용도 출력할 수 있다
		// * 상위태그 사이로 값이 출력되도록 나오게 할수 없을까?
		
		try {
			
			File file = new File("c:\\charlie1", "ch1.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();
			NodeList items = root.getElementsByTagName("item"); // 바로갈수있음
			// * 배열리스트는 메서드로 태그이름을 호출할 수 없다
			
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < items.getLength(); i++) {
				Node item = items.item(i);
//				System.out.println(item.getNodeName());	// item
				NodeList itemChildren = item.getChildNodes();
				
//				Node stateDt = itemChildren.item(4); 
//				stateDt.getTextContent();
				
				for(int j = 0; j < itemChildren.getLength(); j++) {
					Node itemChild = itemChildren.item(j);
//					System.out.println("  " + itemChild.getNodeName()); // item 자식태그들
					if(itemChild.getNodeName().equals("stateDt")) {
						sb.append("   날짜").append(itemChild.getNodeName()).append(itemChild.getTextContent());
					} else if (itemChild.getNodeName().equals("decideCnt")){
						sb.append("   확진자수").append(itemChild.getNodeName()).append(itemChild.getTextContent());
					} else if (itemChild.getNodeName().equals("deathCnt")){
						sb.append("   사망자수").append(itemChild.getNodeName()).append(itemChild.getTextContent());
					}
				} sb.append("\n");
			}
			System.out.println(sb.toString());

		} catch (Exception e) {
			// TODO: handle exception
		}
		}
	
	public static void m3() {
		
		// 3. 태그명으로 원하는 태그 찾아가기 연속사용
		// * ch4는 일일 기상자료
		// * category는 기상요소, obsrValue는 기상요소의 수치다
		
		try {
			
			File file = new File("c:\\charlie1", "ch4.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();
			
			NodeList items = root.getElementsByTagName("item"); // item태그들
			for (int i = 0; i < items.getLength(); i++) {		// 동일한 item태그 5개
				Element item = (Element) items.item(i);
//				NodeList categories = item.getElementsByTagName("category");
				Node category = item.getElementsByTagName("category").item(0);
				Node obsrValue = item.getElementsByTagName("obsrVaule").item(0);
				
				// <category>나난나나나나나</category>
				// <category>156156</category>
				// <category>나난나나나나나</category>
				
				
				// * 위의 item(i)과 아래의 item(0)가 다른 이유
				// => 위의 item태그는 반복되는 것들이고, 아래의 item에 있는 태그들은 하나뿐인 태그들이다?
				
				String strCategory = null;
				switch (category.getTextContent()) {
				case "PTY":
					strCategory = "강수형태";
					break;
				case "REH":
					strCategory = "습도";
					break;
				case "RN1":
					strCategory = "강수량";
					break;
				case "T1H":
					strCategory = "기온";
					break;
				case "UUU":
					strCategory = "동서바람성분";
					break;
				case "VEC":
					strCategory = "풍향";
					break;
				case "VVV":
					strCategory = "남북바람성분";
					break;
				case "WSD":
					strCategory = "풍속";
					break;

				}
				System.out.println(strCategory + ":" + obsrValue.getTextContent());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
	
	public static void m4() {
		
		// 4. 
		// * item(0)는 element를 쓸때 사용되며, 해당 위치에서 오직 하나뿐인 태그일 경우 사용된다
		// * gettextcontent는 내용을 확인하는 태그로, node, element 둘다 호출가능하다
		
		try {
			File file = new File("c:\\charlie1", "ch5.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			
			Element root = doc.getDocumentElement();
			StringBuilder sb = new StringBuilder();
			
			Node title = root.getElementsByTagName("title").item(0);
			Node pubData = root.getElementsByTagName("pubData").item(0);
			// => 해당위치에서 하나뿐인 태그기 때문에 item사용 
			
			NodeList dataList = root.getElementsByTagName("data");	// * data는 복수의 태그기때문에 for문사용
			for(int i = 0; i < dataList.getLength(); i++) {
				Element data = (Element)dataList.item(i);
				// * element 선언을 위한 강제 element캐스팅
				Node hour = data.getElementsByTagName("hour").item(0);
				Node temp = data.getElementsByTagName("temp").item(0);
				Node wfKor = data.getElementsByTagName("wfKor").item(0);
				// => element 강제 캐스팅후 각 필요한 태그를 호출, 고유한 태그니 item(0)
				sb.append(hour.getTextContent()).append("시 ");
				sb.append(temp.getTextContent()).append("도 ");
				sb.append(wfKor.getTextContent()).append("\n");
				// => 각 태그에 내용값과 문자열추가
			}
			
			
			} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void m5() {
		
		// 5. 태그안에 필요한 값이 저장되는 경우(속성)
		// * item(0)을 쓰는 경우는 getelementbytagname 메서드를 쓸때다?
		// * getelementbytagname은 반환값이 nodelist기때문에 element 캐스팅이 필요하다 **
		
		File file = new File("c:\\charlie1", "sfc_web_map.xml");
		StringBuilder sb = new StringBuilder();		
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement(); 
			// => 서류의 태그들을 root 객체에 저장?
			
			Element weather = (Element) root.getElementsByTagName("weather").item(0); // 하나뿐인 태그 weather 그중에서 0번쨰
			
			
			sb.append(weather.getAttribute("year") + "년");
			sb.append(weather.getAttribute("month") + "월");
			sb.append(weather.getAttribute("day") + "일");
			sb.append(weather.getAttribute("hour") + "시\n");
			// => weather 태그의 속성의 속성값을 호출
			
			NodeList locals = root.getElementsByTagName("local");
			for (int i = 0; i < locals.getLength(); i++) {
				Element local = (Element) locals.item(i);
				sb.append(local.getTextContent() + ":");		// 내용: 도시
				sb.append(local.getAttribute("ta") + "℃");		// ta속성에 저장된 속성값'온도'
				sb.append(local.getAttribute("desc") + "\n");	// desc에 저장된 속성값 날씨상태
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public static void main(String[] args) {
		
		//m1();
		m2();
		//m3();
		//m4();
		//m5();
		
	}
}
