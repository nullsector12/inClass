package chapter3_ControlStatement;

public class IEGrade {

	public static void main(String[] args) {
	
		int score = 55;
		
		String grade = " "; //A+ A A- B+ B B- C
	// 100~98 = A+, 97~95 = A, 94~ 92 = A-
		// 91~89 = B+, 88~86 = B, 85~83 = B-
		// 나머지 C
		if(score >= 98) {
			grade = "A+";
		 if (score <= 97 && score >= 95) {
			grade = "A";
		 if(score <= 94 && score >= 92) {
			grade = "A-";
		 		}
		 	}
		}
		if (score >= 89) {
			grade = "B+";
			if (score <= 88 && score >= 86) {
				grade = "B";
				if(score <=85 && score >= 83) {
					grade = "B-";
				}
			}
		}
		else {
			grade = "C";
			}
		System.out.println(grade);
		}
}