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
	List<Integer> list = new ArrayList<>();//���ڴ�Ų²��¼�Ķ�̬����
	@Test
	public void start(){
		Scanner scanner = new Scanner(System.in);
		count = 0;
		System.out.print("��������Ӧ������ѡ����: 1:��ʼ��Ϸ  2:�鿴���а� �����1��2�����������˳���Ϸ");
		int select = 0;
		try {
			select = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("��������������������֣���Ϊ�����½�����Ϸ");
			start();
		}
		if(select == 1){
			System.out.println("��Ϸ��ʼ�ˣ�����");
			
			run();

		}else if(select == 2){
			System.out.println("���а����£�����������r����");
			Collections.sort(list);
			System.out.println(list);
			
			String a = scanner.next();
			char b = a.charAt(0); 
			if(b == 'r'){
				start();
			}
		}else
			System.out.println("��Ϸ������");
	}
	public void run(){//��Ϸ���е�������
		int num = random.nextInt(100);//��ʼ�������
		System.out.println(num);
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.print("�������������������~:");
			int image = scanner.nextInt();
			if(image == num){
				System.out.println("�¶���,��������");
				++count;
				break;
			}else if(image > num ){
				System.out.println("�´�����~���˴��� ��ǰ�²����Ϊ"+count+" �����²�Ŷ");
				++count;
			}else
				System.out.println("�´�����~С��С�� ��ǰ�²����Ϊ"+count+" �����²�Ŷ");
			   ++count;
		}
		
		System.out.println("��Ϸ����������һ��������r�����������ַ��˳���Ϸ");
		String a = scanner.next();
		char b = a.charAt(0); 
		if(b == 'r'){
			list.add(count);
			start();
	  }else
		  list.add(count);
	}
}
