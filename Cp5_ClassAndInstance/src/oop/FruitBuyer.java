package oop;

public class FruitBuyer {
	/* 속성 : 변수
	 * 현재 가진 돈
	 * 현재 가진 사과
	 * */
	
	int myMoney = 10000; //최초 구매자가 가진 돈
	int numOfApple = 0; // 최초 구매자가 가지고 있는 사과의 수
	
	/* 구매기능 : 메서드
	 * 1. 셀러 찾기 ,  받기
	 * 2. 지출 할 돈 정의
	 * 3. 셀러에게 돈을 주고 판매 요청 -> 사과의 개수
	 * 4. 사과의 개수를 받은 만큼 현재 내 사과의 개수를 증가 시킨다.
	 * 5. 지출한 돈은 나의 돈에서 차감한다.
	 *  반환할 값이 없다 = void
	 * */ 
	
	//참조변수 : 객체의 주소값을 저장하는 변수 ▼ 판매자에게 사과를 사는 기능
	public void buyApple ( FruitSeller seller, int money) {
		
		//                                      ▼ 구매한 사과의 개수
		numOfApple += seller.saleApple(money); //  <-구매 후 구매자의 사과 소지수
		myMoney -= money; // 구매 후 구매자의 남은 돈
	}

	public void showBuyResult() {
		
		System.out.println("나의 현재 잔액 : " + myMoney);
		System.out.println("사과 구매 개수 : " +numOfApple);
	}
}
