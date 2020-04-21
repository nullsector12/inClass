package chapter2_Op;

public class ArithOp {

	public static void main(String[] args) {
		
		int n1 = 50;
		int n2 = 6 ;
		//1. 덧셈
		int result = n1 + n2;
		System.out.println("덧셈 결과: " + result);
		//2. 뺄셈
		result = n1 - n2;
		System.out.println("뺄셈 결과: " + result);
		//3. 곱셈
		System.out.println("곱셈 결과: "+ n1*n2);
		//4.나눗셈, 몫
		System.out.println("나눗셈 결과: "+ n1/n2);
		//5. 나눗셈, 나머지
		System.out.println("나머지 결과: "+ n1%n2);
		
	}

}
