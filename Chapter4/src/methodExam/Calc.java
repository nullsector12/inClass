package methodExam;

class Calc { // 계산기능을 하는 클래스
	
	// 속성 = 숫자, 숫자를 전달받는다.
	int num1;
	int num2;
	String str;

	int plus() { // 덧셈기능 메서드 
		int plus = num1 + num2;
		return plus;
		//plus 결과 반환
	}
	
	int minus() { // 뺄셈기능 메서드
		int minus = num1 - num2;
		return minus;
		// minus 결과 반환
	}
	
	int multi() { // 곱셈기능 메서드
		int multi = num1 * num2;
		return multi;
		// multi 결과 반환
	}
	
	int divi1() { // 몫 출력 메서드
		int divi1 = num1/num2;
		return divi1;
		// 나누기.몫의 결과 반환
	}
	
	int divi2() { // 나머지 출력 메서드
		int divi2 = num1%num2;
		return divi2;
		// 나누기.나머지의 결과 반환
	}
	
	// 메인메서드에서 호출한 사칙연산의 결과를 반환하는 메서드
	void pushResult() {
		switch(str) {
		case "+":
			System.out.println("덧셈의 결과 : " + plus());
			break;
		case "-":
			System.out.println("뺼셈의 결과 : " +minus());
			break;
		case "*":
			System.out.println("곱셈의 결과 : " + multi());
			break;
		case "/":
			System.out.println("나눈 몫의 결과 : " + divi1());
			break;
		case "%":
			System.out.println("나눈 나머지의 결과 : " + divi2());
			break;
		}
	}
	
}

