package manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import phonebook.ConnectionProvider;
import phonebook.Contact;

public class ContactManager{

	ContactDao daoCon = new ContactDao();
	Contact cont = null;
	int select = 0;
	int resultCnt=0;



	public void contactInsert() {

		// 기본정보 입력
		System.out.println("일련번호: ");
		int pidx = Integer.parseInt(ContactMain.input.nextLine());
		System.out.println("친구 이름 : ");
		String cn_name = ContactMain.input.nextLine();
		System.out.println("전화번호 : ");
		String cn_phonenumber = ContactMain.input.nextLine();
		System.out.println("주소 : ");
		String cn_address = ContactMain.input.nextLine();
		System.out.println("이메일 : ");
		String cn_email = ContactMain.input.nextLine();

		// 사용자 카테고리 선택
		System.out.println("정보를 저장할 카테고리를 선택해주세요.");
		System.out.println("1. 대학친구	2. 직장동료	3. 카페회원	4. 가족	5. 저장 취소");
		select = Integer.parseInt(ContactMain.input.nextLine());

		switch (select) {

		case 1:
			String kategorie = "univ";
			System.out.println("전공 : ");
			String cn_u_major = ContactMain.input.nextLine();
			System.out.println("학년 : ");
			int cn_u_grade = Integer.parseInt(ContactMain.input.nextLine());

			String cn_cm_cname = null;
			String cn_cm_dname = null;
			String cn_cm_job = null;
			String cn_cf_cname = null;
			String cn_cf_nickname = null;
			String cn_fm_relationship = null;
			cont = new  Contact(pidx, cn_name, cn_phonenumber,  cn_address, cn_email, kategorie, 
					cn_u_major, cn_u_grade, 
					cn_cm_cname, cn_cm_dname, cn_cm_job, 
					cn_cf_cname, cn_cf_nickname, 
					cn_fm_relationship);

			resultCnt = daoCon.contactInsert(cont);

			if (resultCnt > 0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
			}
			break;

		case 2:
			kategorie = "com";
			cn_u_major = null;
			cn_u_grade = 0;

			System.out.println("회사명 : ");
			cn_cm_cname = ContactMain.input.nextLine();
			System.out.println("부서명 : ");
			cn_cm_dname = ContactMain.input.nextLine();
			System.out.println("직급 : ");
			cn_cm_job = ContactMain.input.nextLine();

			cn_cf_cname = null;			
			cn_cf_nickname = null;
			cn_fm_relationship = null;
			cont = new  Contact(pidx, cn_name, cn_phonenumber,  cn_address, cn_email, kategorie, 
					cn_u_major, cn_u_grade, 
					cn_cm_cname, cn_cm_dname, cn_cm_job, 
					cn_cf_cname, cn_cf_nickname, 
					cn_fm_relationship);
			resultCnt = daoCon.contactInsert(cont);

			if (resultCnt > 0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
			}
			break;

		case 3:
			kategorie="cafe";

			cn_u_major = null;
			cn_u_grade = 0;
			cn_cm_cname = null;
			cn_cm_dname = null;
			cn_cm_job = null;

			System.out.println("카페이름 : ");
			cn_cf_cname = ContactMain.input.nextLine();
			System.out.println("닉네임 : ");
			cn_cf_nickname = ContactMain.input.nextLine();

			cn_fm_relationship = null;
			cont = new  Contact(pidx, cn_name, cn_phonenumber,  cn_address, cn_email, kategorie, 
					cn_u_major, cn_u_grade, 
					cn_cm_cname, cn_cm_dname, cn_cm_job, 
					cn_cf_cname, cn_cf_nickname, 
					cn_fm_relationship);
			resultCnt = daoCon.contactInsert(cont);

			if (resultCnt > 0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
			}
			break;

		case 4:
			kategorie="family";
			cn_u_major = null;
			cn_u_grade = 0;
			cn_cm_cname = null;
			cn_cm_dname = null;
			cn_cm_job = null;
			cn_cf_cname = null;
			cn_cf_nickname = null;

			System.out.println("가족과의 관계 : ");
			cn_fm_relationship = ContactMain.input.nextLine();
			cont = new  Contact(pidx, cn_name, cn_phonenumber,  cn_address, cn_email, kategorie, 
					cn_u_major, cn_u_grade, 
					cn_cm_cname, cn_cm_dname, cn_cm_job, 
					cn_cf_cname, cn_cf_nickname, 
					cn_fm_relationship);
			resultCnt = daoCon.contactInsert(cont);

			if (resultCnt > 0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
			}
			break;

		case 5: 
			System.out.println("정보저장을 취소합니다. 상위 메뉴로 돌아갑니다.");
			return;
		}
		return;
	}

