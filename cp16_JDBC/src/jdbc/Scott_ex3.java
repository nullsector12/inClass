package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Scott_ex3 {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. 데이터베이스 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 드라이버 로드 성공");

			// 주소 : localhost or 127 .0 .0 .1
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "gkskvhqnvhtn123";

			// 2. 데이터베이스 접속 : connection 객체 생성
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터 베이스에 접속했습니다.");

			// 3. SQL 처리
			// Statement of PreparedStatement
			// pstmt = conn.prepareStatement (SQL문장)
			String sql = "select * from emp where deptno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 30);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int deptno = rs.getInt("deptno");

				System.out.println(empno + "\t"+ ename + "\t" + deptno +"\t");
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			try {
				conn.rollback();
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
