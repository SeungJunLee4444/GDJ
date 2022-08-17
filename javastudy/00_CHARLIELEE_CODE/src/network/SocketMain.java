package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketMain {
	
	// [socket]
	// => 프로젝트에서 상담원과의 채팅을 구현할 때 사용되는 클래스
	// => 기본적으로 byte 스트림을 입출력하는데 사용되며, getinput, outputstream 메서드를 지닌다
	
	public static void m1() {
		
		ServerSocket serverSocket = null;
		
		try {
			// 1. 서버소켓
			// 1) 서버소켓 생성
			serverSocket = new ServerSocket();
			
			// 2) 서버소켓주소 생성후 서버소켓과 연결
			InetSocketAddress address = new InetSocketAddress("localhost", 9090);
			// => 호스트, 포트번호 설정가능
			
			// 3) 접속한 클라이언트 개수
			int clientCnt = 0;
			
			// 4) 종료없이 무한루프 서버
			while(true) {
				System.out.println("[서버] 클라이언트 접속 기다리는중");
			
			// 5) 클라이언트 접속 및 카운팅
			Socket clientSocket = serverSocket.accept();
			clientCnt++;
			// => * clientsocket에 모든게 연결된 채로 input, output이 이루어진다
			// (서버에 직접 전송되는게 아닌듯?)
			
			// => 클라이언트가 서버소켓을 받아들임
			
			// 6) 클라이언트에게 welcome 메시지 전송
			DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
			out.writeUTF("[서버] 게스트님 환영합니다" + clientSocket + "님 환영합니다!");
			
			
			// 7) 클라이언트가 보낸 메시지 확인
			InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
			StringBuilder sb = new StringBuilder();
			
			int readByte = 0;
			char[] cbuf = new char[5];
			while((in.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readByte);
			}
			System.out.println(sb.toString());
			
			in.close();
			out.close();
			
			if(clientCnt == 3) {
				System.out.println("[서버] 서버 종료");
				serverSocket.close();//--------------------------------------? 왜 두번종료?
				break;
			}
			
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
			if(serverSocket.isClosed() == false) {
				serverSocket.close();
			}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	
	public static void m2() {
		
		// 2. 클라이언트 소켓
		// 1) socket 생성
		Socket clientSocket = null;
		
		// 2) 서버접속 
		try {
			clientSocket = new Socket();
			clientSocket.connect(new InetSocketAddress("localhost", 9090));
			
			// * 서버소켓 : 주소를 만들고 고객 소켓과 연결
			// * 고객소켓 : 고객소켓을 서버소켓에 만든 동일한 주소, 포트번호에 연결
			
		// 3. 서버의 welcome메시지 받기
		DataInputStream in = new DataInputStream(clientSocket.getInputStream());
		String message = in.readUTF();
		System.out.println("[클라이언트]" + message);
		
		// 4. scanner 클래스를 이용해 입력받은 데이터를 서버로 보내기
		Scanner sc = new Scanner(System.in);
		System.out.println("서버로 전송할 메시지 >>>");
		String send = sc.nextLine();
		OutputStreamWriter out = new OutputStreamWriter(clientSocket.getOutputStream());
		// => 입력한 글자가 특수문자, 한글도 포함되기 때문에 , reader, writer 사용
		out.write(send);
		
		out.close();
		in.close();
		sc.close();
//		clientSocket.close();
			
		} catch (IOException e) {
			
			} finally {
				try {
					if(clientSocket.isClosed() == false) {
						System.out.println("[클라이언트] 클라이언트 종료");
						clientSocket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
	}
	

	public static void main(String[] args) {
		
		m1();
		m2();
		

	}

}
