package methodExam;

public class Clac_UI { // 호출을 위한 클래스
	
	public static void main(String[] args) {
		
		// 인스턴스 생성
		Calc calcNum = new Calc();
		
		// 숫자를 전달한다. 
		calcNum.num1 = 111;
		calcNum.num2 = 55;
		calcNum.str = "/";
		calcNum.pushResult();

	}

}
