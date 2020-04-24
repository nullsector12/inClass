package overridingExam;

public class Main  {
	

	public static void main(String[] args) {
		
		Box box1 = new Box ();
		PaperWrap box2 = new PaperWrap();
		GoldWrap box3 = new GoldWrap();
		
		box1.wrap();
		box2.wrap();
		box3.wrap();
	
	}
	
	public static void wrapBox (Box box) {
		box.wrap();
	}
}
