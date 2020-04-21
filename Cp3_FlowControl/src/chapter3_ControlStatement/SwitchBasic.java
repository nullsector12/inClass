package chapter3_ControlStatement;

public class SwitchBasic {

	public static void main(String[] args) {
		
		int n = 2;
		
		switch(n) {
		case 1:
			System.out.println("Simple Java");
		case 2:
			System.out.println("Funny Java");
		case 3:
			System.out.println("Fantastic Java");
		default:
			System.out.println("The best programming language");
		}
		System.out.println("Do you like coffee?");

		System.out.println("=============================");
		
		switch(n) {
		case 1:
			System.out.println("Simple Java");
			break;
		case 2:
			System.out.println("Funny Java");
			break;
		case 3:
			System.out.println("Fantastic Java");
			break;
		default:
			System.out.println("The best programming language");
		}
		System.out.println("Do you like coffee?");
		

	}

}
