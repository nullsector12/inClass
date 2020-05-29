package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Scott_ex {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection conn = null;
//		ResultSet rs = null;
		ResultSet rs1 = null;
		Scanner input = new Scanner(System.in);

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

			
			System.out.println("검색하실 고객명 입력");
			String searchCustName = input.nextLine();
			
			//3. sql로 데이터 처리
			Statement stmt = conn.createStatement();
//			String sql = "select * from emp order by deptno";
			String sql1 = "select o.orderid, c.name, b.bookname from customer c, book b, orders o "
					+ "where c.custid = o.custid and o.bookid = b.bookid and c.name = "+ "'"+ searchCustName+"'" ;

			/*
			 * Select 의 결과는 ResultSet 이 받는다.
			 * executeQuery(sql문) - > ResultSet
			 * */
//			rs = stmt.executeQuery(sql);
			rs1 = stmt.executeQuery(sql1);

			//ResultSet : next() -> 행의 존재 유무 확인

//			System.out.println("───────────────────────────────────────────────────");
//			System.out.println("  사원번호 \t 사원명 \t 담당업무");
//			System.out.println("───────────────────────────────────────────────────");
			
			
			
			System.out.println("───────────────────────────────────────────────────");
			System.out.println("주문번호	고객명	책이름");
			while(rs1.next()) {
				
				System.out.println(rs1.getInt("orderid")+"\t"+rs1.getString("name")+"\t"+rs1.getString("bookname"));
//				System.out.println("\t"+ rs.getInt("empno") + "\t" + rs.getString("ename") + "\t"+rs.getString("job"));
			
				
				//System.out.println(rs.getString("job")+ "\t");
				//System.out.println(rs.getString("hiredate")+"\n");
				

			}
//			rs.close();
			rs1.close();
			stmt.close();
			input.close();
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
