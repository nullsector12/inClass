package ex;

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
