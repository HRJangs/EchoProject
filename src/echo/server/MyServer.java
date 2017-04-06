package echo.server;
/*
 * 자바를 이용하여 서버측 프로그램을 작성한다
 * 
 * */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

	//대화를 나누기전에 접속을 알려주기 위한 객체
	//즉 아직 대화는 못나눈다
	//서버는 클라이언트가 찾아오길 기다리므로 클라리언트와 약속한 포트번호만 보유하면 된다.
	//원칙은 포트번호는 자유롭게 정하면 된다.
	//예외  0~1023이미 시스템이 정의하고 있는 포트  211.238.142.117
	//예외 유명한 프로그램들은 피하자   oracel 1521, mysql 3306, web 80 
public class MyServer{
	ServerSocket server;
	int port=8888;
	Socket socket;
	public MyServer() {
		try {
			server = new ServerSocket(port);
			System.out.println("서버 생성");
			//클라이언트의 접속을 기다린다
			//접속이 있을때까지 무한대기한다. 즉 지연에 빠진다. 마치 스트림 read()계열과 같다
			while(true){
				socket= server.accept();
				System.out.println("접속자 발견");
				InputStream is =socket.getInputStream();
				InputStreamReader reader = new InputStreamReader(is,"euc-kr");
				int data;
				while(true){
					data =reader.read();
					System.out.print((char)data);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new MyServer();
	}

}
