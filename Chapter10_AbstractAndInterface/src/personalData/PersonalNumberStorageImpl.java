package personalData;

//
/**
 * 작성자 : 김승연
 * 작성 일시 : 2020. 04. 27
 * 	인터페이스의 구현 : 인터페이스에 정의된 추상메서드를 완성하는 것.
 * 이 PersonalNumberStorageImpl 클래스는 PersonalNum 인터페이스를 구현( 몸통을 만듦 {} )했다.
 * == 추상클래스 완성과 비슷함. (추상 클래스는 상속을 받음)
 *  일부만 구현하는 경우, 클래스 앞에 abstract를 붙여야함. 
 *
 *
 *
 *
 */

public class PersonalNumberStorageImpl implements PersonalNum{
	
	
	PersonalNumInfo[] perArr;
	int numOfPerInfo;

	PersonalNumberStorageImpl (int num){
		perArr = new PersonalNumInfo[num];
		numOfPerInfo = 0;
	}
	
	public void addPersonalInfo(String perNum, String name) {
		perArr[numOfPerInfo] = new PersonalNumInfo(name, perNum);
		numOfPerInfo++;
	}
	public String searchName(String perNum) {
		for(int i= 0; i < numOfPerInfo; i++) {
			if(perArr[i].getNumber().equals(perNum)) {
				return perArr[i].getName();
				}
		}
		return null;
	}
	
}
