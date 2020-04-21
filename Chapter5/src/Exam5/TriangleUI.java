package Exam5;

public class TriangleUI {
	
	public static void main(String[] args) {
		
		
		// 인스턴스 메서드
		Triangle samgak1 = new Triangle(50, 100);
		
		System.out.println("높이는 : " + samgak1.height + "cm");
		System.out.println("밑변의 길이는 : " + samgak1.under + "cm");
		System.out.println("넓이는 : " + samgak1.TriWide(0) + "㎡");
		System.out.println();
		
		
		// 디폴트 생성자
		Triangle samgak2 = new Triangle();
		samgak2.under = 50;
		samgak2.height = 100;
		
		System.out.println("높이는 : " + samgak2.height + "cm");
		System.out.println("밑변의 길이는 : " + samgak2.under + "cm");
		System.out.println("넓이는 : " + samgak2.TriWide(0) + "㎡");
	} 


}
