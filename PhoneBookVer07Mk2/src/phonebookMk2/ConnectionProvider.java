package phonebookMk2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	public static Connection getConnection() {

		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String pw = "gkskvhqnvhtn123";

		try {
			conn = DriverManager.getConnection(url, user, pw);
		}catch (SQLException e ) {
			e.printStackTrace();
		}
		return conn;
	}
}
