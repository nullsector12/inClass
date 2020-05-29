package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ex {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection conn = null;

		// 1. DB = 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 드라이버 로드 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "gkskvhqnvhtn123";

			//2. 데이터베이스 접속
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");


			//3. sql로 데이터 처리
			Statement stmt = conn.createStatement();
			String sql = "select * from dept order by deptno";

			/*
			 * Select 의 결과는 ResultSet 이 받는다.
			 * executeQuery(sql문) - > ResultSet
			 * */
			ResultSet rs = stmt.executeQuery(sql);

			//ResultSet : next() -> 행의 존재 유무 확인

			while(rs.next()) {
				System.out.println(rs.getInt("deptno" + "\t"));
				System.out.println(rs.getString("dname"+ "\t"));
				System.out.println(rs.getString("loc"+ "\t"));

			}
			rs.close();
			stmt.close();
			// commit : 처리완료
			conn.commit();
			//4.  close
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
