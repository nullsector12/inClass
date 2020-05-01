package PBookVer4Sample;

public class FriendMain {
	
	public static void main(String[] args) {
		
		Friend_Info_Handler controll = new Friend_Info_Handler();
		
		while (true) {
			
			System.out.println("================");
			System.out.println("메뉴 입력");
			System.out.println("1.고교 친구 저장");
			System.out.println("2.대학 친구 저장");
			System.out.println("3. 저장된 기본 정보 출력");
			System.out.println("4. 저장된 세부 정보 출력");
			System.out.println("5. 프로그램 종료");
			System.out.println("================");
			
			int choice = controll.input.nextInt(); 
			
			controll.input.nextLine(); // 앞의 버퍼 클리어
			
			switch (choice) {
			case 1: case 2:
				controll.addFriend(choice);
				break;
			case 3:
				controll.showAllSimpleData();
				break;
			case 4:
				controll.showAllData();
				break;
			case 5:
				System.out.println("=========프로그램을 종료합니다. ========");
				return;
			}
		}
		
	}

}
