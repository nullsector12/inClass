package car;

public class CastingTest {

	public static void main(String[] args) {
		Car car = null;
		FireEngine fire = new FireEngine();
		FireEngine fire2 = null;
		Ambulance am = null;
		
		fire.water();
		
		// 자손클래스 => 조상클래스 형 변환은 생략가능
		car = fire;
		
		// 형 변환 자체가 안될수도 있는 경우가 있어서 자동생략 x
		// 조상클래스 => 자손클래스 형 변환은 명시해줘야함
		fire2 = (FireEngine)car;
		fire2.water();
		
		if ( car instanceof Ambulance) {
			am = (Ambulance)car;
		}
		
	
	
		
		
		
		
		
	}
	
}	

