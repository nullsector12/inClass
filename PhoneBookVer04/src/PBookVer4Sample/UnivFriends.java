package PBookVer4Sample;

// == PhoneInfor에서 추가정보를 통해 인스턴스를 생성하는 생성자 (2)

public class UnivFriends extends Friend_Info {

	String major;
	int grade; 
	
	public UnivFriends(String name, String phoneNumber, String address, String major, int grade) {
		super(name, phoneNumber, address);
		this.major = major;
		this.grade = grade;
	}

	@Override
	void showDate() {
		showBasicInfo();
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + grade);
	}

}
