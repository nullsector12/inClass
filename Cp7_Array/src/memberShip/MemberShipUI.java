package memberShip;

public class MemberShipUI {

	public static void main(String[] args) {
		
		// 회원정보 5개를 저장 할 수 있는 배열을 생성
		// Member 타입의 인스턴스의 참조값을 저장하는 메모리 공간
		// = Member m1, m2, m3, m4, m5
		Member[] members = new Member[5];
		
		members [0] = new Member("ㄷㄷㄷㅈ", "TFT", "riot.co.kr"); // Member 타입의 인스턴스 주소
		members [1] = new Member("DUDUDUNGA", "tft", "riot.co.kr");
		members [2] = new Member("승전보", "나만안나와", "암혐");
		members [3] = new Member("ㄷㄷ", "TT", "riot.com");
		members [4] = new Member("ㄷㅈ", "TF", "riot.com");
		
//		members [0].showInfo();
//		members [1].showInfo();
//		members [2].showInfo();
//		members [3].showInfo();
//		members [4].showInfo();
		
		for(int i = 0; i < members.length; i++) {
			System.out.println(members [i]);
		}
		
		Member member = new Member("nullsector", "김승연", "nullsector@gmail.com");
		
		for(int i = 0; i < members.length; i++) {
			System.out.println("================");
			members [i].showInfo();
			
		}System.out.println("================");
		
	
//		System.out.println(member); // member.toString() 호출
	}

}
