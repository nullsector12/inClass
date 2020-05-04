package ex;




import java.util.HashMap;
import java.util.Map;


public class MapTeat {
	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(new Integer(2), "2번");
		map.put(1, "1번");
		map.put(5, "5번");
		map.put(6, "6번");
		map.put(4, "4번");
		map.put(3, "3번");
		
		System.out.println("6학년 3반 1번 : " + map.get(1));
		System.out.println("6학년 3반 2번 : " + map.get(2));
		System.out.println("6학년 3반 3번 : " + map.get(3));
		System.out.println("6학년 3반 4번 : " + map.get(4));
		System.out.println("6학년 3반 5번 : " + map.get(5));
		System.out.println("6학년 3반 6번 : " + map.get(6));
	}

}
