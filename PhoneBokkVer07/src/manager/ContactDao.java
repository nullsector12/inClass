package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import phonebook.ConnectionProvider;
import phonebook.Contact;

public class ContactDao {

	public int contactInsert(Contact cont) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;

		try {

			conn = ConnectionProvider.getConnection();

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


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		}
		return resultCnt;
	}

	public List<Contact> contList() {


		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Contact> contList= new ArrayList<>();

		try {
			// 2. 데이터베이스 연결
			conn = ConnectionProvider.getConnection();

			String sql = "select * from contact  order by pidx";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);


			while (rs.next()) {

				Contact cont = new Contact(

						rs.getInt("pidx"),
						rs.getString("cn_name"),
						rs.getString("cn_phonenumber"),
						rs.getString("cn_address"),
						rs.getString("cn_email"),
						rs.getString("kategorie"),
						rs.getString("cn_u_major"),
						rs.getInt("cn_u_grade"),
						rs.getString("cn_cm_cname"),
						rs.getString("cn_cm_dname"),
						rs.getString("cn_cm_job"),
						rs.getString("cn_cf_cname"),
						rs.getString("cn_cf_nickname"),
						rs.getString("cn_fm_relationship")
						);

				contList.add(cont);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return contList;
	}

	public List<Contact> contSearch(String cn_name){

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		List<Contact> list = new ArrayList<Contact>();


		try {

			conn = ConnectionProvider.getConnection();
			String sql = "select * from contact  where cn_name like '%'||?||'%'";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cn_name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Contact(
						rs.getInt("pidx"),
						rs.getString("cn_name"),
						rs.getString("cn_phonenumber"),
						rs.getString("cn_address"),
						rs.getString("cn_email"),
						rs.getString("kategorie"),
						rs.getString("cn_u_major"),
						rs.getInt("cn_u_grade"),
						rs.getString("cn_cm_cname"),
						rs.getString("cn_cm_dname"),
						rs.getString("cn_cm_job"),
						rs.getString("cn_cf_cname"),
						rs.getString("cn_cf_nickname"),
						rs.getString("cn_fm_relationship")
						));
			}
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
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		}

		return list;
	}

	public int contDelete (String cn_name) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;


		try {
			conn = ConnectionProvider.getConnection();

			String sql = "delete from contact  where cn_name=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cn_name);

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		return resultCnt;
		
	}

	public int contChangeInfo(Contact newCont, Connection conn) {

		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;


		try {

			String sql = "update contact  set  cn_name=?, cn_phonenumber=?, cn_address=?, cn_email=? " + " where pidx=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newCont.getCn_name());
			pstmt.setString(2, newCont.getCn_phonenumber());
			pstmt.setString(3, newCont.getCn_address());
			pstmt.setString(4, newCont.getCn_email());
			pstmt.setInt(5, newCont.getPidx());

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		return resultCnt;
	}
	
	public int contSearchCount(String searchName, Connection conn) {
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		int rowCnt = 0;

		try {
			String sql = "select count(*) from contact where cn_name=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				rowCnt = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCnt;
	}

	public Contact contSearchName(String searchName, Connection conn) {
		Contact cont = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from contact where cn_name=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				cont = new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)
						, rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cont;
	}
	
}





