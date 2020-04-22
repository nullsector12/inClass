package needArray;

import java.util.Arrays;

public class ArrayExam3 {
	static int[][] arr = {		{1,2} // index[0]
										,{1,2,3} // index[1]
										, {1,2,3,4} // index[2]
										, {1,2,3,4,5} // index[3]
										,{1,2,3,4,5,6} // index[4]
										,{1} // index[5]
										};  // 총 6행 = length 는 6, index는 0~5

	// 배열 위치변경 메서드
	static void switchArr(int[][]arr){
		
		// 2차원 배열의 1차원 행의 배열 개수
		// 1차배열 temp에 2차배열 arr의 [0]행의 열 개수만큼 배열생성
		int [] temp = new int [arr[0].length]; 
		
		//배열 temp는 [arr배열의 행의 길이 - 1]번의 index 안의 값, 
		// 즉 arr배열의 가장 마지막 행의 열 값을 저장한다.
		temp = arr[arr.length-1];  // temp = arr[6 - 1] = arr[5] 의 값 저장 = {1}
		
		// i의 초기값은 arr배열 행 길이의 -1, 즉 index번호로 시작하고, index번호를 1씩 줄여 n~0까지의 
		// 모든 index번호를 변환해준다.
		// index행의 길이가 6, i의 초기값은 5가 되고,  
		for(int i = arr.length-1; i >0; i--) {
			// 따라서 arr[5 = 마지막 index] 에는 arr[4 = 마지막 바로 앞 index]로 바뀌고 
			// 주소값을 잃은 index 5번 안의 arr배열 값들은 G.C로 인해 사라질 예정
			arr[i] = arr[i-1]; 
			System.out.println("arr index ["+ i +"]번의 배열 값은 "
			+ "arr index [" + (i-1) +"]번으로 교체합니다." );
			/*for문 시작 =======
			 * i =5, arr[5] = arr[4] 
			 * i = 4, arr[4] = arr[3]
			 * i =3, arr[3] = arr[2]
			 * i = 2, arr[2] = arr[1]
			 * i = 1, arr[1] = arr[0]
			 * for문 종료 =======
			 * */

			// 마지막 index 0번째의 배열값은 처음 temp에 저장해 놨으므로 모든 반복과 교환이 끝나면 비어있는 
		}arr[0] = temp;
		System.out.println("arr index [0]번은 temp에 저장된 값, arr [5]로 교체합니다."); 
}
	
	public static void main(String[] args) {
		
		switchArr(arr);
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j< arr[i].length; j++) {
				System.out.print(arr[i][j]+"\t");
				}
			System.out.println();
		}

	}
	
}



