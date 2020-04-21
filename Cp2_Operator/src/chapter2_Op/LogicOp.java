package chapter2_Op;

public class LogicOp {

	public static void main(String[] args) {
		int num1 = 20, num2 = 60;
		
		boolean result1 = num1 == 20 && num2 == 30;
		boolean result2 = num1 <= 20 || num2 >= 50;
		
		System.out.println(result1);
		System.out.println(result2);
		
		if(!(num1==num2))
			System.out.println("num1과 num2는 같지 않다.");
		else
			System.out.println("num1과 num2는 같다.");

		// 성인 여성 중 기혼자에게만 메시지를 출력합니다.
		int age = 30;
		String w = "여성";
		boolean merried = true;
		
		if (age >= 20 && w == "여성" && merried == true) {
			System.out.println( "성인, 여성, 기혼자 입니다.");
		} else { 
			System.out.println("조건이 충족하지 않습니다.");
		}
		
		
		
		
		
		
	}

}
