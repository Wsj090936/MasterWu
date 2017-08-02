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
			ServerSocket ss = new ServerSocket(9090);//设置端口号为9090
			System.out.println("服务器等待连接请求中....");
			while(true){
				Socket s = ss.accept();//接收每一个客户端的连接请求，当接收了一个连接后，才会继续执行
				System.out.println("客户"+ s.getLocalAddress().getHostName() +"已连接");
				Thread t = new Thread(new Communicate(s));
				t.start();//开始通信
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public class Communicate implements Runnable{
		Socket socket = null;
		DataInputStream dis = null;//用来接收数据，主要使用readUTF()方法来读取
		DataOutputStream dos = null;//用于发送数据
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
			//开始接收数据和发送数据
			try {
				while((str = dis.readUTF()) != null){
					System.out.println("来自客户" + socket.getLocalAddress().getHostName() + "的消息:"+str);
					String replay = scanner.nextLine();//回复消息
					dos.writeUTF(replay);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("客户已退出");
			}
		}
		
	}
}