	public void contList() {
		List<Contact> contList = daoCon.contList();

		if(contList != null && !contList.isEmpty()) {

			for(int i = 0; i< contList.size(); i++) {
				System.out.printf("%5s", contList.get(i).getPidx() + "\t");
				System.out.printf("%12s", contList.get(i).getCn_name() + "\t");
				System.out.printf("%20s", contList.get(i).getCn_phonenumber() + "\t");
				System.out.printf("%15s", contList.get(i).getCn_address() + "\t");
				System.out.printf("%15s", contList.get(i).getCn_email() + "\t");
				System.out.printf("%10s", contList.get(i).getKategorie() + "\t");
				System.out.printf("%12s", contList.get(i).getCn_u_major() + "\t");
				System.out.printf("%5s", contList.get(i).getCn_u_grade() + "\t");
				System.out.printf("%12s", contList.get(i).getCn_cm_cname()+ "\t");
				System.out.printf("%12s", contList.get(i).getCn_cm_dname() + "\t");
				System.out.printf("%12s", contList.get(i).getCn_cm_job() + "\t");
				System.out.printf("%12s", contList.get(i).getCn_cf_cname() + "\t");
				System.out.printf("%12s", contList.get(i).getCn_cf_nickname() + "\t");
				System.out.printf("%12s", contList.get(i).getCn_fm_relationship() + "\n");
			}
		}else {
			System.out.println("저장된 전화번호가 없습니다.");
		}
	}

	public void contSearch() {
		System.out.println("검색하고자 하는 친구이름 : ");
		String searchName = ContactMain.input.nextLine();

		List<Contact> list = daoCon.contSearch(searchName);

		System.out.println("검색 결과");
		System.out.println("────────────────────────────────────────────");
		for (Contact c : list) {
			System.out.printf("%5s", c.getPidx() + "\t");
			System.out.printf("%12s", c.getCn_name() + "\t");
			System.out.printf("%20s", c.getCn_phonenumber() + "\t");
			System.out.printf("%15s", c.getCn_address() + "\t");
			System.out.printf("%15s", c.getCn_email() + "\t");
			System.out.printf("%10s", c.getKategorie() + "\t");
			System.out.printf("%12s", c.getCn_u_major() + "\t");
			System.out.printf("%5s", c.getCn_u_grade() + "\t");
			System.out.printf("%12s", c.getCn_cm_cname()+ "\t");
			System.out.printf("%12s", c.getCn_cm_dname() + "\t");
			System.out.printf("%12s", c.getCn_cm_job() + "\t");
			System.out.printf("%12s", c.getCn_cf_cname() + "\t");
			System.out.printf("%12s", c.getCn_cf_nickname() + "\t");
			System.out.printf("%12s", c.getCn_fm_relationship() + "\n");
		}
		System.out.println("────────────────────────────────────────────");

	}

	public void contDelete() {
		System.out.println("삭제하고자 하는 친구이름 입력 : ");
		String searchName = ContactMain.input.nextLine();

		int resultCnt = daoCon.contDelete(searchName);

		if (resultCnt < 1) {
			System.out.println("삭제할 정보가 검색 결과가 없습니다.");
		} else {
			System.out.println(resultCnt + "행이 삭제 되었습니다.");
		}

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}

