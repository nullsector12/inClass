package chapter2_Op;

public class TestOp6 {

	public static void main(String[] args) {
 
//자바 연습문제 [6]
		
		int num = 30;
		
		int num2 =  10 - (num%10) ;
		
		System.out.println(num2);
		
//자바 연습문제 [7]
		int F = 100;

		float C = (int)((float)5/9*(float)(F-32)*100+0.5f)/100f;
//		C = 5/9*(F-32)
		// (int)((float)5/9*(float)(F-32)*100/1000f)
		//
		System.out.println("Fahrenheit:"+F);

		System.out.println("Celcius:"+ C);
		
		
//자바 연습문제 [8]
		
//		byte a = 10;
//		byte b = 20;
//		byte c = (byte)(a + b);  //→  (byte)(a + b);
//		char ch = 'A';
//		ch = (char)(ch + 2);   //  → (char)(ch + 2);
//		float f = (float)3 / 2;  //  → (float)3 / 2;
//		long l = 3000 * 3000 * 3000L; //   → 3000 * 3000 * 3000L;
//		float f2 = 0.1f;
//		double d = 0.1;
//		boolean result = (float)d == f2; //   → (float)d == f2;
//		
//		System.out.println("c="+ c);
//		System.out.println("ch="+ch);
//		System.out.println("f="+f);
//		System.out.println("l="+l);
//		System.out.println("result="+result);
		
		//자바 연습문제 [9]
		
		char ch = 'z'; // '0' = 48 ~ '9' = 57, 58 ~ 64까지 공백   
							// 'A' = 65 ~ 'Z' = 90,  91 ~ 96까지 공백
							// 'a' = 97 ~ 'z' = 122, 123부터 필요 없음

		boolean b = (ch <= 48 || ch >= 57) || (ch <= 65 || ch >= 90) || ( ch <= 97 || ch >= 122);

		System.out.println(b);
		
		//자바 연습문제 [10]
		char ch1 = 'A';

		char lowerCase = (char) (ch1 <= 'Z' ? ch1+32 : ch1);

		System.out.println("ch1:"+ch1);

		System.out.println("ch1 to lowerCase:"+lowerCase);
		

		}
		
		

	}
