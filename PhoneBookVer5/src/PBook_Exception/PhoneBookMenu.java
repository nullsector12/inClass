package PBook_Exception;

/**
 * 작성자 :  김승연
 * 작성 일시: 2020. 04. 27
 * 클래스 설명 : main메서드에서 메뉴 출력 기능만을 분리, 
 *
 */
public class PhoneBookMenu {
	
	static void menu() {
		
	System.out.println("=====================");
	System.out.println("		[	메뉴 입력	]");
	System.out.println(" "+MenuNumInterface.SAVEINFO+". 전화번호부 정보 저장");
	System.out.println(" "+MenuNumInterface.SHOWALLBASICDATA+". 기본정보 전체 검색");
	System.out.println(" "+MenuNumInterface.SEARCHNAMEINFO+". 이름 검색");
	System.out.println(" "+MenuNumInterface.DELETEINFO+". 저장 정보 삭제");
	System.out.println(" "+MenuNumInterface.MODIFYINFO+". 저장 정보 수정");
	System.out.println(" "+MenuNumInterface.EXITSYSTEM+". 프로그램 종료");
	System.out.println("=====================");
	}
}
