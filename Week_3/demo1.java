package Week_3;

public class demo1 {
public static void main(String[] args) {
	food Food = new apple("red");
	Food.delicious();
	apple app = (apple)Food;
	app.desc();
}
}

class food {
	food(){}
	public void delicious(){
		System.out.println("ʳ������ζ��");
	}
}
class apple extends food{
	private String color;
	apple(String color){
		this.color = color;
	}
	@Override
	public void delicious() {
		super.delicious();
		System.out.println("ƻ����ȻҲ��ʳ��");
	}
	public void desc(){
		System.out.println("��ƻ��Ҳ��ʳ��ܺó�,�ҵ���ɫ��"+color);
	}
}