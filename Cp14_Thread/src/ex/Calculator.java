package ex;

public class Calculator {
	int opCnt = 0;
	
	public int add(int n1, int n2) {
		
		opCnt++;
		return n1+n2;
	}

	public int min(int n1, int n2) {
		
		opCnt++;
		return n1-n2;
	}
	
	public void showOpCnt() {
		
		System.out.println("총 연산 횟수 : " + opCnt);
	}

	
}
