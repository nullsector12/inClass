package ex;

public class TvMain {

	public static void main(String[] args) {
		
		Tv tv = new Tv();
		
		CaptionTv cTv = new CaptionTv();
		
		Tv t = cTv;
		
		
		Tv tv2 = new CaptionTv();
		

		
		CaptionTv ctv2 = (CaptionTv)tv2;
		
		ctv2.caption();
		
//		System.out.println(tv2.power);
//		tv2.power();
//		System.out.println(tv2.power);
//		tv2.display();
		
		Tv tv3 = new IpTv();
		Tv tv4 = new SmartTv();
//		
//		tv3.display();
//		tv4.display();
		
		Tv[] tvs = new Tv[4];
		
		tvs[0] = new Tv();
		tvs[1] = new CaptionTv();
		tvs[2] = new IpTv();
		tvs[3] = new SmartTv();
		
		for(int i = 0; i < tvs.length; i++) {
			tvs[i].display();
		}
		
		
		
		
		
		
//		System.out.println(tv2.text);  // text는 CaptionTv 인스턴스에 포함된 메서드
		
	

	}

}
