package myPhoneBookVer03_SingleTon;

/**
 * 전화번호부 프로젝트
 * https://github.com/nullsector12/inClass (private)
 * 작성자 : 김승연
 * 
 * 수정일자 : 2020. 04. 22
 * 수정내용 : PhoneInfor를 통해 입력된 연락처를 배열에 저장하는 기능 추가, 
 * 						입력된 연락처 정보 카운트와 새로운 객체 저장의 index 활용을 위한 cnt 변수 선언,
 * 						전체 리스트 출력 기능 추가, 
 * 						입력하는 name을 기준으로 해당 name값이 들어있는 배열의 인덱스 번호를 찾고 해당 배열을 출력하는 기능추가,
 * 						 ㄴ 동일한 기능을 사용하여 해당 배열을 삭제하는 기능 추가
 * 						   ㄴ index번호를 반환해주는 기능 추가
 * 
 * 수정일자 : 2020. 04. 23
 * 수정내용 : 입력된 연락처에 대한 외부 클래스의 접근을 막기위해 SingleTon 작업을 함.
 *  					SingleTon = 배열에 저장된 데이터나 다른 기능들이 외부의 접근으로 변하는 것을 막기 위한 것이다.
 * 						
 * 클래스 설명 : 실질적인 기능 메서드를 모아놓은 클래스. 데이터를 저장하고, 저장된 데이터를 사용해 기능이 작동하도록 함.
 * 사용자로부터 입력받은 "데이터에 따라" "객체를 생성"하고 해당 데이터를 배열에 "저장" 하는 기능, 
 * 배열에 저장된 데이터를 인덱스를 통해 "찾아서" "불러오거나" "삭제" 하는 기능. 
 * 지금까지 저장된 배열들을 "모두 불러오는" 기능.
 */
import java.util.Scanner;


public class SavePhoneInfor {
	
	// PhoneInfor를 통해 입력되는 데이터를 배열에 저장하는 배열 qBook 생성
	PhoneInfor[] pBook;
	
	// 입력된 연락처의 정보 개수 ---> 입력된 배열의 요소 개수
	// 1. 참조할 때 반복의 횟수
	// 2. 새로운 객체를 저장할 때 index 로 사용가능
	int cnt;
	Scanner input;

	private SavePhoneInfor() { // 배열이나 변수 초기화를 위한 생성자
		// 배열 초기화
		pBook = new PhoneInfor[100];
		//저장 개수 초기화
		cnt = 0;
		// Scanner 객체 초기화
		input = new Scanner(System.in);
	}
	private static SavePhoneInfor save = new SavePhoneInfor();
	
	public static SavePhoneInfor getInstance() {
		return save;
	}
	
	// 저장 : 이름, 전화번호, 생년 정보를 대상으로 저장
	// 배열에 PhoneInfor 타입의 참조값 저장
	void saveInfo(PhoneInfor info) {
		
		// 배열pBook의 index cnt번에 요소 대입 
		pBook [cnt] = info;
		// 등록된 정보증가, index cnt값 증가 
		cnt++;
	}
	void saveInfo( ) {
		
		// 배열pBook의 index cnt번에 요소 대입 
		pBook [cnt] = createInfor();
		// 등록된 정보증가, index cnt값 증가 
		cnt++;
	}
	
	//전체 리스트 출력
	void showAllData() {

		//전체 데이터 -> 입력된 데이터의 개수 = cnt
		for( int i = 0; i < cnt ; i++) {
			pBook[i].ShowBook();
		}

	}
	
	// 배열에서 이름을 기준으로 검색 후 index값 반환
	int searchIndex(String name) {
		int searchIndex = -1;
		for(int i = 0; i < cnt; i++) {
			if(pBook[i].CheckName(name)) {
				searchIndex = i;
				break;
			}
		}
		return searchIndex;
	}
	
	
	//검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보 출력
	// 배열의 요소(PhoneInfor)의 name 속성 값으로 배열요소찾기
	void serchInfo() {
		
		System.out.println("검색하고자 하는 이름 입력");
		String name = input.nextLine();
		
		int searchIndex = searchIndex(name);

		if(searchIndex < 0) {
			System.out.println("존재하지 않는 주소록입니다.");
		}else {
			pBook[searchIndex].ShowBook();
		}
	}


	// 삭제 : 이름을 기준으로 데이터 찾아서 삭제
	void deleteInfo() {
		
		System.out.println("삭제하고자 하는 이름 입력");
		String name = input.nextLine();
		
		int searchIndex = searchIndex(name);

		// 삭제
		// pBook[2] 를 삭제 시... pBook[2] = null ?  = 가능
		// 데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈공간에 순차적으로 채워줌
		if (searchIndex <0) {
			System.out.println("찾는 이름이 없음");
		}else {
			for(int i = searchIndex; i < cnt-1 ; i++) {
				pBook[i] = pBook[i+1];
			}
			// 저장된 정보의 개수를 -1;
			cnt--; 
			System.out.println("삭제 완료");
		}
		//삭제는 검색한 인덱스부터 저장된 위치까지 왼쪽으로 합
	}
	
	
	// 사용자의 입력데이터로 PhoneInfor 객체를 생성
	PhoneInfor createInfor() {
		
		PhoneInfor info = null;
		
		System.out.println("정보 저장을 위한 데이터 입력 : ");
		
		System.out.println("이름 입력");
		String name = input.nextLine();
		
		 System.out.println("전화번호 입력");
		String phoneNumber = input.nextLine();
		
		System.out.println("생년월일 입력");
		String birthDay = input.nextLine();
		
		// 사용자의 입력 데이터에 따라 인스턴스 생성 방법 구분
		
		if(birthDay == null || birthDay.trim().isEmpty()) {
			info = new PhoneInfor(name, phoneNumber);
		}else {
			info = new PhoneInfor(name, phoneNumber, birthDay);
		}
		
//		System.out.println("프로그램 종료? :  종료는 y 입력, 계속 하려면 n 입력");
//		command = input.nextLine();
//		if("n".equals(command))  // command에 입력되는 문자열이 n 과 같으면 (equals), 프로그램 다시 진행 
//			
//		if (command.equals("y")) { // command에 입력된 문자열이 y와 같으면 프로그램 종료함
//			System.out.println("전화번호 저장 종료");
//			System.exit(0); // System.exit(0) 클래스
//			}

		return info;
	}
	
}
	
		
