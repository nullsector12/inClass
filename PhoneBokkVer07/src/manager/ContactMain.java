package manager;

import java.util.Scanner;

public class ContactMain {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("데이터베이스 드라이버 로드 완료...!!");
		
		ContactManager ContactManager = new ContactManager();
		
		
		while(true) {
		System.out.println("Contact  Menu");
		System.out.println("=========================================");
		System.out.println("1. List  2. Insert  3. Search  4. Delete  5. Edit  ");
		System.out.println("=========================================");
		String selectMenu = input.nextLine();
		switch(Integer.parseInt(selectMenu)) {
		
		case 1:
		case 2:
			ContactManager.contactInsert();
		case 3:
		case 4:
		case 5:
		
		}
		
		
		}
		}

	
		
	}


