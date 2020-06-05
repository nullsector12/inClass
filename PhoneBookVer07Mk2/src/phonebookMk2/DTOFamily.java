package phonebookMk2;

public class DTOFamily {
	
	// 가족
	private String relationship;
	private int fmref;

	public DTOFamily() {
		
	}
	
	public DTOFamily (String relationship, int fmref) {
		this.relationship = relationship;
		this.fmref = fmref;
			}

	
	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public int getFmref() {
		return fmref;
	}

	public void setFmref(int fmref) {
		this.fmref = fmref;
	}
	
}
