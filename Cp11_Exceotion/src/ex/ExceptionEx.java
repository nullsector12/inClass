package ex;

import java.util.Scanner;

public class ExceptionEx {
	
	public static void main(String[] args) {
		
		System.out.println("나이 입력");
		Scanner input = new Scanner(System.in);
		int age = input.nextInt();
		try {
			if(age < 0) {
				AgeInputException e = new AgeInputException();
				throw e;
			}
			System.out.println("나이는 " + age + "입니다.");
		}catch(AgeInputException e) {
			System.out.println("에러메세지 : " + e.getMessage());
		}
		System.out.println("프로그램 종료");
	}


	
}
