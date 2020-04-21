package chapter4_Method;

public class Method1 {

	public static void main(String[] args) {

	//특정 기능을 수행하기 위한 코드를 묶어 놓은것 
	// 데이터가 필요할 때 매개변수를 선언하고 데이터를 받는다.	
	// 메서드 사용을 위해선 인스턴스(객체) 생성 후
	// 메서드 코드를 메모리에 로드한다.
	// 메서드의 선택은 호출할 때 결정된다. => overloading
	
	// 인스턴스 생성 ( 객체 생성 )
	MyMath math = new MyMath( );
	long result =  math.add(10, 100);
	
	System.out.println(result);
	System.out.println(math);
	}
	
}

