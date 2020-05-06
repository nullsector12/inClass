package ex;

public class CalAddThread extends Thread{
	
	Calculator cal;
	
	public CalAddThread(Calculator cal) {
		this.cal = cal;
	}
	public void run() {
		System.out.println("1+2 = " + cal.add(1, 2));
		System.out.println("2+4 =" + cal.add(2, 4));
	}
	
	
}
