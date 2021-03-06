package PBook_Exception;

/**
 * 작성자 : 김승연
 * 작성 일시 : 2020. 04. 24
 * 프로젝트명 : PhoneBook ver0.4
 * 클래스 설명 : 정보를 입력받아서 인스턴스를 생성할 생성자 정의
 *  
 * 수정 일시 : 2020. 04. 27
 * 수정 내용 : 입력받은 String 값의 비교 후 true or false 값을 반환하는 메서드 추가
 * 							싱글톤 처리 추가
 * 
 * 수정 일시 : 2020. 04. 28
 * 수정 내용 : 인터페이스 구현 후 추상클래스화 하여 PhoneInfo 인스턴스의 생성을 막음
 * 
 * 
 */
public abstract class PhoneInfo implements OverrideInterface {
	
	private String name; 
	private String phoneNumber;
	private String address;
	private String eMail;
	
	// 기본 공통 정보 생성자
	PhoneInfo(String name, String phoneNumber, String address, String eMail) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.eMail = eMail;
	}

	void getBasicInfo() {
		System.out.println("이름 : " + this.getName());
		System.out.println("전화번호 : " + this.phoneNumber);
		System.out.println("주소 : " + this.address);
		System.out.println("E-Mail 주소 : " + this.eMail);
	}
	
	//  일반 클래스 당시 상속 목적의 오버라이딩을 위한 메서드
//	void showData() {
//	}
	
	boolean CheckName(String name) {
		return this.getName().equals(name);
	}

	public String getName() {
		return name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}
	
}
