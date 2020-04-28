package ex;

public class RunTimeExceptionCase {
	
	
	public static void main(String[] args) {
		try {
			
			int[] arr = new int[3];
			arr[2] = 20;
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		try {
			Object obj = new int[10];
			String str = (String)obj;
		
		}catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
		try {
			int [] arr = new int[10];
		}catch (NegativeArraySizeException e) {
			System.out.println(e.getMessage());
			
		}
		try {
			String str = null;
			int len = str.length();
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("무조건 실행하는 finally");
		}
		}
	

}
