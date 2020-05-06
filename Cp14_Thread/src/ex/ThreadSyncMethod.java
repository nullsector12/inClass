package ex;

public class ThreadSyncMethod {

	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		CalAddThread at = new CalAddThread(cal);
		MinThread mt = new MinThread(cal);
		
		at.start(); mt.start();
		try {
			at.join(); mt.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	cal.showOpCnt();

	}

}
