package ex02_writter;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLWriter {

	public static void main(String[] args) {
		
		// 2. xml
		// => csv, xml, 등은 데이터 관련 확장자 이름
		// => 확장 마크업 언어
		// => 표준 마크업 언어인 html의 확장버전
		// => 정해진 태그(<>)를 쓰는 html과 달리 사용자가 직접 제작
		
		/*
		 <product>
		 	<number>100</number>	// * 하나하나를 element(요소)라 하며,
		 	<name>새우깡</name>		// 크게 보면 product도 element라 본다
		 	<price>1500</price>		// * 계층구조이기 때문에, 
		 <product>					// product.appendchild(product의 자식추가)
		  <product>					// => 자바스크립트에서 자주나옴
		 	<number>101</number>
		 	<name>양파링</name>
		 	<price>2000</price>
		 <product>
		  <product>
		 	<number>102</number>
		 	<name>홈런볼</name>
		 	<price>3000</price>
		 <product>
		 
		 // => 이런 형태로 제공되는 데이터를 xml데이터라 한다
		 */
		
		try {
			
			// 1) Document 생성
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();	// (서류 만드는클래스)
			Document document = builder.newDocument();
			// * 위의 세 코드를 factory 패턴이라 한다
			
			document.setXmlStandalone(true);
			
			// 2) 태그 생성
		  //List<String> header = Arrays.asList("제품번호", "제품명", "가격");
			List<String> product1 = Arrays.asList("100", "새우깡", "1500");
			List<String> product2 = Arrays.asList("101", "양파링", "2000");
			List<String> product3 = Arrays.asList("102", "홈런볼", "3000");
			
			List<List<String>> list = Arrays.asList(product1, product2, product3);
			
			for(List<String> line : list) {
				
				Element product = document.createElement("product");
				Element number = document.createElement("number");
				number.setTextContent(line.get(0));
				Element name = document.createElement("name");
				name.setTextContent(line.get(1));
				Element price = document.createElement("price");
				price.setTextContent(line.get(2));
				// * 태그의 이름을 정해줌
			
			// 3) 태그배치
				
				document.appendChild(product);
				product.appendChild(number);
				product.appendChild(name);
				product.appendChild(price);
				
			}
			
			// 4) xml 생성
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty("ending", "UTF-8");
			transformer.setOutputProperty("indent", "true");
			
			Source source = new DOMSource(document);
			File file = new File("c:\\storage", "product.xml"); 
			StreamResult result = new StreamResult(file);
			
			transformer.transform(source, result);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// json 데이터
		// ex) "number" : "100"
		// => 대부분의 데이터는 json, xml, csv로 제공된다
		
		

	}

}
