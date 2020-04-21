package phoneBook;

import java.util.Scanner;

public class PhoneInfor {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		System.out.println("이름을 입력하세요 : ");
		String name = input.nextLine();
		System.out.println("전화번호를 입력하세요 : ");
		String phoneNumber = input.nextLine();
		System.out.println("생년월일을 입력하세요 : ");
		String birthDay = input.nextLine();

		
		System.out.println(name);
		System.out.println(phoneNumber);
		System.out.println(birthDay);
	}
	
	// 1. 입력
	// 2. 종료

}
