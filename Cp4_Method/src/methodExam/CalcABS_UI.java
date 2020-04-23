package methodExam;

public class CalcABS_UI {
	public static void main(String[] args) {
		
		// 인스턴스 생성
		CalcABS calcNum = new CalcABS();
		
		// 숫자를 전달한다. 
		calcNum.num1 = -1111111;
		calcNum.num2 = 555;
		
		// 절대값 변환 메서드를 출력
		calcNum.changeABS(0, 0);
	}
}
