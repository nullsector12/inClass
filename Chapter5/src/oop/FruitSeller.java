package oop;

public class FruitSeller { // 사과를 파는 사람
	
	/* 속성 -> 변수로 표현 
	 		사과의 개수 
	 		수입
	 		사과의 가격
	 */
	final int APPLE_PRICE = 1000; //사과의 가격, 변하면 안되는 값이므로 상수처리
	int numOfApple = 20; // 최초 가게에 있는 사과의 개수
	int myMoney = 0; //최초 판매자의 수익

	
	/* 기능 -> 메서드
	 * 1. 돈을 받는다. --> 매개변수 int money
	 * 2. 받은 돈의 사과의 개수를 구한다.
	 * 3. 나의 사과 개수에서 반환해야하는 사과의 개수를 빼준다.
	 * 4. 받은 금액은 나의 수입으로 더해준다.
	 * 사과의 개수를 반환한다. --> 반환데이터 int return 사과개수
	 * */
	public int saleApple(int money) { //메서드의 선언은 반환타입(int 등) 변수명
		int num = money/APPLE_PRICE; //판 사과의 개수
		numOfApple -=num; // 가게에 남은 사과
		myMoney += money; // 판매자의 수익
		return num; //판 사과의 개수를 반환
	}
	
	public void showSaleResult() {
		System.out.println("가게에 남은 사과 : " + numOfApple);
		System.out.println("판매자의 사과 판매 수익 : " + myMoney);
	}
}
