package scm;



// 상품 객체들의 상위클래스
public class Product {
	
	// 생성자를 통해 상수 초기화 가능
	
	final	int price; // 제품의 가격
	final int bounsPoint; //  제품의 포인트
	
	Product(int price){
		this.price = price;
		this.bounsPoint = this.price/10;
	}
	
}
