package chapter2_Op;

public class TestOp2 {

	public static void main(String[] args) {
		// 문제2 : 수학식 {{(25x5)+(36-4)}-72}/5 의 계산결과를 출력하는 프로그램 작성.
		
		int a = 25*5; //= 125
		int b = 36-4; //= 32
		int c = (a+b)-72; //= (125+32)-72 = 157-72 = 85
		int d = c/5; // 85/5 = 17
		
		System.out.println(d); // d = 17
		
			}

}
