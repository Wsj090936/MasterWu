package Week_1;

import org.junit.Test;

public class week_1 {
@Test
    public void test(){
	  int x = 0;
	  int y = 1;
	  if(x == y){
		  System.out.println(x+"!="+y);
	  }
	  x += 9;
	  System.out.println(x);
	  
	  for(int i = 0;i < x;i++){
		  x = x - 1;
	  }
	  System.out.println("����forѭ����x��ֵΪ:"+x);//4
	  
	  do {
		x += 1;
	} while (y > 1);
	  System.out.println("����do..whileѭ����x��ֵΪ"+x);//5
	  
	  while(!(x % 10 == 0)){
		  x += 1;
		  y = y + x;
	  }
	  System.out.println("����whileѭ����x��ֵΪ"+x);//10
	  System.out.println(x==y);//false
	  x = y;
	  System.out.println(x == y ? true : false);//true
  }
}
