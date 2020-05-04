package ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest2 {
	public static void main(String[] args) {
		
		
		class SimpleNumber{
			
			int num;
			public SimpleNumber (int num){
				this.num = num;
			}
				public String toString() {
					
					return String.valueOf(num);
			}
				
				// HashSet 동등 비교 과정
				// 1. hash코드를 같은 hash코드 가진 객체 기반으로 비교
				// 2. equals 메서드 비교
				
				@Override
				public int hashCode() {
					return num%3;
				}
				@Override
				public boolean equals(Object obj) {
					SimpleNumber comp = (SimpleNumber)obj;
					
					if(comp.num == num) {
						return true;
					} else {
						return false;
					}

				}

		}
	
//		HashSet<String> set = new HashSet<String>();
//		HashSet<String> set = new HashSet<>();
		// 상위 인터페이스 (Set)  import로 HashSet 사용 가능 : 다형성
		Set<SimpleNumber> set = new HashSet<SimpleNumber>(); 
		
		set.add(new SimpleNumber(3));
		set.add(new SimpleNumber(5));
		set.add(new SimpleNumber(7));
		set.add(new SimpleNumber(12));
		set.add(new SimpleNumber(25));
		set.add(new SimpleNumber(31));
		set.add(new SimpleNumber(31));
		

		System.out.println("저장된 데이터 개수 : " + set.size());
		Iterator<SimpleNumber> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

		}

	
}