	public void contChangeInfo() {
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			conn.setAutoCommit(false); 
			
			System.out.println("수정하고자 하는 친구의 이름 : ");
			String searchName = ContactMain.input.nextLine();

			// 1. 수정하고자 하는 데이터 유무 확인
			int rowCnt = daoCon.contSearchCount(searchName, conn);
			// System.out.println(rowCnt);

			if (rowCnt > 0) {

				Contact cont = daoCon.contSearchName(searchName, conn);

				if (cont == null) {
					System.out.println("찾으시는 이름의 정보가 존재하지않습니다.");
					return;
				}

				// 사용자 입력정보 변수
				System.out.println("부서 정보를 입력해주세요.");

				System.out.println("일련 번호 : " + cont.getPidx());
				System.out.println("일련 번호는 수정되지 않습니다.");

				System.out.println("친구 이름 ( " + cont.getCn_name()+" ) :" );
				String cn_name = ContactMain.input.nextLine();

				System.out.println("전화번호 ( " + cont.getCn_phonenumber() + "  ) : ");
				String cn_phonenumber = ContactMain.input.nextLine();

				System.out.println("주소 ( " + cont.getCn_address() + "  ) : ");
				String cn_address = ContactMain.input.nextLine();

				System.out.println("이메일 ( " + cont.getCn_email() + "  ) : ");
				String cn_email = ContactMain.input.nextLine();
				
				// 카테고리 확인을 통한 정보수정 (추가중)
/*				String checkKategorie = cont.getKategorie();
				switch(checkKategorie) {
				case "univ" :
					System.out.println("학과 ( " + cont.getCn_u_major() + " ) : ");
					String cn_u_major = ContactMain.input.nextLine();
					System.out.println("학년 ( " + cont.getCn_u_grade() + " ) : ");
					int cn_u_grade = Integer.parseInt(ContactMain.input.nextLine());
					
					Contact newUniv = new Contact(cont.getPidx(), cn_name, cn_phonenumber, cn_address, cn_email, cont.getKategorie(), cn_u_major, cn_u_grade,
							cont.getCn_cm_cname(), cont.getCn_cm_dname(), cont.getCn_cm_job(), cont.getCn_cf_cname(), cont.getCn_cf_nickname(), cont.getCn_fm_relationship());
					break;
					
				case "com" :
					System.out.println("회사명 ( " + cont.getCn_cm_cname() + "  ) : ");
					String cn_cm_cname = ContactMain.input.nextLine();

					System.out.println("부서명 ( " + cont.getCn_cm_dname() + "  ) : ");
					String cn_cm_dname = ContactMain.input.nextLine();

					System.out.println("직책 ( " + cont.getCn_cm_job() + "  ) : ");
					String cn_cm_job = ContactMain.input.nextLine();
					Contact newCom = new Contact(cont.getPidx(), cn_name, cn_phonenumber, cn_address, cn_email, cont.getKategorie(), cont.getCn_u_major(), cont.getCn_u_grade(),
							cn_cm_cname, cn_cm_dname, cn_cm_job, cont.getCn_cf_cname(), cont.getCn_cf_nickname(), cont.getCn_fm_relationship());
					break;
					
				case "cafe" :
					System.out.println("카페명 ( " + cont.getCn_cf_cname() + "  ) : ");
					String cn_cf_cname = ContactMain.input.nextLine();

					System.out.println("닉네임 ( " + cont.getCn_cf_nickname() + "  ) : ");
					String cn_cf_nickname = ContactMain.input.nextLine();
					
					Contact newCafe = new Contact(cont.getPidx(), cn_name, cn_phonenumber, cn_address, cn_email, cont.getKategorie(), cont.getCn_u_major(), cont.getCn_u_grade(),
					cont.getCn_cm_cname(), cont.getCn_cm_dname(), cont.getCn_cm_job(), cn_cf_cname,  cn_cf_nickname, cont.getCn_fm_relationship());
					break;
					
				case "family" :
					System.out.println("가족관계 ( " + cont.getCn_fm_relationship() + "  ) : ");
					String cn_fm_relationship = ContactMain.input.nextLine();
					
					Contact newFamily = new Contact(cont.getPidx(), cn_name, cn_phonenumber, cn_address, cn_email, cont.getKategorie(), cont.getCn_u_major(), cont.getCn_u_grade(),
					cont.getCn_cm_cname(), cont.getCn_cm_dname(), cont.getCn_cm_job(), cont.getCn_cf_cname(), cont.getCn_cf_nickname(), cn_fm_relationship);
					break;
				}*/
				
				Contact newCont = new Contact(cont.getPidx(), cn_name, cn_phonenumber, cn_address, cn_email, cont.getKategorie(), cont.getCn_u_major(), cont.getCn_u_grade(),
						cont.getCn_cm_cname(), cont.getCn_cm_dname(), cont.getCn_cm_job(), cont.getCn_cf_cname(), cont.getCn_cf_nickname(), cont.getCn_fm_relationship());


				int resultCnt = daoCon.contChangeInfo(newCont, conn);

				if (resultCnt > 0) {
					System.out.println("정상적으로 수정 되었습니다.");
					System.out.println(resultCnt + "행이 수정되었습니다.");
				} else {
					System.out.println("수정이 되지않았습니다. 확인후 재 시도해주세요.");
				}
			} else {
				System.out.println("찾으시는 이름의 정보가 존재하지않습니다.");
			}

			conn.commit();

		} catch (SQLException e) {

			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("conn.close()");
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}

}


