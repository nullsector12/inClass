package needArray;

public class WhyNeedArray {
	
	
	public static void main(String[] args) {
		
		// int 타입의 정수 데이터를 3개 저장할 수 있는 배열 생성
		// 배열 이름 arr 선언
		// 배열 이름 선언과 인스턴스 생성 : 배열 각 요소의 저장공간 생성
		int[] arr = new int[3];
		
		// 배열 요소에 참조 
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		
		int sum = arr[0] + arr[1] + arr[2];
		System.out.println(sum);
		
	}
}
