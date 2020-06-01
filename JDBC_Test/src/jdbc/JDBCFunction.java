package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCFunction {
	Scanner input = new Scanner(System.in);
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	// 입력기능

	public void inputEmpInfo() {

		try {
			String sql = "insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) values(?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			System.out.println("사원 번호입력");
			pstmt.setInt(1, input.nextInt());
			input.nextLine();
			System.out.println("사원 이름입력");
			pstmt.setString(2, input.nextLine());
			System.out.println("업무 입력");
			pstmt.setString(3, input.nextLine());
			System.out.println("담당관리자 사원번호 입력");
			pstmt.setInt(4, input.nextInt());
			input.nextLine();
			System.out.println("입사 날짜 입력");
			pstmt.setInt(5, input.nextInt());
			input.nextLine();
			System.out.println("연봉 입력");
			pstmt.setInt(6, input.nextInt());
			input.nextLine();
			System.out.println("추가수당 입력");
			pstmt.setInt(7, input.nextInt());
			input.nextLine();
			System.out.println("부서번호 입력");
			pstmt.setInt(8, input.nextInt());
			input.nextLine();

			int resultCnt = pstmt.executeUpdate();

			if(resultCnt > 7) {
				System.out.println("정상적으로 입력이 완료되었습니다.");
				System.out.println(resultCnt +" 행이 입력되었습니다.");
			}else {
				System.out.println("입력이 실패했습니다. 다시 입력해주세요");
				return;
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void searchInfo() {
		try {
			//System.out.println("검색할 사원명 입력");
			//String searchEmpName = input.nextLine();
			String searchSql = "select * from emp where ename =?";
			pstmt.setString(1, "SCOTT");
			pstmt = conn.prepareStatement(searchSql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				System.out.println(empno +"\t"+ ename+"\t"+ job+"\t"+mgr+"\t"+ hiredate+"\t"+sal
				+"\t"+comm +"\t"+deptno);
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public void changeInfo() {
		try {
			
			searchInfo();
			String changeSql = "insert into emp (ename, job, sal)  values (?,?,?)";
			pstmt = conn.prepareStatement(changeSql);

			System.out.println("사원 이름수정");
			pstmt.setString(1, input.nextLine());
			System.out.println("업무 수정");
			pstmt.setString(2, input.nextLine());
			System.out.println("연봉 수정");
			pstmt.setInt(3, input.nextInt());
			input.nextLine();

			int resultCnt = pstmt.executeUpdate();

			if(resultCnt > 2) {
				System.out.println("정상적으로 입력이 완료되었습니다.");
				System.out.println(resultCnt +" 행이 입력되었습니다.");
			}else {
				System.out.println("입력이 실패했습니다. 다시 입력해주세요");
				return;
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


