package needArray;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayExamForEach {
	
	public static void main(String[] args) {
		
		int min, max;
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
	
		public static int minValue(int[] arr) { // ary배열 값을 참조
			int min = arr[0]; 
			for(int e : arr) { // 참조한 배열 arr의 각 요소 값을 순차적으로 e에 전달, arr은 메인메서드의 ary배열
				if(min>e) { // arr배열에서 전달받은 순차적인 값들을 min 초기값인 arr[0] = ary[0]과 비교함.
					min = e;  // 비교한 e의 값이 min값보다 작으면 min을 e로 초기화 후 반복.
				}
			}
		return min; // 모든 e값을 순차적으로 비교후 반복문 종료, 마지막 min값을 반환
	}

		public static int maxValue(int[] arr) { // ary배열 값을 참조
			int max = arr[0];
			for(int e : arr) { // 참조한 배열 arr의 각 요소 값을 순차적으로 e에 전달, arr은 메인메서드의 ary배열
				if(max<e) {
					max = e;
				}
			}
		return max;
	}
}
