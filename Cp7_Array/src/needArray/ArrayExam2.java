package needArray;

import java.util.Arrays;

public class ArrayExam2 {
	
	public static int[] addOneDArr(int[] arr, int add){
		for (int i=0; i<arr.length; i++)
		arr[i] +=add;
		return arr;
		}
	
	public static void main(String[] args) {
		int[] arr = new int[5];
		int[] sum;
		System.out.println(Arrays.toString(arr));
		sum = addOneDArr(arr, 5);
		for(int i = 0; i < sum.length; i++) {
			System.out.println(arr[i]);
		}
		
		
		
		
		
	}
	
	

}
