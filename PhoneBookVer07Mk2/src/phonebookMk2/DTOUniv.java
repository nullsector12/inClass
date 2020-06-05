package phonebookMk2;

public class DTOUniv {

	//대학 친구
	private String major;
	private int grade; 
	private int uref;

	public DTOUniv() {
	}

	public DTOUniv (String major, int grade, int uref) {
		this.major = major;
		this.grade = grade;
		this.uref = uref;
	}


	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getUref() {
		return uref;
	}

	public void setUref(int uref) {
		this.uref = uref;
	}	
}
