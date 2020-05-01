package PBookVer4Sample;

import java.util.ArrayList;
import java.util.Scanner;

// Friend 타입의 정보를 저장할 배열을 가짐. == SavePhoneInfor
// c친구정보의 기본 정보 출력 기능
// 친구정보 상세정보 출력 기능


public class Friend_Info_Handler {
	
	public ArrayList<Friend_Info> myFriends; // Friend_Info 타입의 배열 선언
	// 저장된 친구의 정보 개수
	Scanner input = new Scanner(System.in);
	
	
	// 초기화 : 저장공간 (사이즈) 크기를 받아서 배열 생성
	public Friend_Info_Handler() {
		myFriends = new ArrayList<Friend_Info>();
		
	}

	// 친구정보를 저장하는 기능
	// 1. 배열에 저장하는 기능
	// 2. 사용자에게 데이터를 받아 사용자 요청에 맞는 인스턴스 생성
	
	// 1. 배열 저장 기능
	void addFriendInfo(Friend_Info friend) { // == SaveInfo
		
		//배열에 저장
		this.myFriends.add(friend);
	}
	
	// 2. 사용자에게 데이터를 받아 사용자 요청에 맞는 인스턴스 생성
	// HighFriend / UnivFriend
	void addFriend(int choice) {
		
		// 기본정보 받기
		System.out.println("===== 이름을 입력해주세요 =====");
		String name = input.nextLine();
		System.out.println("===== 전화번호를 입력해주세요 =====");
		String phoneNumber = input.nextLine();
		System.out.println("===== 주소를 입력해주세요 =====");
		String address = input.nextLine();
		
		Friend_Info friend = null;
		
		// 1일 때 정보 받기
		if (choice == 1) {
			System.out.println("===== 직업을 입력해주세요 =====");
			String work = input.nextLine();
			
			// HighFriend 인스턴스 생성
			friend = new HighFriends(name, phoneNumber, address, work);
		}else {// 2일 때 정보 받기
			System.out.println("===== 전공을 입력해주세요 =====");
			String major = input.nextLine();
			System.out.println("===== 학년을 숫자로 입력해주세요 =====");
			String grade = input.nextLine();
			// Integer.parseInt(grade);  String을 int로 변환하여 반환해주는 클래스

			
			//UnivFriend 인스턴스 생성
			friend = new UnivFriends(name, phoneNumber, address, major, grade);
		}
		// addFriendInfo 호출
		addFriendInfo(friend);
	}
	
	// 친구정보 기본 정보 출력 기능
	void showAllSimpleData() {
		System.out.println(" ======== 친구의 기본 정보를 출력합니다 ======== ");
		for(int i = 0; i < myFriends.size(); i++) {
			myFriends.get(i).showBasicInfo();
			System.out.println("----------------------------------");
		
		}
	}
	// 친구 상세정보 출력 기능
	void showAllData() {
		System.out.println(" ======== 친구의 모든 정보를 출력합니다 ======== ");
		for(int i = 0; i < myFriends.size(); i++) {
			myFriends.get(i).showDate();
			System.out.println("---------------------------------");
		
		}
		
	}
	
}
