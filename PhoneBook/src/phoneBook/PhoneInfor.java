package phoneBook;

/*
 * 전화번호부 프로젝트
 * https://github.com/nullsector12/inClass (private)
 * 작성자 : 김승연
 * 수정일자 : 2020. 04. 22
 * 수정내용 : 변수 정보 은닉, 잘못된 초기화 생성자 변환
 * 						전달받은 name값과 문자열 비교 후 boolean타입 반환기능 메서드 추가
 * 
 */
import java.util.Scanner;

public class PhoneInfor {
	Scanner input = new Scanner(System.in);
	// static  ->변수의 직접 참조를 막기위해 private로 정보은닉
	private String name; 
	private String phoneNumber;
	private String birthDay;
	
	PhoneInfor(){} // default 메서드 생성
	
	//초기화를 위한 생성자1
	PhoneInfor (String name, String phoneNumber, String birthDay){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthDay = birthDay;
	}
	
	//초기화를 위한 생성자2
	PhoneInfor (String name, String phoneNumber){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthDay = "입력값이 없습니다";
	}
	
	// 저장된 값 출력
	void ShowBook(){
		System.out.println("------------------------------------------");
		System.out.println("이름 : " + this.name);
		System.out.println("전화번호 : " + this.phoneNumber);
		System.out.println("생년월일 : " + this.birthDay);
		
		}
	

//name 속성값과 전달받은 문자열을 비교해서 결과 반환
boolean CheckName(String name) {
	return this.name.equals(name);
	}

}