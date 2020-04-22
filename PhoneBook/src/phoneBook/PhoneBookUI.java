package phoneBook;

/*
 * 전화번호부 프로젝트 - 
 * https://github.com/nullsector12/inClass (private)
 * 작성자 : 김승연
 * 수정일자 : 2020. 04. 22
 * 	수정 내용 : 메인메뉴의 UI불러오는 기능을 새로운 클래스로 객체화
 * 						int값의 입력을 통해 원하는 기능 선택가능한 기능 추가
 * 						프로그램 종료 기능 추가
 */

import java.util.Scanner;

class PhoneBookUI{

	public static void main(String[] args) {
		
		SavePhoneInfor manager = new SavePhoneInfor();
		Scanner input = new Scanner(System.in);

		while(true) {
			
			MainUI.showMenu();
			
			int selectNum = input.nextInt();
			input.nextLine(); // int 입력 패싱을 막기위해 
			
			switch(selectNum) {
			
			case 1:
				manager.saveInfo();
				break;
			case 2:
				manager.serchInfo();
				break;
			case 3:
				manager.deleteInfo();
				break;
			case 4:
				manager.showAllData();
				break;
			case 5:
//				return;
				System.out.println("프로그램 종료");
				System.exit(0);
			}
			
		} 	
		
	}
	
}