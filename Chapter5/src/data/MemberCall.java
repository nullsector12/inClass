package data;

public class MemberCall {
	
	int iv = 10; // 인스턴스 변수
	
	static int cv = 20; //클래스변수 = 스태틱변수
	
	int iv2 =  cv;
//	static int cv2 = iv; 
	//인스턴스 생성 or 스태틱 설정
	static int cv2 = new MemberCall().iv;

	static void staticMethod( ) {
		// 스태틱 멤버 출력
		System.out.println(cv);
		
		// 인스턴스 멤버 출력
		// System.out.println(iv);
		
		MemberCall mc = new MemberCall();
		System.out.println(mc.iv);
		}

	void instanceMethod() {
		System.out.println(cv);
		System.out.println(iv);
	}
	
	
	
	
	
	
	
}
