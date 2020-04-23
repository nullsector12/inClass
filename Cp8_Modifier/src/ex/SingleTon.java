package ex;

/**
 * 작성자 : 김승연
 * 싱글톤 작업은 쉽게 생각하면 기능들만 있는 클래스를 하나의 공유된 객체로 묶어주고 
 * 해당 참조값을 반환 (return) 해주는 public static 메서드(인스턴스)를 생성해준다. 
 * 반환 메서드는 외부에서 사용할 수 있도록 public static 선언을 하고
 * 변수 등을 선언해주는 생성자의 접근제어는 private화 시켜 클래스 내부에서만 사용되고 외부 클래스에선 접근할 수 없도록한다. 
 */
public class SingleTon {
	
	//1. 생성자의 접근제어지시자 : private -> 인스턴스 생성 불가
	// 일단 막고
	private SingleTon() {}
	
	//2. 공유할 객체를 생성
	// 내부적으로 사용될 인스턴스 생성 (static), 밖에서 바뀌지 않게 private
	private static SingleTon s = new SingleTon();
	
	//3. 참조값을 반환하는 메서드 생성
	// 외부에서 사용될 수 있도록 반환해줄 public static 인스턴스 생성
	public static SingleTon getInstance() {
		return s;
	}
	
	public void print() {
		System.out.println("SingleTon !!");
	}
	
	
}
