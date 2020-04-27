package phoneBookVer5;

/**
 * 작성자 : 김승연
 * 작성일시 : 2020. 04. 24
 * 클래스 설명 : 추가적으로 입력되는 정보에 따라 인스턴스를 생성
 * 
 */

public class Phone_Company_Info extends PhoneInfo {
	String company;
	
	public Phone_Company_Info(String name, String phoneNumber, String address, String eMail, String company) {
		super(name, phoneNumber, address, eMail);
		this.company = company;
	}

	@Override
	void showData() {
		super.showData();
		System.out.println("소속 회사명 : " + company);
	}

}
