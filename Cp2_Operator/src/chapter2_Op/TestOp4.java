package chapter2_Op;

public class TestOp4 {

	public static void main(String[] args) {
		/*a= {{(25+5)+(36/4)}-72}*5, b= {{(25x5)+(36-4)}-71}/4, c=(128/4)*2 일 때
				a>b>c 가 참이면 true 아니면 false를 출력하는 프로그램 작성 */
		int a = (((25+5)+(36/4))-72)*5; // -165
		int b = (((25*5)+(36-4))-71)/4; // 21
		int c = (128/4)*2; // 64 
		boolean result = false; // 기본은 false
		
		// a가 b보다 크고 b가 c보다 큰 것이 모두 참이면 a는 당연히 c보다 크다 따라서 비교 할 필요 없이 a>b>c가 성립된다. ( a>c = SCE)
		if(a>b && b>c) { //a가 b보다 크고 b가 c보다 크다가 모두 참이면 
			System.out.println("a>b>c는 : " + !result); // rseult 앞에 !를 붙여 논리부정표시로 출력값을 true로 변경
		}else { // 두 조건 중 하나라도 거짓이면 a>b>c는 성립하지 않음.
			System.out.println("a>b>c는 : " + result); // 기본값인 false 출력
		}
 //결과는 거짓이 출력되야함
		
		}
		
	}
