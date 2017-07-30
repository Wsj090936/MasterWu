package Week_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * ִ�е�����Ϊ��TestRunnable�е�count����ֵ���ӣ���������һ��10�Σ�ÿ��һ���߳̽�����ֵ����5��10��������ɺ�
 * count������ֵΪ50
 * @author wushijia
 *
 */
public class TestThread {
	public static void main(String[] args) {
		ExecutorService Service = Executors.newFixedThreadPool(3);//������������߳�
		System.out.println("����10������");
		TestRunnable run = new TestRunnable();
		for(int i = 1;i <= 10;i++){
			Service.execute(run);
		}
		try {
			Thread.sleep(1000);//ȷ��û�����񴫽����ٹر�
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Service.shutdown();
		System.out.println("10������ȫ�����");
	}
}
class TestRunnable implements Runnable{
	int count = 0;
	Object obj = new Object();//ͬ����
	@Override
	public void run() {
		synchronized(obj){
			System.out.println(Thread.currentThread().getName()+"����,��ʼִ������");
			for(int i = 0; i <=4; i++){
				count++;
				if(i == 4){
					System.out.println("������ɣ��ô�������ɺ����ֵΪ"+count);
				}
			}
			System.out.println(Thread.currentThread().getName()+"������");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		}
	}
}