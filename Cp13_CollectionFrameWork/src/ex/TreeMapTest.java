package ex;


import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		
		map.put(new Integer(2), "2번");
		map.put(1, "1번");
		map.put(5, "5번");
		map.put(6, "6번");
		map.put(4, "4번");
		map.put(3, "3번");
		
//		System.out.println("6학년 3반 1번 : " + map.get(1));
//		System.out.println("6학년 3반 2번 : " + map.get(2));
//		System.out.println("6학년 3반 3번 : " + map.get(3));
//		System.out.println("6학년 3반 2번 : " + map.get(2));
		
		NavigableSet<Integer> navi = map.navigableKeySet();
		System.out.println("오름차순 출력");
		Iterator<Integer> itr = navi.iterator();
		while(itr.hasNext()) {
			System.out.println(map.get(itr.next()));
		}
		System.out.println("내림차순 출력");
		itr = navi.descendingIterator();
		while(itr.hasNext()) {
			System.out.println(map.get(itr.next()));
		}
		
		// 원래 key값에 있던 변수를 변경
		map.put(2, "호오오옹");
		System.out.println(map.get(2));
		
	}

}
