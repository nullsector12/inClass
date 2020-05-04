package ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		
		
//		HashSet<String> set = new HashSet<String>();
//		HashSet<String> set = new HashSet<>();
		// 상위 인터페이스 (Set)  import로 HashSet 사용 가능 : 다형성
		Set<String> set = new HashSet<>(); 
		
		set.add("First");
		set.add("Second");
		set.add("Third");
		set.add("First");
		
		System.out.println("저장된 데이터 개수 : " + set.size());
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		
		
		
		
	}

}

