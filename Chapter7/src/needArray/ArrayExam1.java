package needArray;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayExam1 {
	
	static int min ;
	static int max;

	public static void main(String[] args) {
		
	int[] ary = new int[(int)((Math.random())*10)];	// 랜덤 index길이 배열에 입력한  정수배열 저장
	Scanner input  = new Scanner(System.in);
	for (int i = 0; i < ary.length; i++) {
		System.out.println("숫자를 입력하세요 : ");
		ary[i] = input.nextInt();  //  정수 입력, 배열의 [i]번 index에 저장
		System.out.println(Arrays.toString(ary));
	}System.out.println("배열 꽉참");
	
	minValue(ary);
	maxValue(ary);
	
	System.out.println("최대값은 : " + max);
	System.out.println("최소값은 : "+ min);
	}
	
	public static int minValue(int[] arr) {
		min = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}

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
