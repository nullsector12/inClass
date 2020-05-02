package personalData;

/**
 * 작성자 : 김승연
 *	작성일시 : 2020. 0.4 27
 * 클래스 설명 : 인터페이스 연습
 * 
 * 인터페이스 : 추상 메서드의 집합이며 구현된 것이 전혀없는 설계도. 껍데기(모든 멤버가 public)
 * 	인터페이스는 항상 상수이고 public 이고 추상메서드이기에 public static / public abstract가 생략 가능
 *  인터페이스는 Object가 최고 조상이 아니고 다중 상속이 가능 = 추상메서드 집합이기 때문에 충돌문제가 없음
 *
 *	추상클래스 v.s. 인터페이스
 * 추상클래스는 변수를 가질 수 있다. 결국 추상 클래스는 일반 클래스에 추상 메서드가 있을 뿐이다.
 * 인터페이스는 변수나 생성자, 인스턴스 메서드 등을 가질 수 없다.
 * 
 */
public interface PersonalNum {
	
	void addPersonalInfo(String perNum, String name);
	String searchName(String perNum);

}
