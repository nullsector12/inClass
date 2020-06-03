package phonebook;

public class Contact{
	
	private int pidx;
	private String cn_name;
	private String cn_phonenumber;
	private String cn_address;
	private String cn_email;
	private String kategorie;
//	 대학 선택 정보
	private String cn_u_major;
	private int cn_u_grade;
//	 회사 선택 정보
	private String cn_cm_cname;
	private String cn_cm_dname;
	private String cn_cm_job;
//	 카페 선택 정보
	private String cn_cf_cname;
	private String cn_cf_nickname;
//	 가족 선택 정보
	private String cn_fm_relationship;
	
	public Contact() {
		
	}
	
	public Contact( int pidx, String cn_name, String cn_phonenumber, String cn_address, String cn_email, String kategorie, 
			String cn_u_major, int cn_u_grade, 
			String cn_cm_cname, String cn_cm_dname, String cn_cm_job, 
			String cn_cf_cname,String cn_cf_nickname, 
			String cn_fm_relationship) {
		
		this.pidx = pidx;
		this.cn_name = cn_name;
		this.cn_phonenumber = cn_phonenumber;
		this.cn_address = cn_address;
		this.cn_email = cn_email;
		this.kategorie = kategorie;
		// 대학
		this.cn_u_major = cn_u_major;
		this.cn_u_grade = cn_u_grade;
		// 회사
		this.cn_cm_cname = cn_cm_cname;
		this.cn_cm_dname = cn_cm_dname;
		this.cn_cm_job = cn_cm_job;
		// 카페
		this.cn_cf_cname = cn_cf_cname;
		this.cn_cf_nickname = cn_cf_nickname;
		// 가족
		this.cn_fm_relationship = cn_fm_relationship;
	}
	
	public void insertBasicInfo(int pidx, String cn_name, String cn_phonenumber,String  cn_address,String  cn_email) {

	}

//	public void Contact_company(int pidx, String cn_name, String cn_phonenumber, String cn_address, String cn_email, String kategorie, String cn_cm_cname, String cn_cm_dname, String cn_cm_job) {
//		this.pidx = pidx;
//		this.cn_name = cn_name;
//		this.cn_phonenumber = cn_phonenumber;
//		this.cn_address = cn_address;
//		this.cn_email = cn_email;
//		this.kategorie = kategorie;
//		// 회사
//		this.cn_cm_cname = cn_cm_cname;
//		this.cn_cm_dname = cn_cm_dname;
//		this.cn_cm_job = cn_cm_job;
//	}
	
//	public void Contact_cafe(int pidx, String cn_name, String cn_phonenumber, String cn_address, String cn_email, String kategorie,String cn_cf_cname,String cn_cf_nickname) {
//		this.pidx = pidx;
//		this.cn_name = cn_name;
//		this.cn_phonenumber = cn_phonenumber;
//		this.cn_address = cn_address;
//		this.cn_email = cn_email;
//		this.kategorie = kategorie;
//		// 카페
//		this.cn_cf_cname = cn_cf_cname;
//		this.cn_cf_nickname = cn_cf_nickname;
//	}
	
//	public void Contact_family(int pidx, String cn_name, String cn_phonenumber, String cn_address, String cn_email, String kategorie, String cn_fm_relationship) {
//		this.pidx = pidx;
//		this.cn_name = cn_name;
//		this.cn_phonenumber = cn_phonenumber;
//		this.cn_address = cn_address;
//		this.cn_email = cn_email;
//		this.kategorie = kategorie;
//		// 가족
//		this.cn_fm_relationship = cn_fm_relationship;
//	}
	
	public int getPidx() {
		return pidx;
	}

	public void setPidx(int pidx) {
		this.pidx = pidx;
	}

	public String getCn_name() {
		return cn_name;
	}

	public void setCn_name(String cn_name) {
		this.cn_name = cn_name;
	}

	public String getCn_phonenumber() {
		return cn_phonenumber;
	}

	public void setCn_phonenumber(String cn_phonenumber) {
		this.cn_phonenumber = cn_phonenumber;
	}

	public String getCn_address() {
		return cn_address;
	}

	public void setCn_address(String cn_address) {
		this.cn_address = cn_address;
	}

	public String getCn_email() {
		return cn_email;
	}

	public void setCn_email(String cn_email) {
		this.cn_email = cn_email;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public String getCn_u_major() {
		return cn_u_major;
	}

	public void setCn_u_major(String cn_u_major) {
		this.cn_u_major = cn_u_major;
	}

	public int getCn_u_grade() {
		return cn_u_grade;
	}

	public void setCn_u_grade(int cn_u_grade) {
		this.cn_u_grade = cn_u_grade;
	}

	public String getCn_cm_cname() {
		return cn_cm_cname;
	}

	public void setCn_cm_cname(String cn_cm_cname) {
		this.cn_cm_cname = cn_cm_cname;
	}

	public String getCn_cm_dname() {
		return cn_cm_dname;
	}

	public void setCn_cm_dname(String cn_cm_dname) {
		this.cn_cm_dname = cn_cm_dname;
	}

	public String getCn_cm_job() {
		return cn_cm_job;
	}

	public void setCn_cm_job(String cn_cm_job) {
		this.cn_cm_job = cn_cm_job;
	}

	public String getCn_cf_cname() {
		return cn_cf_cname;
	}

	public void setCn_cf_cname(String cn_cf_cname) {
		this.cn_cf_cname = cn_cf_cname;
	}

	public String getCn_cf_nickname() {
		return cn_cf_nickname;
	}

	public void setCn_cf_nickname(String cn_cf_nickname) {
		this.cn_cf_nickname = cn_cf_nickname;
	}

	public String getCn_fm_relationship() {
		return cn_fm_relationship;
	}

	public void setCn_fm_relationship(String cn_fm_relationship) {
		this.cn_fm_relationship = cn_fm_relationship;
	}

	@Override
	public String toString() {
		return "Contact [pidx=" + pidx + ", cn_name=" + cn_name + ", cn_phonenumber=" + cn_phonenumber + ", cn_address="
				+ cn_address + ", cn_email=" + cn_email + ", kategorie=" + kategorie + ", cn_u_major=" + cn_u_major
				+ ", cn_u_grade=" + cn_u_grade + ", cn_cm_cname=" + cn_cm_cname + ", cn_cm_dname=" + cn_cm_dname
				+ ", cn_cm_job=" + cn_cm_job + ", cn_cf_cname=" + cn_cf_cname + ", cn_cf_nickname=" + cn_cf_nickname
				+ ", cn_fm_relationship=" + cn_fm_relationship + "]";
	}
	
	
}
