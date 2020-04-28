package ex;

import java.util.Scanner;

public class DividByZero {
	
	public static void main(String[] args) {
		System.out.println("정수 두개 입력");
		Scanner input = new Scanner(System.in);
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		
		try {
			System.out.println("나눗셈 결과 몫" + (num1/num2));
			System.out.println("나눗셈 결과 나머지" + (num1%num2));
		}
		catch (ArithmeticException e) {
			System.out.println("나눗셈 불가능");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		System.out.println("프로그램을 종료합니다.");
	}

}
