package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_Main {
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		while(true) {
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1. EMP 메뉴 2. DEPT 메뉴 3. 프로그램 종료");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			int selectMenu = input.nextInt();
			input.nextLine();
			switch (selectMenu) {
			case 1 : 
				empMenu();
				break;
			case 2: 
				deptMenu();
				break;
			case 3: 
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
		}
	}

	// 리스트 출력기능
	public static void allEmpInfo() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("Oracle 드라이버 로드 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "gkskvhqnvhtn123";

			//2. 데이터베이스 접속
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			stmt = conn.createStatement();
			String sql = "select * from emp order by deptno";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				System.out.println(rs.getInt(1) +"\t"+ rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+
						rs.getString(5) +"\t"+ rs.getInt(6)+"\t"+rs.getInt(7)+"\t"+rs.getInt(8));	
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			}

		}catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null ) {
				try {
					stmt.close();
				}catch(SQLException e2) {
					e2.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
		}
	}


	// 신규사원 입력기능
	public static void inputEmpInfo() {

		System.out.println("사원 번호입력");
		int empno = input.nextInt();
		input.nextLine();

		System.out.println("사원 이름입력");
		String ename = input.nextLine();

		System.out.println("업무 입력");
		String job = input.nextLine();

		System.out.println("담당관리자 사원번호 입력");
		int mgr = input.nextInt();
		input.nextLine();

		System.out.println("입사 날짜 입력");
		String hiredate = input.nextLine();

		System.out.println("연봉 입력");
		int sal = input.nextInt();
		input.nextLine();

		System.out.println("추가수당 입력");
		int comm = input.nextInt();
		input.nextLine();

		System.out.println("부서번호 입력");
		int deptno = input.nextInt();
		input.nextLine();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "gkskvhqnvhtn123";

			//2. 데이터베이스 접속
			conn = DriverManager.getConnection(url, user, pw);
			String sql = "insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) values(?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);

			pstmt.setString(2, ename);

			pstmt.setString(3, job);

			pstmt.setInt(4, mgr);

			pstmt.setString(5, hiredate);

			pstmt.setInt(6, sal);

			pstmt.setInt(7, comm);

			pstmt.setInt(8, deptno);


			int resultCnt = pstmt.executeUpdate();

			if(resultCnt > 0) {
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println("정상적으로 입력이 완료되었습니다.");
				System.out.println(resultCnt +" 행이 입력되었습니다.");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			}else {
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println("입력이 실패했습니다. 다시 입력해주세요");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				return;
			}
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(pstmt != null ) {
				try {
					pstmt.close();
				}catch(SQLException e2) {
					e2.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
		}
	}

	// 입력한 이름에 해당하는 정보 출력
	public static void searchInfo() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "gkskvhqnvhtn123";

			//2. 데이터베이스 접속
			conn = DriverManager.getConnection(url, user, pw);

			stmt = conn.createStatement();
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("검색 할 사원명을 입력해주세요.");
			String searchName = input.nextLine();
			String searchSql = "select * from emp where ename='" + searchName +"'";
			rs = stmt.executeQuery(searchSql);

			while(rs.next()) {
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println(rs.getInt(1) +"\t"+ rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+
						rs.getString(5) +"\t"+ rs.getInt(6)+"\t"+rs.getInt(7)+"\t"+rs.getInt(8));	
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			}

		}catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(stmt != null ) {
				try {
					stmt.close();
				}catch(SQLException e2) {
					e2.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
		}
	}

	// 입력된 사원명에 해당하는 정보수정
	public static void changeInfo() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "gkskvhqnvhtn123";

			//2. 데이터베이스 접속
			conn = DriverManager.getConnection(url, user, pw);

			stmt = conn.createStatement();
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("수정할 사원명을 입력해주세요.");
			String searchName = input.nextLine();
			System.out.println("변경할 사원명을 입력해주세요.");
			String changeName = input.nextLine();
			System.out.println("변경할 부서를 입력해주세요.");
			String changeJob = input.nextLine();
			System.out.println("변경할 연봉을 입력해주세요.");
			String changeSal = input.nextLine();
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			String changeSql = "update emp set ename ='" +changeName +"' , job ='" + changeJob + "' , sal="+ Integer.parseInt(changeSal) +"where ename ='" +searchName +"'";
			stmt.executeUpdate(changeSql);
			System.out.println("변경 완료");

			//			System.out.println("바뀐 정보를 확인합니다.");
			//			String checkChange = "select * from emp where ename ='" + searchName +"'";
			//			rs = stmt.executeQuery(checkChange);
			//			while(rs.next()) {
			//				System.out.println(rs.getInt(1) +"\t"+ rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+
			//						rs.getString(5) +"\t"+ rs.getInt(6)+"\t"+rs.getInt(7)+"\t"+rs.getInt(8));	
			//			}


		}catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(stmt != null ) {
				try {
					stmt.close();
				}catch(SQLException e2) {
					e2.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
		}
	}

	// 입력된 사원번호에 해당하는 정보 삭제
	public static void deleteInfo() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "gkskvhqnvhtn123";

			//2. 데이터베이스 접속
			conn = DriverManager.getConnection(url, user, pw);

			stmt = conn.createStatement();
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("삭제할 사원의 번호를 입력해주세요.");
			String searchEmpNo = input.nextLine();
			String deleteSql = "delete from emp where empno ="+ Integer.parseInt(searchEmpNo);
			stmt.executeUpdate(deleteSql);
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("삭제 완료");

		}catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(stmt != null ) {
				try {
					stmt.close();
				}catch(SQLException e2) {
					e2.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
		}
	}

	public static void empMenu() {


		while(true) {
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("EMP 메뉴 선택");
			System.out.println("1. 전체 사원리스트 2. 신규사원등록 3. 사원검색 4. 사원정보 수정 \n 5 사원정보삭제 6. 상위메뉴로");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

			int select = input.nextInt();
			input.nextLine();	
			switch (select) {
			case 1: 
				System.out.println("전체 사원 리스트를 출력합니다.");
				allEmpInfo();
				break;
			case 2:
				System.out.println("신규 사원의 정보를 등록합니다.");
				inputEmpInfo();
				break;
			case 3:
				System.out.println("사원 정보를 검색합니다.");
				searchInfo();
				break;
			case 4: System.out.println("사원 정보를 수정합니다.");
			changeInfo();
			break;
			case 5: 
				System.out.println("사원 정보를 삭제합니다.");
				deleteInfo();
				break;
			case 6: 
				System.out.println("상위 메뉴로 돌아갑니다.");
				return;
			}
		}
	}
	public static void deptMenu() {

		while(true) {
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("DEPT 메뉴 선택");
			System.out.println("1. 전체 부서리스트 2. 신규입력 3. 검색 4. 수정 5. 삭제 6. 상위메뉴로 ");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			int select = input.nextInt();
			input.nextLine();
			switch (select) {
			case 1: 
				System.out.println("DEPT 테이블의 모든 정보를 출력합니다.");
				allDeptInfo();
				break;
			case 2:
				inputDeptInfo();
				System.out.println("새로운 정보를 입력합니다.");
			break;
			case 3:
				System.out.println("부서정보를 검색합니다.");
				searchDeptInfo();
				break;
			case 4:
				System.out.println("부서정보를 변경합니다.");
				changeDeptInfo();
				break;
			case 5:
				System.out.println("부서정보를 삭제합니다.");
				deleteDeptInfo();
				break;
			case 6:
				System.out.println("상위 메뉴로 이동합니다.");
				return;
			}
		}
	}

