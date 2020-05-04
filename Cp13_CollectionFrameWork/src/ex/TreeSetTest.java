package ex;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		
		
		class Person implements Comparable<Person>{
			String name;
			int age;
			
			public Person ( String name, int age) {
				this.name = name; this.age = age;
			}
			
			public void showData() {
				System.out.printf("%s %d \n", name, age);
			}
			
			public int compareTo(Person p) {
				int result = 0;
				
//				if (age > p.age) {
//					result = 1;
//				}else if (age < p.age) {
//				result = -1;
//				}else {
//					result = 0;
//				}
				result = (this.age - p.age)*-1;
				
				return result;
			}
		}
		TreeSet<Person> tree = new TreeSet<Person>();
		
		tree.add(new Person("Kim", 29));
		tree.add(new Person("Lee", 25));
		tree.add(new Person("Hone", 34));
		tree.add(new Person("Lim", 19));
		tree.add(new Person("Sung", 45));
		tree.add(new Person("Nam", 9));
		
		System.out.println("저장된 데이터 수 : " + tree.size());
		
		Iterator<Person> itr = tree.iterator();
		while (itr.hasNext()) {
			itr.next().showData();
			}
		
		}

	}

