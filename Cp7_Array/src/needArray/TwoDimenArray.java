package needArray;

public class TwoDimenArray {

	public static void main(String[] args) {
		
		//1차원 배열 선언, 생성
		int [][] arr = new int [3][4];
		
		//arr [행의 위치] [1차원 배열의 index]
		//arr [0~2] [0~4]
		
		System.out.println("2차원 배열의 사이즈 : " + arr.length);
		System.out.println("1차원 배열의 사이즈 : " + arr[0].length);
		
		
		// 2차원 배열의 행의 반복
		for (int i = 0; i < arr.length; i++) {
			System.out.println();
			// 1차원 배열의 요소 참조 반복
			for( int j = 0; j < arr[i].length; j++) {
				System.out.print(arr [i][j] + "\t");
			}
		}


	}

}
