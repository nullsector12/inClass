package tv;

public class TvUI2 {

	public static void main(String[] args) {
		
		Tv tv1 = new Tv();
		Tv tv2 = new Tv();
		
		System.out.println(tv1 == tv2);
		
		System.out.println("tv1의 channel : "+ tv1.channel);
		System.out.println("tv2의 channel : "+ tv2.channel);
		
		tv2 = tv1;
		
		System.out.println(tv1 == tv2);
		
		tv1.channel = 7;
		System.out.println("tv1의 channel을 "+ tv1.channel + "로 변경함");
		
		System.out.println("tv1의 channel : "+ tv1.channel);
		System.out.println("tv2의 channel : "+ tv2.channel);
		
	
	}

}
