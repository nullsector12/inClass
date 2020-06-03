package manager;

import java.util.Scanner;

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
			String selectMenu = input.nextLine();
			switch(Integer.parseInt(selectMenu)) {

			case 1:
				ContactManager.contList();
				break;
			case 2:
				ContactManager.contactInsert();
				break;
			case 3:
				ContactManager.contSearch();
				break;
			case 4:
				ContactManager.contDelete();
				break;
			case 5:
				ContactManager.contChangeInfo();
				break;
			case 6:
				System.out.println("전화번호부 프로그램 종료");
				System.exit(0);

			}
		}
	}
}


