package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import phonebook.ConnectionProvider;
import phonebook.Contact;

public class ContactDao {

	public int contactInsert(Contact cont) {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;
		
		try {

			// Connection 객체 생성
			conn = ConnectionProvider.getConnection();

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			String sql = "insert into Contact (pidx, cn_name, cn_phonenumber, cn_address, cn_email, kategorie, cn_u_major, "
					+ "cn_u_grade, cn_cm_cname, cn_cm_dname, cn_cm_job, cn_cf_cname, cn_cf_nickname, cn_fm_relationship)   "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cont.getPidx());
			pstmt.setString(2, cont.getCn_name());
			pstmt.setString(3, cont.getCn_phonenumber());
			pstmt.setString(4, cont.getCn_address());
			pstmt.setString(5, cont.getCn_email());
			pstmt.setString(6, cont.getKategorie());
			pstmt.setString(7, cont.getCn_u_major());
			pstmt.setInt(8, cont.getCn_u_grade());
			pstmt.setString(9, cont.getCn_cm_cname());
			pstmt.setString(10, cont.getCn_cm_dname());
			pstmt.setString(11, cont.getCn_cm_job());
			pstmt.setString(12, cont.getCn_cf_cname());
			pstmt.setString(13, cont.getCn_cf_nickname());
			pstmt.setString(14, cont.getCn_fm_relationship());
			
			resultCnt = pstmt.executeUpdate();


			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		return resultCnt;

	}
}


