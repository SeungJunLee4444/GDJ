package network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SockServerMain {
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {
			
			serverSocket = new ServerSocket();
			InetSocketAddress address = new InetSocketAddress("localhost", 9090);
			
			serverSocket.bind(address);
			
			while(true) {
				System.out.println("[서버] 클라이언트 접속 기다리는 중");
				Socket client = serverSocket.accept();
			}
			
			InetSocketAddress clientAddress = (InetSocketAddress)client.getRemoteSocketAddress();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
