package phoneBookVer5;

/**
 * 작성자 : 김승연
 * 작성일시 : 2020. 04. 24
 * 클래스 설명 : Manager에 구현된 기능들을 실행하는 Main메서드
 * 
 * 수정 일시 : 2020. 04. 27
 * 수정 내용 : 메뉴클래스를 나눔, 검색, 삭제등의 기능실행 추가,  PhoneBookManager 인스턴스 한개 생성(싱글톤)
 *
 * 수정 일시 : 2020. 04. 28
 * 수정 내용 : 메뉴선택을 위해 받는 정수의 인터페이스(상수)화
 */
public class PhoneBookMain {
	
	public static void main(String[] args) {
		
		PhoneInfoManager manager = PhoneInfoManager.getInstance();
		
		while(true) {
			
			PhoneBookMenu.menu();
			
			int choice = manager.input.nextInt();
			
			manager.input.nextLine(); // 앞의 버퍼 클리어
			
			// 메뉴 선택 시 MenuNumInterface의 상수값에 따라 선택됨
			switch (choice) {
			case MenuNumInterface.SAVEINFO :
				manager.insertInfo(choice);
				break;
			case MenuNumInterface.SHOWALLBASICDATA: 
				manager.showAllBasicData();
				break;
			case MenuNumInterface.SEARCHNAMEINFO:
				manager.serchNameInfo();
				break;
			case MenuNumInterface.DELETEINFO:
				manager.deleteInfo();
				break;
			case MenuNumInterface.MODIFYINFO:
				manager.modifyInfo();
				break;
			case MenuNumInterface.EXITSYSTEM:
				System.out.println("=========프로그램을 종료합니다. ========");
				return;
			}
			
		}
			
	}
		
}

