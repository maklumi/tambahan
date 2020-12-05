package applikasi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Pangkalandata {

	private static Pangkalandata pd = new Pangkalandata();
	private static final String alamatPangkalan = "jdbc:sqlite:kucing.db";
	private Connection sambunganSql;

	public static Pangkalandata insta() {
		return pd;
	}

	private Pangkalandata() {
	}

	public Connection getSambunganSql() {
		return sambunganSql;
	}

	public void buatSambungan() throws SQLException {
		sambunganSql = DriverManager.getConnection(alamatPangkalan);
	}

	public void tutupSambungan() throws SQLException {
		sambunganSql.close();
	}

}
