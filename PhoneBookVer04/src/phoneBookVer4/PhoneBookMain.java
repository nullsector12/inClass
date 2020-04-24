package phoneBookVer4;

public class PhoneBookMain {
	
	public static void main(String[] args) {
		
		PhoneInfoManager manager = new PhoneInfoManager(10);
		
		while(true) {
			
			System.out.println("======================");
			System.out.println("[					메뉴 입력					]");
			System.out.println("			1. 대학 친구 정보 저장");
			System.out.println("			2. 회사 동료 정보 저장");
			System.out.println("			3. 커피숍 정보 저장");
			System.out.println("			4. 가족 정보 저장");
			System.out.println("			5. 기본 정보 전체 검색");
			System.out.println("			6. 프로그램 종료");
			System.out.println("======================");
			
			int choice = manager.input.nextInt();
			
			manager.input.nextLine(); // 앞의 버퍼 클리어
			
			switch (choice) {
			case 1: case 2: case 3: case 4: 
				manager.insertInfo(choice);
				break;
			case 5: 
				manager.showAllBasicData();
				break;
			case 6:
				System.out.println("=========프로그램을 종료합니다. ========");
				return;
			}
			
		}
			
		}
		
	}

