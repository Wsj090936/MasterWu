package Week_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.junit.Test;

public class Server {
	@Test
	public void start(){
		try {
			ServerSocket ss = new ServerSocket(9090);//���ö˿ں�Ϊ9090
			System.out.println("�������ȴ�����������....");
			while(true){
				Socket s = ss.accept();//����ÿһ���ͻ��˵��������󣬵�������һ�����Ӻ󣬲Ż����ִ��
				System.out.println("�ͻ�"+ s.getLocalAddress().getHostName() +"������");
				Thread t = new Thread(new Communicate(s));
				t.start();//��ʼͨ��
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public class Communicate implements Runnable{
		Socket socket = null;
		DataInputStream dis = null;//�����������ݣ���Ҫʹ��readUTF()��������ȡ
		DataOutputStream dos = null;//���ڷ�������
		Scanner scanner = new Scanner(System.in);
		public Communicate(Socket socket){
			this.socket = socket;
			try {
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			String str = null;
			//��ʼ�������ݺͷ�������
			try {
				while((str = dis.readUTF()) != null){
					System.out.println("���Կͻ�" + socket.getLocalAddress().getHostName() + "����Ϣ:"+str);
					String replay = scanner.nextLine();//�ظ���Ϣ
					dos.writeUTF(replay);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("�ͻ����˳�");
			}
		}
		
	}
}
