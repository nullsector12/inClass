package chapter1_Vailable;

public class ByteOverflow {

	public static void main(String[] args) {

		byte b = 0;
		int i = 0;
		
		for(int x = 0; x <= 384; x++) {
			System.out.print(b++);
			System.out.print('\t');
			System.out.println(i++);
		}

	}

}
