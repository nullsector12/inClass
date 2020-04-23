package ex;

public class Tv {
	
	boolean power;
	int channel;
	
	void power() {
		power = !power;
	}

	void channelUp() {
		channel = ++channel;
	}
	
	void channelDown() {
		channel = --channel;
	}
	
	void display() {
		System.out.println("TV를 재생합니다.");
		
	}
}
