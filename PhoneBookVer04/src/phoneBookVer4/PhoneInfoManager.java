package phoneBookVer4;

import java.util.Scanner;


/**
 * 작성자 : 김승연
 * 작성일시 : 2020. 04. 24
 * 클래스 내용 ; PhoneInfo 타입의 정보들을 받아서 저장할 배열 생성.
 * 전화번호부의 기본 정보 출력 기능
 * 전화번호부의 상세정보 출력 기능 
 * 입력된 name값을 배열 내에서 찾아 출력해주는 기능
 * 입력된 name값을 배열 내에서 찾아 삭제해주는 기능
 * 
 */
public class PhoneInfoManager {
	
	private PhoneInfo[] myPhoneBook; // PhoneInfo 타입의 배열 선언
	private int numOfInfo; // 저장된 정보 개수
	Scanner input = new Scanner(System.in); // 키보드 입력에 사용할 Scanner 선언

	// 초기화
	public PhoneInfoManager(int num) {
		this.myPhoneBook = new PhoneInfo[num]; // 배열 초기화
		this.numOfInfo = 0; // 저장 정보 개수 초기화
	}
	
	void addInfo(PhoneInfo info) {
		
		this.myPhoneBook[numOfInfo] = info;
		this.numOfInfo++;
	}
	
	void insertInfo(int choice) {

		System.out.println("정보 저장을 위한 데이터 입력 : ");
		
		System.out.println("===== 이름 입력 =====");
		String name = input.nextLine();
		
		 System.out.println("===== 전화번호 입력 =====");
		String phoneNumber = input.nextLine();
		
		System.out.println("===== 주소 입력 =====");
		String address = input.nextLine();
		System.out.println("===== E-Mail 주소 입력 =====");
		String eMail = input.nextLine();
		
		PhoneInfo info = null;
		
		if(choice == 1) {
				System.out.println("[    대학 친구 정보 저장    ]");
				System.out.println("===== 전공을 입력해주세요 =====");
				String major = input.nextLine();
				System.out.println("===== 학년을 입력해주세요 =====");
				String grade = input.nextLine();
				info = new Phone_Univ_Info(name, phoneNumber, address, eMail, major, grade);
				} else if (choice == 2) {
			
				System.out.println("[    회사 동료 정보 저장    ]");
				System.out.println("===== 회사명 입력 =====");
				String company = input.nextLine();
				info = new Phone_Company_Info(name, phoneNumber, address, eMail, company);
				} else if ( choice == 3) {
				
				System.out.println("[    카페 정보 저장    ]");
				System.out.println("===== 가게 이름 입력 =====");
				String cafeName = input.nextLine();
				info = new Phone_Cafe_Info(name, phoneNumber, address, eMail, cafeName);
				} else {
	
				System.out.println("[    가족 정보 저장    ]");
				System.out.println("===== 가족 관계 저장 =====");
				String relation = input.nextLine();
				info = new Phone_family_info(name, phoneNumber, address, eMail, relation);
				} 
	
		addInfo(info);
		
	}
				
	void showAllBasicData() {
		System.out.println("===== 저장된 기본 정보들을 출력합니다 =====");
		for(int i = 0; i < numOfInfo; i++){
			myPhoneBook[i].getBasicInfo();
			System.out.println("------------------------------------");
		}
	}
}
