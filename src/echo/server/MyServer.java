package echo.server;
/*
 * �ڹٸ� �̿��Ͽ� ������ ���α׷��� �ۼ��Ѵ�
 * 
 * */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

	//��ȭ�� ���������� ������ �˷��ֱ� ���� ��ü
	//�� ���� ��ȭ�� ��������
	//������ Ŭ���̾�Ʈ�� ã�ƿ��� ��ٸ��Ƿ� Ŭ�󸮾�Ʈ�� ����� ��Ʈ��ȣ�� �����ϸ� �ȴ�.
	//��Ģ�� ��Ʈ��ȣ�� �����Ӱ� ���ϸ� �ȴ�.
	//����  0~1023�̹� �ý����� �����ϰ� �ִ� ��Ʈ  211.238.142.117
	//���� ������ ���α׷����� ������   oracel 1521, mysql 3306, web 80 
public class MyServer{
	ServerSocket server;
	int port=8888;
	Socket socket;
	public MyServer() {
		try {
			server = new ServerSocket(port);
			System.out.println("���� ����");
			//Ŭ���̾�Ʈ�� ������ ��ٸ���
			//������ ���������� ���Ѵ���Ѵ�. �� ������ ������. ��ġ ��Ʈ�� read()�迭�� ����
			while(true){
				socket= server.accept();
				System.out.println("������ �߰�");
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
