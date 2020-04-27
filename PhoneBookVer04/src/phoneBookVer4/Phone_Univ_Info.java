package phoneBookVer4;

/**
 * 작성자 : 김승연
 * 작성일시 : 2020. 04. 24
 * 클래스 설명 : 추가적으로 입력되는 정보에 따라 인스턴스를 생성
 *
 */
public class Phone_Univ_Info extends PhoneInfo {
	String major;
	String grade;

	public Phone_Univ_Info(String name, String phoneNumber, String address, String eMail, String major, String grade) {
		super(name, phoneNumber, address, eMail);
		this.major = major;
		this.grade = grade;
	}

	@Override
	void showData() {
		getBasicInfo();
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + grade);
	}

}
