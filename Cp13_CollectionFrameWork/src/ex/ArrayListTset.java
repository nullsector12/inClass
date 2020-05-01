package ex;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTset {

	public static void main(String[] args) {
		
		// List<E> -> ArrayList<E>
		// List<E> : 저장순서를 가진다. 데이터의 중복 저장을 허용
		// 순서 -> 일괄처리(반복적인 동일한 작업을 빠르게 처리)
		
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		ArrayList<Integer> list = new ArrayList<>();
		List<Integer> list = new ArrayList<>(); // 다형성
		
		
		// List<E> 정의된 메서드 =>
		// add(E) : 인스턴스의 저장
		// remove(Index) :  해당 인덱스의 요소를 삭제
		// size() : List 요소의 개수를 반환
		// get(Index) : 해당 인덱스 위치의 요소
		// set(index, element) : 해당 인덱스 위치의 요소를 element로 변경

		
		//데이터 저장
		list.add(new Integer(20));
		list.add(new Integer(10));
		list.add(new Integer(30));
		
		//데이터의 참조
		System.out.println("저장한 데이터 확인");
		//반복문을 통해 일괄 참조 가능
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//데이터 삭제
		list.remove(1);
		System.out.println("데이터 삭제 후 확인");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
