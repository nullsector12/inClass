package chapter3_ControlStatement;

public class ByTimes2 {

	public static void main(String[] args) {
		
		int i = 2, j;
		while (i <10)
		{
			System.out.println("====================");
			System.out.println(i+ " 단 ");
			System.out.println("====================");
			j = 1;
			while (j<10)
			{
				System.out.println(i+ " x "+ j + " = "+ i*j);
				j++;
			} 
			i++;
		}

	}

}
