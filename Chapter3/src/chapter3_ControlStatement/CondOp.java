package chapter3_ControlStatement;

public class CondOp {

	public static void main(String[] args) {
		
		int num1 = 100, num2 = 50;
		
		int bigNum, diffNum;
		
//		bigNum = (num1 >num2) ? num1:num2;
//		System.out.println("두 수 중 큰 수의 값은 : " +bigNum);
//		
//		diffNum = (num1>num2) ? num1-num2 : num2 - num1;
//		System.out.println("두 수의 차이는 : " + diffNum);
		
		if(num1 > num2) {
			bigNum = num1;
			diffNum = num1 - num2;
		}else {
			bigNum = num2;
			diffNum = num2 - num1;
		}
		System.out.println("두 수 중 큰 수의 값은 : " +bigNum);
		System.out.println("두 수의 차이는 : " + diffNum);

	}

}
