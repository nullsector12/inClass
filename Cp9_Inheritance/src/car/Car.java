package car;

public class Car {
	
	String color;
	int door;
	
	void drive() {
		System.out.println("운전===");
	}
	
	void stop() {
		System.out.println("===멈춤");
	}
}

class FireEngine extends Car{
	void water() {
		System.out.println("물대포");
		}
	}		

	class Ambulance extends Car {
		void siren(){
			System.out.println("ㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐ");
		}
	}
