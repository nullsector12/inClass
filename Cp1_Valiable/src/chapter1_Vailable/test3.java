package chapter1_Vailable;

import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] A=new int[N];
		
		for(int i=0; i<A.length; i++) {
			A[i]=sc.nextInt();
			
		}
		
		int swap=0;
		int temp=0;
		int num=0;
		while(num<N) {
			for(int j=1; j<N-1; j++) {
				if(A[num] > A[j]) {
					temp=A[j];
					A[j]=A[num];
					A[num]=temp;
					swap++;
				}
				
			}
			num++;
		}
		System.out.println(swap);
		
	}

}
