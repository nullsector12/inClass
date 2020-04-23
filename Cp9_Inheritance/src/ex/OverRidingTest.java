package ex;

public class OverRidingTest {

	public static void main(String[] args) {
		//  다형성 : 상위클래스 타입의 참조변수에 
		// 하위클래스의 인스턴스를 참조하는 것.
		
		Speaker sp = new BaseEnSpeaker();
		// 참조변수 sp는 BaseEnSpeaker 인스턴스의 멤버중
		// Speaker가 가진 멤버만 사용 가능.
		
		sp.showCurrentState();
		sp.setVolume(50);
		
		BaseEnSpeaker bSpeaker = new BaseEnSpeaker();
		bSpeaker.setVolume(10);
		bSpeaker.setBaseRate(20);
		bSpeaker.showCurrentState();
		System.out.println(bSpeaker.toString());
	}

}
