package oop;

public class FruitUI {
	
	public static void main(String[] args) {
	
		
		// ▼ 셀러 생성 : 인스턴스 화
	FruitSeller seller= new FruitSeller(); // <- 객체 생성, 메모리에 변수와 위치 저장
		//  ▼ 구매자 생성 : 인스턴스 화
	FruitBuyer buyer = new FruitBuyer();
	
		// ▼ 구매자가 사과를 구매
	buyer.buyApple(seller, 5000);
	

	System.out.println("과일 판매자의 현재 상황");
	seller.showSaleResult();
	
	System.out.println("\n" + "과일 구매자의 현재 상황");
	buyer.showBuyResult();
	
	}
}
