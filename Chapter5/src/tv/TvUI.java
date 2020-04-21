package tv;

public class TvUI {
	
	public static void main(String[] args) {
		
		// Tv 인스턴스 생성
		Tv tv = new Tv();
		
		System.out.println("------------");
		System.out.println("Tv의 속성값");
		System.out.println("Tv의 color : " + tv.color);
		System.out.println("Tv의 power : "+ tv.power);
		System.out.println("Tv의 channel : " +  tv.channel);
		
		tv.channel = 11;
		System.out.println("Tv의 channel : " +  tv.channel);
		
		tv.channelUp();
		System.out.println("Tv의 channel : " +  tv.channel);
		
		tv.channelChange(100);
		System.out.println("Tv의 channel : " +  tv.channel);
		
		tv.channelDown();
		System.out.println("Tv의 channel : " +  tv.channel);
		
	}

}
