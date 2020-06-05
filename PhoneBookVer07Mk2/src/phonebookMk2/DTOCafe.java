package phonebookMk2;

public class DTOCafe {
	
	// 카페 회원
	private String cfname;
	private String nickname;
	private int cfref;

	public DTOCafe() {
		
	}
	
	public DTOCafe (String cfname, String nickname, int cfref) {
		this.cfname = cfname;
		this.nickname = nickname;
		this.cfref = cfref;
		
	}


	public String getCfname() {
		return cfname;
	}

	public void setCfname(String cfname) {
		this.cfname = cfname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getCfref() {
		return cfref;
	}

	public void setCfref(int cfref) {
		this.cfref = cfref;
	}

	
}
