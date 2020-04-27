package phoneBookVer5;

public class Phone_family_info extends PhoneInfo {
	
	String relation;

	public Phone_family_info(String name, String phoneNumber, String address, String eMail, String relation) {
		super(name, phoneNumber, address, eMail);
		this.relation = relation;
	}

	@Override
	void showData() {
		getBasicInfo();
		System.out.println("나와의 가족 관계 : " + relation);
	}

}
