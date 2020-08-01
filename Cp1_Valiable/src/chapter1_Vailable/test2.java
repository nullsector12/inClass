package chapter1_Vailable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class test2 {
public static void main(String[] args) {
	
	Random random =new Random();
	int cnt=0;
	int N=random.nextInt(10)+1;
	
	List<Integer> num =new LinkedList<Integer>();

	// 숫자 넣기

	for(int i =0; i<N;i++) {
		
		num.add(random.nextInt(99)+1);
	}	//이중포문으로 스왑
	
	
	
	
	
	for(int j=0;j<N;j++) {
//		System.out.println(num.get(j));
	for(int i =1; i<N-1;i++) {
//		System.out.println(num.get(i));
		
		if(num.get(j)>num.get(i)) {
			Collections.swap(num, j, i);
			cnt++;
		}
	}

	}
	

	System.out.println(cnt);
	System.out.println(1);
	
	
}




}
