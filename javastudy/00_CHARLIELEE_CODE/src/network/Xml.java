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

public class Xml {

	public static void main(String[] args) {
		
		// * 기상청 단기예보(xml, json 둘다 가능)
		
		String serviceKey = "";
		StringBuilder urlBuilder = new StringBuilder();
		
		try {
			
			urlBuilder.append("http://apis.data.go.kr/1360000/VilageFcsInfoService_2.0/getUltraSrtNcst");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&numOfRows=10");
			urlBuilder.append("&pageNo=1");
			urlBuilder.append("&base_data=20210628");
			urlBuilder.append("&base_time=0600");
			urlBuilder.append("&nx=55");
			urlBuilder.append("&ny=127");
			

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		HttpURLConnection con = null;
		
		try {
			
			con = (HttpURLConnection)new URL(urlBuilder.toString()).openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String response = sb.toString();
		
		File file = new File("c:\\charlie1\\ch8.xml");
		BufferedWriter bw = null;
		try {
			
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(response);
		
//		try {
//			
//			File file = new File(response); // * string에 저장된 데이터로 file의 매개변수로 가능하다
//			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder builder = factory.newDocumentBuilder();
//			Document doc = builder.parse(file);
//			System.out.println(doc);
//			
//			Element root = doc.getDocumentElement();
//			System.out.println(root);
//			
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//

		

	}

}
