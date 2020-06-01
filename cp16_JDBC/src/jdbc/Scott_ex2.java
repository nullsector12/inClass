package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Scott_ex2 {


	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection conn = null;
		ResultSet rs = null;
//		ResultSet rs1 = null;


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

			

//			String searchCustName = input.nextLine();
			
			//3. sql로 데이터 처리
			String sql1 = "insert into emp (ename, empno, job, mgr, hiredate, sal, comm, deptno)"
					+ " values (?,?,?,?,?,?,?,?) ";
			
			//Statement stmt = conn.createStatement();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, "God");
			pstmt.setInt(2, 8282);
			pstmt.setString(3, "PROGRAMER");
			pstmt.setInt(4, 7788);
			pstmt.setString(5, "2020/09/14");
			pstmt.setInt(6, 3000);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 60);
			int procNum = pstmt.executeUpdate();
			
			if(procNum > 7) {
			System.out.println(procNum + " 개 행이 적용됨");
			}else {
				System.out.println("입력 실패");
			}
//			String sql1 = "select o.orderid, c.name, b.bookname from customer c, book b, orders o "
//					+ "where c.custid = o.custid and o.bookid = b.bookid and c.name = "+ "'"+ searchCustName+"'" ;

			/*
			 * Select 의 결과는 ResultSet 이 받는다.
			 * executeQuery(sql문) - > ResultSet
			 * */
			rs = pstmt.executeQuery(sql1);
			
			
//			rs1 = stmt.executeQuery(sql1);

			//ResultSet : next() -> 행의 존재 유무 확인

			System.out.println("───────────────────────────────────────────────────");
			System.out.println("  사원번호 \t 사원명 \t 담당업무");
			System.out.println("───────────────────────────────────────────────────");
			
			
			
//			System.out.println("───────────────────────────────────────────────────");
//			System.out.println("주문번호	고객명	책이름");
			while(rs.next()) {
				
//				System.out.println(rs1.getInt("orderid")+"\t"+rs1.getString("name")+"\t"+rs1.getString("bookname"));
				System.out.println("\t"+ rs.getInt("empno") + "\t" + rs.getString("ename") + "\t"+rs.getString("job"));
			
				
				//System.out.println(rs.getString("job")+ "\t");
				//System.out.println(rs.getString("hiredate")+"\n");
				

			}
			rs.close();
//			rs1.close();
			pstmt.close();
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
