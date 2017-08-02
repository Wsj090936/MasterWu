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
			DataInputStream dis = new DataInputStream(socket.getInputStream());//接收来自服务器的消息的数据输入流
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());//向服务器发送消息的数据输出流
			Scanner scanner = new Scanner(System.in);
			String str = null;//存储向服务器发送数据的字符串
			receive(dis);//接收来自服务器的消息
			System.out.print("你说:");
			while((str = scanner.nextLine()) != null){//读取用户从键盘上输入的一行数据，发送给服务器
				dos.writeUTF(str);//发送给服务器
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void receive(DataInputStream dis){//接收消息的方法
		Thread T = new Thread(){
			@Override
			public void run() {
				super.run();
				String message = null;//存储接收服务器发来消息的字符串
				try {
					while((message = dis.readUTF()) != null){//接收服务器发来的消息
						System.out.println("来自服务器的消息:"+message);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		T.start();
	}
}
