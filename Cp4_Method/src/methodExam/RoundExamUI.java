package methodExam;

public class RoundExamUI {

	public static void main(String[] args) {
		  RoundExam round1 = new RoundExam();
		  
		  round1.round = 5;
		  
		  System.out.println("반지름이 " + round1.round + "cm인 원의 넓이는 : " + round1.RoundWide(0) + " ㎠ 입니다.");

		  System.out.println("반지름이 " + round1.round + "cm인 원의 둘레는 : " + round1.Rounder(0)+ " cm 입니다.");

		 }

}
