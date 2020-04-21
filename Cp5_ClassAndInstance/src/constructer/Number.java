package constructer;

public class Number {
	
	int num;
	
	
	// 생성자 01
//	Number(){
//		System.out.println("생성자 호출");
//		num = 1000; 
//	}
	
	//생성자 02
	Number(int n){
		
		System.out.println(" 생성자 호출");
		num = n;
	}

	public static void main(String[] args) {
		
		Number n1 = new Number(10000000);
		//new Number();
		System.out.println(n1.num);
		
	}
	
}
