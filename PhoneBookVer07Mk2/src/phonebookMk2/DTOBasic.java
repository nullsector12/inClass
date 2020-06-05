package phonebookMk2;

public class DTOBasic {

	private int pidx;
	private String name;
	private String pnum;
	private String address;
	private String email;
	private String kategorie;


	public DTOBasic() {

	}

	public DTOBasic (int pidx, String name, String pnum, String address, String email, String kategorie) {
		this.pidx = pidx;
		this.name = name;
		this.pnum = pnum;
		this.address = address;
		this.email = email;
		this.kategorie = kategorie;
	}

	public int getPidx() {
		return pidx;
	}

	public void setPidx(int pidx) {
		this.pidx = pidx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

}