// 모든 dept정보 출력
	public static void allDeptInfo() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 드라이버 로드 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "gkskvhqnvhtn123";

			//2. 데이터베이스 접속
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");
			stmt = conn.createStatement();
			String sql = "select * from dept order by deptno";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println(rs.getInt(1) +"\t"+ rs.getString(2)+"\t"+rs.getString(3));	
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			}

		}catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null ) {
				try {
					stmt.close();
				}catch(SQLException e2) {
					e2.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
		}
	}
	// 신규부서 입력기능
	public static void inputDeptInfo() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("부서 번호입력");
		int deptno = input.nextInt();
		input.nextLine();

		System.out.println("부서 이름입력");
		String dname = input.nextLine();

		System.out.println("지역 입력");
		String loc = input.nextLine();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "gkskvhqnvhtn123";

			//2. 데이터베이스 접속
			conn = DriverManager.getConnection(url, user, pw);

			String sql = "insert into dept (deptno, dname, loc) values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);

			pstmt.setString(2, dname);

			pstmt.setString(3, loc);

			int resultCnt = pstmt.executeUpdate();

			if(resultCnt > 0) {
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println("정상적으로 입력이 완료되었습니다.");
				System.out.println(resultCnt +" 행이 입력되었습니다.");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			}else {
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println("입력이 실패했습니다. 다시 입력해주세요");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				return;
			}
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(pstmt != null ) {
				try {
					pstmt.close();
				}catch(SQLException e2) {
					e2.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
		}
	}
	
	// 입력한 부서이름 or 지역에 해당하는 정보 출력
	public static void searchDeptInfo() {

			while(true) {
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println("메뉴 선택");
				System.out.println("1. 부서이름 검색 2. 부서지역 검색 3. 상위메뉴 이동");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				String select = input.nextLine();
				switch(Integer.parseInt(select)) {
				case 1: 
					System.out.println("부서이름으로 검색합니다.");
					searchDname();
					break;
				case 2:
					System.out.println("부서지역으로 검색합니다.");
					searchLoc();
					break;
				case 3: 
					System.out.println("상위 메뉴로 이동합니다.");
					return;
				}
			}
	}
		public static void searchDname() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				String user = "scott";
				String pw = "gkskvhqnvhtn123";
				conn = DriverManager.getConnection(url, user, pw);

				stmt = conn.createStatement();
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println("검색 할 부서명을 입력해주세요.");
				String searchDname = input.nextLine();
				String searchSql = "select * from dept where dname='" + searchDname +"'";
				rs = stmt.executeQuery(searchSql);

				while(rs.next()) {
					System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
					System.out.println(rs.getInt(1) +"\t"+ rs.getString(2)+"\t"+rs.getString(3));	
					System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				}

			}catch (ClassNotFoundException e){
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(rs != null) {
					try {
						rs.close();
					}catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				if(stmt != null ) {
					try {
						stmt.close();
					}catch(SQLException e2) {
						e2.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					}catch (SQLException e3) {
						e3.printStackTrace();
					}
				}
			}
		}
			
		public static void searchLoc() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				String user = "scott";
				String pw = "gkskvhqnvhtn123";
				conn = DriverManager.getConnection(url, user, pw);

				stmt = conn.createStatement();
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println("검색 할 부서지역을 입력해주세요.");
				String searchLoc = input.nextLine();
				String searchSql = "select * from dept where loc='" + searchLoc +"'";
				rs = stmt.executeQuery(searchSql);

				while(rs.next()) {
					System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
					System.out.println(rs.getInt(1) +"\t"+ rs.getString(2)+"\t"+rs.getString(3));	
					System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				}

			}catch (ClassNotFoundException e){
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(rs != null) {
					try {
						rs.close();
					}catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				if(stmt != null ) {
					try {
						stmt.close();
					}catch(SQLException e2) {
						e2.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					}catch (SQLException e3) {
						e3.printStackTrace();
					}
				}
			}
		}
	// 입력된 부서번호에 해당하는 정보수정
	public static void changeDeptInfo() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "gkskvhqnvhtn123";

			//2. 데이터베이스 접속
			conn = DriverManager.getConnection(url, user, pw);

			stmt = conn.createStatement();
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("수정할 부서번호를 입력해주세요.");
			String searchDeptNo = input.nextLine();
			System.out.println("변경할 부서이름을 입력해주세요.");
			String changeDname = input.nextLine();
			System.out.println("변경할 위치를 입력해주세요.");
			String changeLoc = input.nextLine();
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			String changeSql = "update dept set dname ='" +changeDname +"' , loc ='" + changeLoc + "' where deptno="+Integer.parseInt(searchDeptNo);
			stmt.executeUpdate(changeSql);
			System.out.println("변경 완료");

			//			System.out.println("바뀐 정보를 확인합니다.");
			//			String checkChange = "select * from emp where ename ='" + searchName +"'";
			//			rs = stmt.executeQuery(checkChange);
			//			while(rs.next()) {
			//				System.out.println(rs.getInt(1) +"\t"+ rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+
			//						rs.getString(5) +"\t"+ rs.getInt(6)+"\t"+rs.getInt(7)+"\t"+rs.getInt(8));	
			//			}

		}catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(stmt != null ) {
				try {
					stmt.close();
				}catch(SQLException e2) {
					e2.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
		}
	}
	// 입력된 부서번호에 해당하는 정보 삭제
	public static void deleteDeptInfo() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "gkskvhqnvhtn123";

			//2. 데이터베이스 접속
			conn = DriverManager.getConnection(url, user, pw);

			stmt = conn.createStatement();
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("삭제할 부서 번호를 입력해주세요.");
			String searchDeptNo = input.nextLine();
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			String deleteSql = "delete from dept where deptno ="+ Integer.parseInt(searchDeptNo);
			stmt.executeUpdate(deleteSql);
			System.out.println("삭제 완료");

		}catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(stmt != null ) {
				try {
					stmt.close();
				}catch(SQLException e2) {
					e2.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
		}
	}
}

