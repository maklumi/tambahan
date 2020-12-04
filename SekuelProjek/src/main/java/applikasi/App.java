package applikasi;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");

		String url = "jdbc:sqlite:kucing.db";

		try {
			var conn = DriverManager.getConnection(url);
			System.out.println(conn);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
