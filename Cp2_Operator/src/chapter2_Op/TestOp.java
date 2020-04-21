package chapter2_Op;

public class TestOp {

	public static void main(String[] args) {
		/*문제1
		 * int형 변수 num1, num2, num3 각각 10,20,30 초기화
		 * num1 = num2 = num3; 문장 실행 시 각 변수엔 어떤 값이 저장되는가
		 */
		
		//num1 = 10, num2 = 20, num3 = 30의 정수로 초기화
		int num1 = 10, num2 =20, num3 = 30;
		
		/* 대입연산자인 = 은 우선순위가 가장 낮으며 연산방향이 
		* 뒤에서 부터 앞으로 간다
		* 식의 맨 뒤인 num3부터 시작하기 때문에 num3의 값인 30 대입  
		* 그 앞의 num2 = num3의 식은 num3의 값인 30이 num2로 대입되므로 30이 되고
		* num1은 30이 된 num2의 값이 대입되어 num1도 30이 된다.
		* 따라서 출력 값은 num1, num2, num3 모두 30이 나올 것이다.
		*/ 
		num1=num2=num3;
		
		// 확인 
		System.out.print("num1의 값은 : " + num1 + "\t"+ 
				"num2의 값은 : " + num2  + "\t"+"num3의 값은 : " + num3);
		//확인 완료!
	}

}
