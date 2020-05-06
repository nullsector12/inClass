package ex;

public class ShowTread extends Thread{

	String treadName;
	
	public ShowTread(String treadName) {
		this.treadName = treadName;
	}

	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println("안녕하세요.  "+ treadName + " 입니다.");
		}
	
	}

}
