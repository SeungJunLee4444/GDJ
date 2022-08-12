package prac1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
	
	public static void main(String[] args) {
		
		// p1: 웹 정보를 입출력으로 데이터 저장후 출력
		
		try {
		// 1) 접속
		String apiURL = "https:\\kma.go.kr/XML/weather/sfc_web_map.xml";
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		
		// +) 접속확인코드
		if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
			System.out.println("api 접속 실패");
			return;
		}
		
		// 2) 바이트 입력 스트립 -> 문자 스트림 -> 버퍼추가
//		InputStream in = con.getInputStream();
		InputStreamReader reader = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		// 3) 출력스트림
		File file = new File("c:\\storage", "sfc_web_map.xml");
		FileWriter fw = null;
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		// * bufferedreader 은 readline(한줄씩읽기) 지원
		
		// 4) readline() 으로 입출력
		String line = null;	// * string 타입의 데이터니
		while((line = br.readLine()) != null) {
			bw.write(line + "\n");
		
		fw.close();
		bw.close();
		con.disconnect();
		}
			
	} catch (MalformedURLException e) {
		System.out.println("api 주소 오류");
	} catch (IOException e) {
		System.out.println("api 서버오류");
	}
	
}
	}
