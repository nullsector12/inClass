package ex;

public class BusinessMan extends Man {
	
	String company;
	String position;
	
	
	// 조상 클래스의 생성자가 있다면 자손 클래스의 생성자에서
	// 값을 받아 조상 클래스의 생성자를 호출해서 초기화.
	BusinessMan( String name, String company, String position){
		super(name);
		this.company = company;
		this.position = position;
	}
	
	void tellYourInfo() {
//		super.tellYourName();
		tellYourName();
		System.out.println("제 직장은 " + company + " 입니다.");
		System.out.println("제 직급은 " + position + " 입니다.");
		
	}
	BusinessMan(){
		super();
	}

}
