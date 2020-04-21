package chapter2_Op;

public class DivOpnd {

	public static void main(String[] args) {
		
		int nvm1 = 10;
		int nvm2 = 4;
		
		System.out.println(nvm1/nvm2);
		System.out.println(nvm1/(float)nvm2);
		
		System.out.println("정수형 나눗셈: " + 10/4);
		System.out.println("실수형 나눗셈: " + 10.0f/4.0f);
		System.out.println("형 변환 나눗셈: "+ (float)10/4);
	}

}
