package phonebookMk2;

public class DTOCompany {

	//회사 동료
	private String cname;
	private String dname;
	private String job;
	private int cmref;

	public DTOCompany() {

	}

	public DTOCompany (String cname, String dname, String job, int cmref) {
		this.cname = cname;
		this.dname = dname;
		this.job = job;
		this.cmref = cmref;
	}


	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getCmref() {
		return cmref;
	}

	public void setCmref(int cmref) {
		this.cmref = cmref;
	}
}
