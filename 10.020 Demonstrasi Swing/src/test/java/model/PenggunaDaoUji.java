package model;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PenggunaDaoUji {

	private Connection samb;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		buatDatabase();
		Properties props = new Properties();
		String failSetting = String.format("/settingpangkalandata.%s.properties", "dev");
		props.load(PenggunaDaoUji.class.getResourceAsStream(failSetting));
		var pd = Pangkalandata.insta();

		try {
			pd.buatSambungan(props);
			samb = pd.getSambunganSql();
			samb.setAutoCommit(false);

		} catch (SQLException e) {
			System.out.println("gagal sambung");
			return;
		}
	}

	@After
	public void tearDown() throws Exception {
		Pangkalandata.insta().tutupSambungan();
	}

	private void buatDatabase() {
		String url = "jdbc:sqlite:almari.db";

		try {
			var conn = DriverManager.getConnection(url);
			System.out.println(conn);

			var stmt = conn.createStatement();

			var sql = "create table if not exists user (id integer primary key autoincrement, name text not null, password text not null)";
			stmt.execute(sql);
			
			int[] ids = { 0, 1, 2 };
			String[] names = { "ALi", "Boo", "Chac" };
			sql = "insert into user (id, name, password) values (?, ?, ?)";
			var masukStmt = conn.prepareStatement(sql);
			for (int i = 0; i < ids.length; i++) {
//				masukStmt.setInt(1, ids[i]);
				masukStmt.setString(2, names[i]);
				masukStmt.setString(3, "passwodutk" + names[i]);
//				masukStmt.executeUpdate();
			}
			masukStmt.close();

			sql = "select id, name, password from user";
			var rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String pwd = rs.getString("password");
				System.out.println("id:" + id + " , nama: " + name + ", katalaluan: " + pwd);
			}
			sql = "drop table user";
//			stmt.execute(sql);

			stmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Test
	public void testSimpanPengguna() throws SQLException {
//		assertTrue("hi", true);
//		assertNotNull(pd);
		Pengguna a = new Pengguna("Pengguna 1", "Katalaluan");
		PenggunaDao dao = new PenggunaDaoImpl();
		dao.simpanAtauCreate(a);
		Statement stmt;
		ResultSet rs;

		stmt = samb.createStatement();
		rs = stmt.executeQuery("select id, name from user order by id desc");

		assertTrue(rs.next());
		assertEquals(rs.getString("name"), "Pengguna 1");

	}

}
