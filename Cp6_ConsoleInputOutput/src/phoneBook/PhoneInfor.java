package phoneBook;

import java.util.Scanner;

public class PhoneInfor {
	// 해당 클래스내에서 사용하기 위해 static 선언
	static String name; 
	static String phoneNumber;
	static String birthDay;
	static String command = null;
	
	public PhoneInfor(){} // default 메서드 생성
	
	
	public PhoneInfor (String name, String phoneNumber, String birthDay){
		name = this.name;
		phoneNumber = this.phoneNumber;
		birthDay = this.birthDay;
	}
	
	public PhoneInfor (String name, String phoneNumber){
		name = this.name;
		phoneNumber = this.phoneNumber;
		birthDay = this.birthDay;
	}
	
	void showBook(){
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("생년월일 : " + birthDay);
		}
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("전화번호 등록을 시작합니다 : ");
		while(true) { // 선택에 따라 프로그램 무한 반복 = while문
			System.out.println("이름 입력");
			name = input.nextLine();
			
			 System.out.println("전화번호 입력");
			phoneNumber = input.nextLine();
			
			System.out.println("생년월일 입력");
			birthDay = input.nextLine();
			
			PhoneInfor save = new PhoneInfor(); // 사용자가 입력한 정보 저장
			save.showBook(); // 저장된 정보 출력 메서드 호출
			
			
			System.out.println("프로그램 종료? :  종료는 y 입력, 계속 하려면 n 입력");
			command = input.nextLine();
			if("n".equals(command))  // command에 입력되는 문자열이 n 과 같으면 (equals), 프로그램 다시 진행 
				continue;
			if (command.equals("y")) { // command에 입력된 문자열이 y와 같으면 프로그램 종료함
				System.out.println("전화번호 저장 종료");
				System.exit(0); // System.exit(0) 클래스
				}
				}
		}
	


//	@Override
//	public String toString() {
//		return "PhoneInfor [name=" + name + ", phoneNumber=" + phoneNumber + ", birthDay=" + birthDay + "]";
//	}
		
//	public static void main(String[] args) {
//		
//		
//		Scanner input = new Scanner(System.in);
//
//		System.out.println("이름을 입력하세요 : ");
//		name = input.nextLine();
//		System.out.println("전화번호를 입력하세요 : ");
//		phoneNumber = input.nextLine();
//		System.out.println("생년월일을 입력하세요 : ");
//		birthDay = input.nextLine();
//
//		
//		System.out.println(name);
//		System.out.println(phoneNumber);
//		System.out.println(birthDay);
	// 1. 입력
	// 2. 종료

}
