package PBook_Exception;

public class Phone_Cafe_Info extends PhoneInfo {
	String cafeName;

	public Phone_Cafe_Info(String name, String phoneNumber, String address, String eMail, String cafeName) {
		super(name, phoneNumber, address, eMail);
		this.cafeName = cafeName;
		
	}

	@Override
	public void showData() {
		getBasicInfo();
		System.out.println("카페 이름 : " + cafeName);
		
	}

}
