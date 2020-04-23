package ex;

public class Man {
	
	String  name;
	
	Man(){
		
	}
	
	Man(String name){
		this.name = name;
	}

	void tellYourName() {
		System.out.println("제 이름은 " + name + " 입니다.");
		
	}
	
}
