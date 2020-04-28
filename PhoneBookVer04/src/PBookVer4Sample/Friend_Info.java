package PBookVer4Sample;

// 친구 정보 입력받아서 인스턴스 생성하는 생성자 == PhoneInfor

public abstract class Friend_Info {
	
	String name; // 친구의 이름
	String phoneNumber; // 친구의 전화번호
	String address; // 친구의 주소
	
	// 생성자
	Friend_Info (String name, String phoneNumber, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	void showBasicInfo() {
		System.out.println("이름 : " + this.name);
		System.out.println("전화번호 : "+this.phoneNumber);
		System.out.println("주소 : "+this.address);

	}
	
	// 상속의 목적으로 오버라이딩 할 메서드
	// 기본 데이터와 하위 클래스의 데이터를 출력하도록 오버라이딩
//	void showDate() {
//		
//	}
	
	// 추상 메서드 생성
	abstract void showData() ;

	void showDate() {
		// TODO Auto-generated method stub
		
	}

}
