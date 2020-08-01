package chapter1_Vailable;

public class test {
	public static void main(String[] args) {
		// 1. 배열 만들기 : 1<= N <= 500,000
		
		int N = (int) ((Math.random()*500000)+1);
		System.out.println("N : "+N);
		
		// 1-2 배열 선언
		int[] arr = new int[N];
		
		// 2. 배열안에 숫자 넣기
		// 숫자 범위 0<= a <= 1,000,000,000;
		for (int i = 0; i <arr.length ; i++) {
			arr[i] = (int) ((Math.random()*1000000000)+1);
		}
		// 3. 버블정렬
			long swap = 0;
			int saveVal;
			
			for(int i =0; i < arr.length ; i++) {
				for(int j =1; j <arr.length-1; j++) {
					if(arr[i] > arr[j]) {
						saveVal = arr[j];
						arr[j] = arr[i];
						arr[i] = saveVal;
						swap++;
					}
			}
			}
			System.out.println("swap : "+swap);
	}
	

}
