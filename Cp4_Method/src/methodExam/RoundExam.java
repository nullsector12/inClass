package methodExam;

public class RoundExam {
	 double round;

	 // 원의 넓이를 구하고 계산값을 반환하는 메서드
	 double RoundWide(double wide){
	  wide = Math.pow(round, 2)*Math.PI;
	  return wide;
	 }

	 // 원의 둘레를 구하고 계산값을 반환하는 메서드
	 double Rounder (double rund) {
	  rund = 2*(Math.PI*round);
	  return rund;
	 }
	
}
