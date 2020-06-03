package manager;

import java.util.Scanner;

import excepClass.BadNumberException;

public class ContactMain {

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		ContactManager ContactManager = new ContactManager();


		while(true) {
			System.out.println("Contact  Menu");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("1. 전체리스트 출력	2. 신규정보 등록	3. 전화번호부 검색\n\n4. 정보 삭제	5. 기존정보 수정	6. 전화번호부 종료");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			int selectMenu = 0;
			
			try {
				selectMenu = Integer.parseInt(input.nextLine());
				if(selectMenu < MenuInterface.CONTACTLIST || selectMenu > MenuInterface.CONTACTEXIT) {
				BadNumberException e = new BadNumberException("잘못된 번호 입력입니다.");
				throw e;
				}
			}catch (NumberFormatException e) { // 정수가 아닌 다른 형태의 입력 예외
				System.out.println("문자열을 입력하셨습니다");
				System.out.println("1 - 6 사이의 숫자를 입력해주세요.");
				continue;
			} catch (BadNumberException e) { // 메뉴에 없는 다른 숫자의 입력 예외
				System.out.println("메뉴범위를 벗어난 숫자를 입력하셨습니다");
				System.out.println("1 - 6 사이의 숫자를 입력해주세요.");
				continue;
			} catch (Exception e) {
				System.out.println("오류가 발생했습니다.");
				System.out.println("다시 메뉴를 입력해주세요.");
				continue;
			}
			
			switch(selectMenu) {

			case MenuInterface.CONTACTLIST:
				ContactManager.contList();
				break;
			case MenuInterface.CONTACTINSERT:
				ContactManager.contactInsert();
				break;
			case MenuInterface.CONTACTSEARCH:
				ContactManager.contSearch();
				break;
			case MenuInterface.CONTACTDELETE:
				ContactManager.contDelete();
				break;
			case MenuInterface.CONTACTCHANGEINFO:
				ContactManager.contChangeInfo();
				break;
			case MenuInterface.CONTACTEXIT:
				System.out.println("전화번호부 프로그램 종료");
				System.exit(0);
			}
		}
	}
}


