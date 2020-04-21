package memberShip;


// 회원정보를 저장하기 위한 클래스 생성
public class Member {
	
	String memberID;
	String memberName;
	String memberEmail;
	
	// 생성자 : 이름은 클래스명으로
	
	Member(String memberID, String memberName, String memberEmail){
		this.memberID = memberID;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		
	}
	void showInfo() {
		System.out.println("아이디 : " + this.memberID);
		System.out.println("이름 : " + this.memberName);
		System.out.println( "이메일 : " + this.memberEmail);
	}
	@Override
	public String toString() {
		return "Member [memberID=" + memberID + ", memberName=" + memberName + ", memberEmail=" + memberEmail + "]";
	}

}
