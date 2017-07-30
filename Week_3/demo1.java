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
		System.out.println("食物是美味的");
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
		System.out.println("苹果当然也是食物");
	}
	public void desc(){
		System.out.println("我苹果也是食物，很好吃,我的颜色是"+color);
	}
}