package ex;

public class WrapperEx1 {
	
	public static void main(String[] args) {
		
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		
		System.out.println((i1 == i2));
		System.out.println(i1.equals(i2));
		
		System.out.println(i1.toString());
		System.out.println(i2.toString());
		
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		System.out.println(Long.BYTES);
		System.out.println(Integer.SIZE);
		
	}

}