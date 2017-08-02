package Week_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.junit.Test;

public class Client {
	@Test
	public void start(){
		try {
			Socket socket = new Socket("localhost",9090);
			DataInputStream dis = new DataInputStream(socket.getInputStream());//�������Է���������Ϣ������������
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());//�������������Ϣ�����������
			Scanner scanner = new Scanner(System.in);
			String str = null;//�洢��������������ݵ��ַ���
			receive(dis);//�������Է���������Ϣ
			System.out.print("��˵:");
			while((str = scanner.nextLine()) != null){//��ȡ�û��Ӽ����������һ�����ݣ����͸�������
				dos.writeUTF(str);//���͸�������
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void receive(DataInputStream dis){//������Ϣ�ķ���
		Thread T = new Thread(){
			@Override
			public void run() {
				super.run();
				String message = null;//�洢���շ�����������Ϣ���ַ���
				try {
					while((message = dis.readUTF()) != null){//���շ�������������Ϣ
						System.out.println("���Է���������Ϣ:"+message);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		T.start();
	}
}
