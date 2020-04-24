package PBookVer4Sample;

// == PhoneInfor에서 추가정보를 통해 인스턴스를 생성하는 생성자

public class HighFriends extends Friend_Info{
	
	String work; // 친구의 직업

	public HighFriends (String name, String phoneNumber, String address, String work) {
		super(name, phoneNumber, address);
		this.work = work;
	}

	@Override
	void showDate() {
		showBasicInfo();
		System.out.println("직업 :  " + work);

	}
	
}
