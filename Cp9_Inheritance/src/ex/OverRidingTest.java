package ex;

public class OverRidingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BaseEnSpeaker bSpeaker = new BaseEnSpeaker();
		bSpeaker.setVolume(10);
		bSpeaker.setBaseRate(20);
		bSpeaker.showCurrentState();

	}

}
