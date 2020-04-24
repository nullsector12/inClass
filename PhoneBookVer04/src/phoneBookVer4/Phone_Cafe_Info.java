package phoneBookVer4;

public class Phone_Cafe_Info extends PhoneInfo {
	String cafeName;

	public Phone_Cafe_Info(String name, String phoneNumber, String address, String eMail, String cafeName) {
		super(name, phoneNumber, address, eMail);
		this.cafeName = cafeName;
		
	}

	@Override
	void showData() {
		showData();
		System.out.println("가게 이름 : " + cafeName);
		
	}

}
