package needArray;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayExam1 {
	
	static int min;
	static int max;
	public static void main(String[] args) {
		
		int[] ary = new int[(int)((Math.random())*10)+1];	// 랜덤 index길이 배열에 사용자가 입력한 정수저장
		Scanner input  = new Scanner(System.in);
		for (int i = 0; i < ary.length; i++) {
			System.out.println("숫자를 입력하세요 : ");
			ary[i] = input.nextInt();  //  정수 입력, 배열의 [i]번 index에 저장
		}
		System.out.println(Arrays.toString(ary));
		System.out.println("배열 꽉참");
	
		min  = minValue(ary);  // minValue에 ary배열 전달 후 minValue 메서드에서 반환받은 min값 저장
		max = maxValue(ary); 
	
		System.out.println("최소값은 : " + min);
		System.out.println("최대값은 : "+ max);
	}
	// 사용자에 의해 입력된 ary 배열을 전달 받아 비교한 후 최소값 min을 반환하는 기능 (메서드)
		public static int minValue(int[] arr) {
			min = arr[0]; //min값이 arr배열의 첫번째 인덱스가 되도록 초기화
			for(int i = 0; i < arr.length; i++) { // i의 증가가 arr 배열의 인덱스 길이만큼 반복
				if(min>arr[i]) { // 만약 arr[i]번째 값이 min값보다 작으면 
					min = arr[i]; // min값이 arr[i]로 변함.
				}
			}
		return min; // 모든 인덱스길이만큼 비교가 끝나면 반복 종료 후 min값 반환
	}
// 최대값 max를 반환하는 기능 (메서드)
		public static int maxValue(int[] arr) {
			max = arr[0];
			for(int i = 0; i < arr.length; i++) {
				if(max<arr[i]) {
					max = arr[i];
				}
			}
		return max;
	}
}
