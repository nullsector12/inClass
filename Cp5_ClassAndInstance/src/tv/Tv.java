package tv;

public class Tv {
	
	// Tv의 속성(변수) -> 멤버 변수, 인스턴스 변수
	
	String color; // Tv 색상 값
	boolean power; // Tv 전원상태
	int channel; // Tv 채널값 

	// Tv의 기능 -> 메서드 (클래스의 멤버)
	
	void power() {power = !power;} // Tv를 켜거나 끄는 기능을 하는 메서드
	void channelUp() {++channel;} // Tv의 채널을 높이는 기능을 하는 메서드
	void channelDown() {channel--;} // Tv의 채널을 낮추는 기능을 하는 메서드
	void channelChange(int ch) {
		channel = ch;
	}
}
