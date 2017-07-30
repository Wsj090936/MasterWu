package Week_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 执行的任务为将TestRunnable中的count参数值增加，增加任务一共10次，每次一个线程将其数值增加5，10个任务完成后
 * count的最终值为50
 * @author wushijia
 *
 */
public class TestThread {
	public static void main(String[] args) {
		ExecutorService Service = Executors.newFixedThreadPool(3);//设置最多三个线程
		System.out.println("加入10个任务");
		TestRunnable run = new TestRunnable();
		for(int i = 1;i <= 10;i++){
			Service.execute(run);
		}
		try {
			Thread.sleep(1000);//确认没有任务传进来再关闭
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Service.shutdown();
		System.out.println("10个任务全部完成");
	}
}
class TestRunnable implements Runnable{
	int count = 0;
	Object obj = new Object();//同步锁
	@Override
	public void run() {
		synchronized(obj){
			System.out.println(Thread.currentThread().getName()+"启动,开始执行任务");
			for(int i = 0; i <=4; i++){
				count++;
				if(i == 4){
					System.out.println("任务完成，该次任务完成后参数值为"+count);
				}
			}
			System.out.println(Thread.currentThread().getName()+"结束了");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		}
	}
}