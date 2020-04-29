package phoneBookVer5;

import java.util.Scanner;

import excepClass.BadNumberException;


/**
 * 작성자 : 김승연
 * 작성일시 : 2020. 04. 24
 * 클래스 설명 : PhoneInfo 타입의 정보들을 받아서 저장할 배열 생성. - 2020. 04 .24 구현 완료
 * 전화번호부의 기본 정보 출력 기능 - 2020. 04. 24구현 완료
 * 전화번호부의 상세정보 출력 기능 - 2020. 04. 24구현 완료
 * 입력된 name값을 배열 내에서 찾아 출력해주는 기능 - 2020. 04. 26 구현 완료
 * 입력된 name값을 배열 내에서 찾아 삭제해주는 기능 - 2020. 04. 26 구현 완료
 * 
 *  수정 일시 : 2020. 04. 27
 *  수정 내용 : 싱글톤 작업, 정보입력창에서 저장그룹 선택기능 추가, 이름 검색후 내용수정 기능 추가
 *  입력된 name값을 배열 내에서 찾아 해당 배열 내의 내용을 수정하고 다시 저장하는 기능 - 2020. 04. 27 구현 완료
 * 
 *  수정 일시 : 2020. 04. 28
 *  수정 내용 : PhoneInfo의 추상클래스화로 인해 PhoneInfo 인스턴스 생성과 출력 삭제
 *  
 *  수정 일시 : 2020. 04. 29
 *  수정 내용 : 메뉴선택의 예외처리 추가, 검색/삭제/변경 기능의 예외처리 추가
 *  
 *  예외처리 추가 수정 해보기
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
	
	// 싱글톤 작업
	private static PhoneInfoManager manager = new PhoneInfoManager(50);
	
	public static PhoneInfoManager getInstance() {
		return manager;
	}
	// 
	
	void addInfo(PhoneInfo info) {
		
		myPhoneBook[numOfInfo] = info;
		numOfInfo++;
	}
	
	// 입력받은 정보를 토대로 인스턴스 생성
	void insertInfo() {
	
		
				System.out.println("기본 데이터 입력 : ");
				
				System.out.println("===== 이름 입력 =====");
				String name = input.nextLine();
				
				System.out.println("===== 전화번호 입력 =====");
				String phoneNumber = input.nextLine();
				
				System.out.println("===== 주소 입력 =====");
				String address = input.nextLine();
				System.out.println("===== E-Mail 주소 입력 =====");
				String eMail = input.nextLine();

				while(true) {
					int select = 0;
					System.out.println("\n" + " [	그룹 선택	]");
					System.out.println("\n" + "	1. 대학 친구 ");
					System.out.println("\n" + "	2. 회사 동료 ");
					System.out.println("\n" + "	3. 카페 정보 ");
					System.out.println("\n" + "	4. 가족 정보 ");
				
					try {
						select = input.nextInt();
						// 메뉴의 숫자범위 내에서 벗어난 입력을 할 경우 예외처리
						if( !(select >= MenuNumInterface.SELECTUNIV && select <= MenuNumInterface.SELECTFAMILY) ) {
							BadNumberException e = new BadNumberException("잘못된 그룹 선택");
							throw e;
						}
						// 정수가 아닌 다른 형태의 입력이 있을 경우 예외처리
					}catch (NumberFormatException e) {
						System.out.println("잘못된 입력입니다.");
						System.out.println("그룹을 다시 입력해주세요.");
						continue;

					}catch (BadNumberException e) {
						System.out.println("잘못된 입력입니다.");
						System.out.println("그룹을 다시 입력해주세요.");
						continue;
						// 미처 예상하지 못한 예외들을 처리
					} catch (Exception e) {
						System.out.println("잘못된 입력입니다.");
						System.out.println("그룹을 다시 입력해주세요.");
						continue;
						// 정수타입 입력으로 인한 버퍼 플러쉬를 위한 finally
					}finally {
						input.nextLine();
					}
					
					switch (select) {
					case MenuNumInterface.SELECTUNIV :
						System.out.println("	[대학 친구 정보 저장]");
						System.out.println("	전공을 입력해주세요. ");
						String major = input.nextLine();
						System.out.println("	학년을 입력해주세요.");
						String grade = input.nextLine();
						info = new Phone_Univ_Info(name, phoneNumber, address, eMail, major, grade);
						break;
						
					case MenuNumInterface.SELECTCOMPANY :
						System.out.println("	[회사 동료 정보 저장]");
						System.out.println("	회사명을 입력해주세요. ");
						String company = input.nextLine();
						info = new Phone_Company_Info(name, phoneNumber, address, eMail, company);
						break;
			
					case MenuNumInterface.SELECTCAFE :
						System.out.println("	[카페 정보 저장]");
						System.out.println("	카페 이름을 입력해주세요.");
						String cafeName = input.nextLine();
						info = new Phone_Cafe_Info(name, phoneNumber, address, eMail, cafeName);
						break;
						
					case MenuNumInterface.SELECTFAMILY :
						System.out.println("	[가족 정보 저장]");
						System.out.println("	가족 관계를 입력해주세요.");
						String relation = input.nextLine();
						info = new Phone_family_info(name, phoneNumber, address, eMail, relation);
						break;
					}
					addInfo(info);
					// 정보를 입력한 후 return을 통해 main으로 돌아간다.
					return;
			}
	}
	
		
	// 입력한 name을 배열 안에서 찾은 후 해당하는 인덱스 번호 반환
	int searchInfoIndex(String name) {
		int searchInfoIndex = -1; // 만약 같은 name값이 존재하지 않을경우 반환할 인덱스값
		for(int i = 0; i < numOfInfo; i++) {
			if(myPhoneBook[i].CheckName(name)) {
				searchInfoIndex = i; // 동일한 name값을 찾았을 경우 i값을 searchInfoIndex 값으로 삽입
				break;
			}
		}
		return searchInfoIndex; // index번호 반환
	}
	
	
	// 검색을 위한 이름을 입력하고 searchInfoIndex에서 반환받은 인덱스 번호에서 해당 정보 출력
	// 만약 반환받은 searchInfoIndex의 값이 0보다 작다면 저장되지 않은것
	void serchNameInfo() {
		System.out.println("검색할 이름을 입력해주세요.");
		int searchInfoIndex = 0;
	while(true) {
		try {
			String name = input.nextLine();
			searchInfoIndex = searchInfoIndex(name);
			if(!(myPhoneBook[searchInfoIndex].CheckName(name)));
			
	}catch(ArrayIndexOutOfBoundsException e){
		System.out.println("저장되지 않은 이름입니다.");
		System.out.println("이름을 다시 입력해주세요.");
		continue;
		
	}catch( Exception e) {
		System.out.println("예기치 않은 오류입니다.");
		System.out.println("이름을 다시 입력해주세요.");
		continue;
		}
		break;
	}
	myPhoneBook[searchInfoIndex].showData();
	}
	
	// 저장된 모든 배열의 기본정보들 출력
	void showAllBasicData() {
		System.out.println("===== 저장된 기본 정보들을 출력합니다 =====");
		for(int i = 0; i < numOfInfo; i++){
			myPhoneBook[i].getBasicInfo();
			System.out.println("------------------------------------");
		}
	}
	
	// 이름 검색 후 정보 삭제 기능
	void deleteInfo() {
		
		System.out.println("삭제하고자 하는 이름을 입력해주세요.");
		int searchInfoIndex = 0;
		while(true) {
			try {
				String name = input.nextLine();
				searchInfoIndex = searchInfoIndex(name);
				if(!(myPhoneBook[searchInfoIndex].CheckName(name)));
				
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("저장되지 않은 이름입니다.");
				System.out.println("이름을 다시 입력해주세요.");
				continue;
			
			}catch( Exception e) {
				System.out.println("예기치 않은 오류입니다.");
				System.out.println("이름을 다시 입력해주세요.");
				continue;
			}
				break;
		}
			for(int i = searchInfoIndex; i < numOfInfo-1; i++) {
				myPhoneBook[i] = myPhoneBook[i+1]; // 저장된 정보 개수 -1
			}
			numOfInfo--;
			System.out.println("정보의 삭제를 완료했습니다."); 
		}
		
	
	// 이름 검색 후 정보 수정 기능
	void modifyInfo() {
		
		System.out.println("검색할 이름을 입력해주세요.");
		int searchInfoIndex = 0;
	while(true) {
		try {
			String name = input.nextLine();
			searchInfoIndex = searchInfoIndex(name);
			if(!(myPhoneBook[searchInfoIndex].CheckName(name)));
			
	}catch(ArrayIndexOutOfBoundsException e){
		System.out.println("저장되지 않은 이름입니다.");
		System.out.println("이름을 다시 입력해주세요.");
		continue;
		
	}catch( Exception e) {
		System.out.println("예기치 않은 오류입니다.");
		System.out.println("이름을 다시 입력해주세요.");
		continue;
		}
		break;
	}
				String modiName = myPhoneBook[searchInfoIndex].getName();
				System.out.println("수정할 데이터 입력을 시작합니다.");
				System.out.println("이름은 " + modiName + " 입니다.");
				System.out.println("수정할 전화번호를 입력하세요.");
				String phoneNumber = input.nextLine();
				System.out.println("수정할 주소를 입력하세요.");
				String address = input.nextLine();
				System.out.println("수정할 이메일을 입력하세요.");
				String eMail = input.nextLine();
				
				if(myPhoneBook[searchInfoIndex] instanceof Phone_Univ_Info) {
					
					System.out.println("수정할 전공을 입력하세요.");
					String major = input.nextLine();
					System.out.println("수정할 학년을 입력하세요.");
					String grade = input.nextLine();
					myPhoneBook[searchInfoIndex] = new Phone_Univ_Info(modiName, phoneNumber, address, eMail, major, grade);
					
					} else if (myPhoneBook[searchInfoIndex] instanceof Phone_Company_Info) {
						System.out.println("수정할 회사명을 입력하세요.");
						String company = input.nextLine();
						myPhoneBook[searchInfoIndex] = new Phone_Company_Info(modiName, phoneNumber, address, eMail, company);
						
					} else if (myPhoneBook[searchInfoIndex] instanceof Phone_Cafe_Info) {
						System.out.println("수정할 카페명을 입력하세요.");
						String cafeName = input.nextLine();
						myPhoneBook[searchInfoIndex] = new Phone_Cafe_Info(modiName, phoneNumber, address, eMail, cafeName);
						
					} else if (myPhoneBook[searchInfoIndex] instanceof Phone_family_info) {
						System.out.println("수정할 가족관계를 입력하세요.");
						String relation = input.nextLine();
						myPhoneBook[searchInfoIndex] = new Phone_family_info(modiName, phoneNumber, address, eMail, relation) ;
						
					}
				System.out.println("- 수정 메뉴 종료 -");
			}
}


