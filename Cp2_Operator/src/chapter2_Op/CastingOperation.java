package chapter2_Op;

public class CastingOperation {

	
	public static void main(String[] args) {
		
		char ch1 = 'A';
		char ch2 = 'Z';
		
		int num1 = ch1; // char -> int로 형변환
		int num2 = (int)ch2; //명시적 형변환
		
		System.out.println(num1);
		System.out.println(num2);
		
		
	}
}
