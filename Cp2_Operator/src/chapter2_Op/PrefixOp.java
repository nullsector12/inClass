package chapter2_Op;

public class PrefixOp {

	public static void main(String[] args) {
		
		int num1 = 7;
		int num2 = ++num1; // num1 = 8, -> num2 = 8
		int num3 = --num1; // num1 = 7 -> num3 = 7
		
		
		System.out.println(++num1); // num1 -> 8
		System.out.println(num2); // num2 = 8
		System.out.println(--num2); // num2 = 7
		System.out.println(num3); // num3 = 7
		

	}

}
