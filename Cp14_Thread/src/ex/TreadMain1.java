package ex;

public class TreadMain1 {

	public static void main(String[] args) {
		
		ShowTread tread1 = new ShowTread("1번 쓰레드");
		ShowTread tread2 = new ShowTread("2번 쓰레드");
		
		tread1.start();
		tread2.start();
		
		for(int i =0; i < 100; i++) {
			System.out.println("메인 쓰레드 실행중");
		}


	}

}
