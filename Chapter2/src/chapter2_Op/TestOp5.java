package chapter2_Op;

public class TestOp5 {

	public static void main(String[] args) {
 // 자바연습문제 [1]
		int x = 2;
		int y = 5;
		char c = 'A'; // 'A'의문자코드는 65

		System.out.println(y+= 10 - x++); // 13 출력
		System.out.println(x+=2); // 5 출력
		System.out.println(!('A' <= c && c <='Z') ); // false 출력. 둘 다 참이기에 true가 나와야하지만 앞에 논리부정 !가 들어가서 false가 나옴
		System.out.println('C'-c); // 2 출력.
		System.out.println('5'-'0'); // 5 출력. '5' 는 유니코드 53, '0' 은 유니코드 48. 문자를 수식에 넣으면 자동으로 int화 되어 유니코드로 변환되고 계산됨
		System.out.println(c+1); // 66 출력. 수식에 넣으면 자동으로 int  변환
		System.out.println(++c); // B 출력. 수식이 아닌 증감연산자에 ++가 전면에 붙어서 유니코드 65에서 1이 증가한 66으로 변하고 
											//그 유니코드에 해당하는 B가 출력됨. 만약 유니코드 출력이 필요하면 (int)가 필요.
		System.out.println(c++); // B 출력. 위의 출력에서 char c는 증감연산으로 인해 문자 'B'가 되었고 유니코드도 66으로 변했다. 
											// 하지만 이번 출력은 증감연산이 c 뒤에 붙어있기 때문에 먼저 현재 저장되어있는 유니코드 66을 받아 B를 출력한 후 1 증가하여 현재 c에는 
											// 유니코드 67, 문자 'C'가 저장되어 있다.
		System.out.println(c); // C 출력. 위의 두번의 증감연산자 출력을 통해 char c에는 총 두번의 값 증가가 있었고 따라서 현재 저장된 c값은 65에서 2가 증가한 67, 문자 'C'이다.
//자바 연습문제 [2] 
		int numOfApples =123; // 사과의 개수

		int sizeOfBucket =10;

		 // 바구니의 크기(바구니에 담을 수 있는 사과의 개수)
		int numOfBucket = numOfApples/sizeOfBucket + (numOfApples%sizeOfBucket>0 ? 1:0);

		 // 모든 사과를담는데 필요한 바구니의 수
		System.out.println("필요한바구니의 수 :"+numOfBucket);
		
//자바 연습문제 [3] 
		
		int num3 = -10;  
		
		System.out.println(num3 > 0 ? "양수" : (num3 == 0 ? "0" : "음수") );
		
//자바 연습문제 [4] 
		
		int num = 111;
	
		System.out.println((int)((float)(num/100)*100));
		// 형변환을 통해 소수점을 만들어주고 num에서 나눈 몫이 x.00이 되도록 만들고 
		// 다시 나온 몫값에 100을 곱해서 백의 자리만 남기고 int로 변환하여 출력
//자바 연습문제 [5]
		int num1 = 777;
		System.out.println(((int)(float)(num1/10)*10)+1);
		//연습문제 4번과 비슷하게 10의 자리까지 몫이 나오도록 나누고 마지막에 +1
		

		}
		
		

	}
