package needArray;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExam2 {
	
	public static int[] addOneDArr(int[] arr, int add){
		for (int i=0; i<arr.length; i++)
		arr[i] +=add; // 배열길이만큼 반복하여 i번 인덱스에 add값 더해줌
		return arr; // 배열 arr[i] +=add 값 반환
		}
	
	public static int[][] addTwoDArr(int[][] arr, int add){
		for(int i = 0; i < arr.length; i++) { // 행i를 arr 길이만큼 반복
			System.out.println(); // 한 행이 끝나면 엔터입력
			for(int j = 0; j < arr[i].length; j++) { // 열 j를 arr의 i행만큼 반복
				arr[i][j] = arr[i][j]+add; // add값을 열 j에 더해줌
				System.out.print(arr[i][j] + "\t"); // arr[i] 행의 [j]열을 한 줄로 탭하여 출력 
			}
		}
		return arr; // 배열 arr[i][j] += add 값 반환
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("arr의 인덱스 길이를 입력해주세요 : ");
		int[] arr = new int[input.nextInt()]; // 인덱스의 길이를 직접 입력
		System.out.println(Arrays.toString(arr)); // arr의 현재 저장값 출력
		
		System.out.println("arr1의 행과 열을 입력해주세요 : ");
		int[][] arr1 = new int [input.nextInt()][input.nextInt()]; // 이차원 배열 직접 입력 후생성
		System.out.println(Arrays.deepToString(arr1)); // arr1배열의 현재 저장값 출력
		
		int[][] sum2; // addTwoDArr의 값을 저장할 배열 생성
		System.out.println("add값을 입력해주세요 : ");
		sum2 = addTwoDArr(arr1, input.nextInt()); // add값 직접 입력
		System.out.println();
		System.out.println(Arrays.deepToString(sum2)); // deepToString = 다차원 배열 출력
		
	}
	
}
