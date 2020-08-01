package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		H = H-1;
		M= M+15;
		
		if(H < 0) {
			H = 23;
		}
		if (M >= 60) {
			M= M-60;
		}
		System.out.println(H + " " + M);
	}
}
