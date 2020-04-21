package Exam5;

public class Triangle{
	
//	밑변과 높이 정보를 지정할 수 있는 Triangle 클래스를 정의하자.
//	끝으로 밑변과 높이 정보를 변경시킬 수 있는 메서드와 
//	삼각형의 넓이를 계산해서 반환하는 메서드도 함께 정의하자.
	// under*height/2 = 넓이
	
	int under;
	int height;
	
	
// 디폴트 생성자
	Triangle(){
		
	}
// 인스턴스 메서드
	Triangle(int num1, int num2){
		under = num1;
		height = num2;
	}
// 넓이 계산 후 반환 메서드
	int TriWide(int num){
		num = ((under*height)/2)/100;
		return num;
	}
}



