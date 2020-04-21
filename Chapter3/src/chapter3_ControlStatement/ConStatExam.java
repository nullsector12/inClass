package chapter3_ControlStatement;

public class ConStatExam {
	public static void main(String[] args) {
		
		//조건&반복 문제 [1]
		
//		int num = -10;
//		if(num>0 && (num%2)==0) {
//			System.out.println("양수이면서 짝수");
//		}else {
//			System.out.println("음수거나 홀수");
//		}
		
		//조건&반복 문제 [2]
		
//		int num = 150;
//		
//		if ( num < 0 ) {
//			System.out.println("0 미만");
//		}else if ( /*0 <= num &&*/ num < 100 ) {
//			System.out.println("0이상 100미만");
//		}else if ( /*100 <= num &&*/ num < 200) {
//			System.out.println("100이상 200미만");
//		}else if ( /*200 <= num &&*/ num < 300) {
//			System.out.println("200이상 300미만");
//		} else {
//			System.out.println("300 이상");
//		}
		
		//조건&반복 문제 [3]
		
//		int num1 = 100, num2 = 50;
//		
//		int bigNum, diffNum;
//		
//		if(num1 > num2) {
//			bigNum = num1;
//			diffNum = num1 - num2;
//		}else {
//			bigNum = num2;
//			diffNum = num2 - num1;
//		}
//		System.out.println("두 수 중 큰 수의 값은 : " +bigNum);
//		System.out.println("두 수의 차이는 : " + diffNum);	
		
		//조건&반복 문제 [4]
		
//		int n = 5;
//		if (n == 1) {
//			System.out.println("Simple Java");
//		}else if(n ==2) {
//			System.out.println("Funnu Java");
//		}else if(n == 3) {
//			System.out.println("Fantastic Java");
//		} else {
//			System.out.println("The best programming language");
//		}
//		System.out.println("Do you like coffee?");
		
		//조건&반복 문제 [5]
		
//		int num = 300;
//		
//		if (num<0) {
//			System.out.println("0 미만");
//		} else {
//		switch(num/100) {
//			case 0 :
//				System.out.println("0이상 100미만");
//				break;
//			case 1 :
//				System.out.println("100이상 200미만");
//				break;
//			case 2 :
//				System.out.println("200이상 300미만");
//				break;
//			default :
//				System.out.println("300이상");
//			}
//		}
		
		//조건&반복 문제 [6]
		
//		int i = 1;
//		int sum = 0;
//		while ( i < 100) {
//			sum += i;
//			i++;
//		}System.out.println(sum);
		
	
		//조건&반복 문제 [7]
		
//		int num = 1;
//		while ( num <= 100) {
//			System.out.println(num);
//			num++;
//		}
//		do {
//			num--;
//			System.out.println(num);
//		}while (num > 1);
	
		//조건&반복 문제 [8]
		
//		int num = 1;
//		int sum = 0;
//		while (num <= 1000) {
//			if (num%2 == 0  && num%7 == 0) {
//				sum = sum + num;
//				System.out.println("2의 배수이면서 7의 배수인 수 : " + num);
//			}
//			num++;
//		}System.out.println("모든 결과의 합 : " + sum);
		
		//조건&반복 문제 [9]
		
//		int result = 1;
//		for(int i = 1; i <= 10; i++) {
//			result = result*i;
//		}System.out.println(result);
		
		//조건&반복 문제 [10]
		
//		int j = 5;
//		for( int i = 1; i <= 9; i++) {
//			int x = j*i;
//			System.out.println(j+" x "+ i + " = " + x);
//		}
		

		//조건&반복 문제 [11]
		
//		int num=0;
//		int count=0;
//		while((num++)<100){
//			for(; num%5 == 0 && num%7 ==0; num++ ) {
//				System.out.println(num);
//				count++;
//			}
//		}
//		System.out.println("count: " + count);

	
		//조건&반복 문제 [12]
		
//		int num = 1;
//		int sum = 0;
//		
//		while(true) {
//			num++;
//			if ( num%2 == 1 || num%2 == 0 && num%3 == 0) {
//				sum += num;
//				if( sum > 1000) {	
//					System.out.println("최초로 1000이 넘는 합의 값 : " + sum);
//					System.out.println("최초로 합이 1000이 넘을 때 num의 값 : " + num);
//					break;
//				}
//			}
//		}
		
		//조건&반복 문제 [13]

//		for (int i = 2; i<=9; i *= 2) {
//			for(int j = 1; j <= i; j++) {
//					System.out.println(i + " x " + j + " = " + i*j);
//				}
//			}	
		
		
		//조건&반복 문제 [14]

//		int result = ((a*10)+b) + ((b*10)+a);
			
//		for(int a = 1; a <10; a++) {
//				for (int b = 1; b <10; b++) {
//					if ( (a*10+b) + (b*10+a) == 99 ) {
//						System.out.println("    "+ a + b);
//						System.out.println(" + "+b + a);
//						System.out.println("=======");
//						System.out.println("    "+((a*10+b) + (b*10+a))) ;
//						System.out.println();
//						
//					}
//				}
//			}
	
		
		//조건&반복 문제 [15]
		// if문 답안
//		int n = 5;
//		if (n == 1) {
//			System.out.println("현재 인원은 1명 입니다.");
//		}else if (n == 2) {
//			System.out.println("현재 인원은 2명 입니다.");
//		}else if (n == 3) {
//			System.out.println("현재 인원은 3명 입니다");
//		}else if( n >3) {
//			System.out.println("현재 많은 사람들이 있습니다.");
//		}else {
//			System.out.println("현재 아무도 없습니다.");
//		}
		
//		switch (n) {
//		case 0:
//			System.out.println("현재 아무도 없습니다.");
//			break;
//		case 1:
//			System.out.println("현재 인원은 1명 입니다.");
//			break;
//		case 2:
//			System.out.println("현재 인원은 2명 입니다.");
//			break;
//		case 3:
//			System.out.println("현재 인원은 3명 입니다.");
//			break;
//		default:
//			System.out.println("현재 많은 사람들이 있습니다.");
//		}
		

		//조건&반복 문제 [16]
		//while문 답안
//		int num = 1;
//		int sum = 0;
//		while (num<100) {
//			sum += num;
//			num++;
//		}System.out.println(sum);
		
		//for문 답안
//		int sum = 0;
//		for (int i =1; i <100; i++) {
//		sum += i;
//		}System.out.println(sum);
		
		//do while문 답안
		
//		int num = 1;
//		int sum = 0;
//		do {
//			sum += num;
//			num++;
//		}while(num<100);
//		System.out.println(sum);
		
		
		
		
		
		
		
		
		
		

		
		
		
		
	}
}

 