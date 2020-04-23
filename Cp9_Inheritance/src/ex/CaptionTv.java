package ex;

public class CaptionTv extends Tv {
	
	String text;
	
	void caption() {
		text = "야발";
		System.out.println("자막 출력 : " + text);
	}
	
//@overriding
	void display() {
		super.display();
		caption();
	}
	
}
