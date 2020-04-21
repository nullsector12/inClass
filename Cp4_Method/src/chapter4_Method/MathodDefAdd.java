package chapter4_Method;

public class MathodDefAdd {
	
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		hiEveryone(10, 120.8);
		hiEveryone(20, 178.5);
		hiEveryone(18, 175.5);
		hiEveryone(35, 180.7);
		System.out.println("\n" + "프로그램 종료");
	}

	
	public static void hiEveryone(int age, double height) {
		
		System.out.println("\n" + "좋은 아침입니다.");
		System.out.println("제 나이는 " + age +" 세 입니다.");
		System.out.println("제 키는 " + height + "cm 입니다");
	}

}
