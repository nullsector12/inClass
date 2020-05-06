package ex;

public class MinThread extends Thread{

	Calculator cal;
	public MinThread(Calculator cal) {
		this.cal = cal;
	}
		public void run() {
			System.out.println("2-1 = " + cal.min(2, 1));
			System.out.println("4-2 = " + cal.min(4, 2));
		}
	}

