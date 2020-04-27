package phoneBookVer4;

/**
 * 작성자 : 김승연
 * 작성일시 : 2020. 04. 24
 * 클래스 설명 : Manager에 구현된 기능들을 실행하는 Main메서드
 * 
 * 수정 일시 : 2020. 04. 27
 * 수정 내용 : 메뉴클래스를 나눔, 검색, 삭제등의 기능실행 추가,  
 *
 */
public class PhoneBookMain {
	
	public static void main(String[] args) {
		
		PhoneInfoManager manager = PhoneInfoManager.getInstance();
		
		while(true) {
			
			PhoneBookMenu.menu();
			
			int choice = manager.input.nextInt();
			
			manager.input.nextLine(); // 앞의 버퍼 클리어
			
			switch (choice) {
			case 1: 
				manager.insertInfo(choice);
				break;
			case 2: 
				manager.showAllBasicData();
				break;
			case 3:
				manager.serchNameInfo();
				break;
			case 4:
				manager.deleteInfo();
				break;
			case 5:
				System.out.println("=========프로그램을 종료합니다. ========");
				return;
			}
			
		}
			
	}
		
}

