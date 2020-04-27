package phoneBookVer4;

import java.util.Scanner;


/**
 * 작성자 : 김승연
 * 작성일시 : 2020. 04. 24
 * 클래스 설명 : PhoneInfo 타입의 정보들을 받아서 저장할 배열 생성. - 2020. 04 .24 구현 완료
 * 전화번호부의 기본 정보 출력 기능 - 2020. 04. 24구현 완료
 * 전화번호부의 상세정보 출력 기능 - 2020. 04. 24구현 완료
 * 입력된 name값을 배열 내에서 찾아 출력해주는 기능 - 2020. 04. 26 구현 완료
 * 입력된 name값을 배열 내에서 찾아 삭제해주는 기능 - 2020. 04. 26구현 완료
 * 
 *  수정 일시 : 2020. 04. 27
 *  수정 내용 : 싱글톤 작업, 정보입력창에서 저장그룹 선택기능 추가
 * 
 */
public class PhoneInfoManager {
	
	private PhoneInfo[] myPhoneBook; // PhoneInfo 타입의 배열 선언
	private int numOfInfo; // 저장된 정보 개수
	private PhoneInfo info = null;
	Scanner input = new Scanner(System.in); // 키보드 입력에 사용할 Scanner 선언

	// 초기화
	PhoneInfoManager(int num) {
		myPhoneBook = new PhoneInfo[num]; // 배열 초기화
		numOfInfo = 0; // 저장 정보 개수 초기화
	}
	
	private static PhoneInfoManager manager = new PhoneInfoManager(50);
	
	public static PhoneInfoManager getInstance() {
		return manager;
	}
	
	void addInfo(PhoneInfo info) {
		
		myPhoneBook[numOfInfo] = info;
		numOfInfo++;
	}
	
	void insertInfo(int choice) {
		

		if(choice == 1) {
			
			System.out.println("정보 저장을 위한 데이터 입력 : ");
			
			System.out.println("===== 이름 입력 =====");
			String name = input.nextLine();
			
			 System.out.println("===== 전화번호 입력 =====");
			String phoneNumber = input.nextLine();
			
			System.out.println("===== 주소 입력 =====");
			String address = input.nextLine();
			System.out.println("===== E-Mail 주소 입력 =====");
			String eMail = input.nextLine();
			
			System.out.println("\n" + " [	그룹 선택	]");
			System.out.println("\n" + "	1. 그룹 미지정 ");
			System.out.println("\n" + "	2. 대학 친구 ");
			System.out.println("\n" + "	3. 회사 동료 ");
			System.out.println("\n" + "	 4. 카페 정보 ");
			System.out.println("\n" + "	5. 가족 정보 ");
			
			int choiceGroup = Integer.parseInt(input.nextLine());
			
			switch (choiceGroup) {
			case 1: 
				info = new PhoneInfo(name, phoneNumber, address, eMail);
				break;
			case 2:
				System.out.println("	[대학 친구 정보 저장]");
				System.out.println("	전공을 입력해주세요. ");
				String major = input.nextLine();
				System.out.println("	학년을 입력해주세요.");
				String grade = input.nextLine();
				info = new Phone_Univ_Info(name, phoneNumber, address, eMail, major, grade);
				break;
				
			case 3:
				System.out.println("	[회사 동료 정보 저장]");
				System.out.println("	회사명을 입력해주세요. ");
				String company = input.nextLine();
				info = new Phone_Company_Info(name, phoneNumber, address, eMail, company);
				break;
	
			case 4:
				System.out.println("	[카페 정보 저장]");
				System.out.println("	카페 이름을 입력해주세요.");
				String cafeName = input.nextLine();
				info = new Phone_Cafe_Info(name, phoneNumber, address, eMail, cafeName);
				break;
				
			case 5:
				System.out.println("	[가족 정보 저장]");
				System.out.println("	가족 관계를 입력해주세요.");
				String relation = input.nextLine();
				info = new Phone_family_info(name, phoneNumber, address, eMail, relation);
				break;
			}
		addInfo(info);
	}
}
				
	// 입력한 name을 배열 안에서 찾은 후 해당하는 인덱스 번호 반환
	int searchInfoIndex(String name) {
		int searchInfoIndex = -1; // 만약 같은 name값이 존재하지 않을경우 반환할 인덱스값
		for(int i = 0; i < numOfInfo; i++) {
			if(myPhoneBook[i].CheckName(name)) {
				searchInfoIndex = i; // 동일한 name값을 찾았을 경우 searchinfoIndex의 값을 i로 변환
				break;
			}
		}
		return searchInfoIndex; // index번호 반환
	}
	
	
	// 검색을 위한 이름을 입력하고 searchInfoIndex에서 반환받은 인덱스 번호에서 해당 정보 출력
	// 만약 반환받은 searchInfoIndex의 값이 0보다 작다면 저장되지 않은것
	void serchNameInfo() {
		System.out.println("검색할 이름을 입력해주세요.");
		String name = input.nextLine();
		int searchInfoIndex = searchInfoIndex(name);
		if(searchInfoIndex < 0) {
			System.out.println("저장되지 않은 이름입니다");
		}else {
			myPhoneBook[searchInfoIndex].showData();
		}
	}
	
	void showAllBasicData() {
		System.out.println("===== 저장된 기본 정보들을 출력합니다 =====");
		for(int i = 0; i < numOfInfo; i++){
			myPhoneBook[i].getBasicInfo();
			System.out.println("------------------------------------");
		}
	}
	
	void deleteInfo() {
		
		System.out.println("삭제하고자 하는 이름을 입력해주세요.");
		String name = input.nextLine();
		int searchInfoIndex = searchInfoIndex(name);
		
		if(searchInfoIndex <0) {
			System.out.println("저장되지 않은 이름입니다.");
		}else {
			for(int i = searchInfoIndex; i < numOfInfo-1; i++) {
				myPhoneBook[i] = myPhoneBook[i+1]; // 저장된 정보 개수 -1
			}
			numOfInfo--;
			System.out.println("정보의 삭제를 완료했습니다."); 
		}
		
	}
	
	
	
	
}
