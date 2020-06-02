package manager;

import phonebook.Contact;

public class ContactManager {

	ContactDao daoCon = new ContactDao();

	public void contactInsert() {

		// 사용자 입력정보 변수
		System.out.println("저장할 정보를 입력해주세요.");

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
		System.out.println("분류 : ");
		String kategorie = ContactMain.input.nextLine();
		System.out.println("전공 : ");
		String cn_u_major = ContactMain.input.nextLine();
		System.out.println("학년 : ");
		int cn_u_grade = Integer.parseInt(ContactMain.input.nextLine());
		System.out.println("회사명 : ");
		String cn_cm_cname = ContactMain.input.nextLine();
		System.out.println("부서명 : ");
		String cn_cm_dname = ContactMain.input.nextLine();
		System.out.println("직급 : ");
		String cn_cm_job = ContactMain.input.nextLine();
		System.out.println("카페이름 : ");
		String cn_cf_cname = ContactMain.input.nextLine();
		System.out.println("닉네임 : ");
		String cn_cf_nickname = ContactMain.input.nextLine();
		System.out.println("가족과의 관계 : ");
		String cn_fm_relationship = ContactMain.input.nextLine();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		Contact cont = new  Contact(pidx, cn_name, cn_phonenumber,  cn_address, cn_email, kategorie, 
				cn_u_major, cn_u_grade, 
				cn_cm_cname, cn_cm_dname, cn_cm_job, 
				cn_cf_cname, cn_cf_nickname, 
				cn_fm_relationship);
		
		int resultCnt = daoCon.contactInsert(cont);

		if (resultCnt > 0) {
			System.out.println("정상적으로 입력 되었습니다.");
			System.out.println(resultCnt + "행이 입력되었습니다.");
		} else {
			System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
		}

	}

}
