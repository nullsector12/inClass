package scm;

public class Buyer {
	
	int money; // Buyer의 보유 금액
	int bounsPoint; // Buyer의 보유 포인트
	
	Buyer(){
		this.money = 1000;
		this.bounsPoint = 0;	
	}
	
	void buy(Product p) {
		
		// 구매하고자 하는 상품의 금액과 Buyer의 보유 금액을 비교해서 구매 여부 처리
		if (money < p.price) {
			System.out.println("잔액이 부족해서 구매할 수 없습니다 !!");
			return;
		}
		
		// 구매 처리
		this.money -= p.price; // 보유한 금액에서 제품의 금액 차감
		this.bounsPoint += p.bounsPoint; // 보유 포인트의 증가
		System.out.println(p + " 구매 완료");
		
	}
	
	
}