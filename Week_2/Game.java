package Week_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

public class Game {
	Random random = new Random();
	private int count = 0;
	List<Integer> list = new ArrayList<>();//用于存放猜测记录的动态数组
	@Test
	public void start(){
		Scanner scanner = new Scanner(System.in);
		count = 0;
		System.out.print("请输入相应的数字选择功能: 1:开始游戏  2:查看排行榜 输入除1和2的任意数字退出游戏");
		int select = 0;
		try {
			select = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("你的输入有误！请输入数字，将为你重新进入游戏");
			start();
		}
		if(select == 1){
			System.out.println("游戏开始了！加油");
			
			run();

		}else if(select == 2){
			System.out.println("排行榜如下，返回请输入r返回");
			Collections.sort(list);
			System.out.println(list);
			
			String a = scanner.next();
			char b = a.charAt(0); 
			if(b == 'r'){
				start();
			}
		}else
			System.out.println("游戏结束！");
	}
	public void run(){//游戏运行的主方法
		int num = random.nextInt(100);//初始化随机数
		System.out.println(num);
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.print("请输入你心里想的数字~:");
			int image = scanner.nextInt();
			if(image == num){
				System.out.println("猜对了,你真厉害");
				++count;
				break;
			}else if(image > num ){
				System.out.println("猜错了呢~大了大了 当前猜测次数为"+count+" 请重新猜哦");
				++count;
			}else
				System.out.println("猜错了呢~小了小了 当前猜测次数为"+count+" 请重新猜哦");
			   ++count;
		}
		
		System.out.println("游戏结束！再来一次请输入r，输入其他字符退出游戏");
		String a = scanner.next();
		char b = a.charAt(0); 
		if(b == 'r'){
			list.add(count);
			start();
	  }else
		  list.add(count);
	}
}
