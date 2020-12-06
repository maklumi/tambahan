package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Pangkalandata {

	private static Pangkalandata pd = new Pangkalandata();
//	private static final String alamatPangkalan = "jdbc:sqlite:kucing.db";
	private Connection sambunganSql;

	public static Pangkalandata insta() {
		return pd;
	}

	private Pangkalandata() {
	}

	public Connection getSambunganSql() {
		return sambunganSql;
	}

	public void buatSambungan(Properties props) throws SQLException {
		String server = props.getProperty("pelayan");
		String database = props.getProperty("namapangkalan");
//		sambunganSql = DriverManager.getConnection(alamatPangkalan);
		sambunganSql = DriverManager.getConnection(server + database);
	}

	public void setSambunganSql(Connection sambungan) {
		this.sambunganSql = sambungan;
	}

	public void tutupSambungan() throws SQLException {
		sambunganSql.close();
	}

}
