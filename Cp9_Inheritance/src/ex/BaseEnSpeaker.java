package ex;

public class BaseEnSpeaker extends Speaker {
	
	private int baseRate;
	
	void setBaseRate(int base) {
		baseRate = base;
	}

	@Override
	void showCurrentState() {
		// TODO Auto-generated method stub
		super.showCurrentState();
		System.out.println("베이스 크기 : " + baseRate);
	}

	@Override
	void setVolume(int vol) {
		// TODO Auto-generated method stub
		super.setVolume(vol);
		System.out.println("볼륨 크기 : " + vol);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "베이스 스피커";
	}

}
