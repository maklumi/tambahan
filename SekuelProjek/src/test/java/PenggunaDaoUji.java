import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import applikasi.AppVersi2;
import applikasi.Pangkalandata;
import applikasi.Pengguna;
import applikasi.PenggunaDao;
import applikasi.PenggunaDaoImpl;

public class PenggunaDaoUji {

	private Connection samb;
	private List<Pengguna> lisPengguna;

	private List<Pengguna> buatPengguna() throws IOException {
		var stream = this.getClass().getResourceAsStream("/greatexpectation.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		StringTokenizer t;

		Set<String> s = new HashSet<String>();
		while (reader.ready()) {
			String line = reader.readLine();
			t = new StringTokenizer(line);
			while (t.hasMoreTokens()) {
				s.add(t.nextToken());
			}
		}
//		@formatter:off
		lisPengguna = s.stream()
				.filter(item -> item.length() > 3 && item.length() < 10)
				.map(word -> new Pengguna(word))
				.collect(Collectors.toList());

//		@formatter:on
		return lisPengguna;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		buatPengguna();
		Properties props = new Properties();
		String failSetting = String.format("/settingpangkalandata.%s.properties", "dev");
		props.load(AppVersi2.class.getResourceAsStream(failSetting));
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

	@Test
	public void testSimpanPengguna() throws SQLException {
//		assertTrue("hi", true);
//		assertNotNull(pd);
		Pengguna a = new Pengguna("Pengguna 1");
		PenggunaDao dao = new PenggunaDaoImpl();
		dao.simpanAtauCreate(a);
		Statement stmt;
		ResultSet rs;

		stmt = samb.createStatement();
		rs = stmt.executeQuery("select id, name from user order by id desc");

		assertTrue(rs.next());
		assertEquals(rs.getString("name"), "Pengguna 1");

	}

	@Test
	public void cubaSimpanSeribuPengguna() throws IOException, SQLException {
		PenggunaDao dao = new PenggunaDaoImpl();
		for (var u : lisPengguna) {
			dao.simpanAtauCreate(u);
		}

		var stmt = samb.createStatement();
		var rs = stmt.executeQuery("select max(id) as id from user");
		rs.next();

		var iden = rs.getInt("id");
		stmt.close();

		assertEquals(iden, 1042);

	}

	private List<Pengguna> dapatkanDataDalamLingkungan(int min, int maks) throws SQLException {
		List<Pengguna> lisP = new ArrayList<Pengguna>();

		var stmt = samb.prepareStatement("select id, name from user where id >= ? and id <= ?");
		stmt.setInt(1, min);
		stmt.setInt(2, maks);

		var rs = stmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			var pengguna = new Pengguna(id, name);
			lisP.add(pengguna);
		}

		stmt.close();

		return lisP;
	}

	@Test
	public void periksaBilangan() throws SQLException {
		assertEquals(11, dapatkanDataDalamLingkungan(10, 20).size());
	}

	@Test
	public void testPadamPengguna() throws SQLException {
		PenggunaDao dao = new PenggunaDaoImpl();

		Pengguna g = lisPengguna.get(4);
		dao.padamAtauDelete(g);
		System.out.println(g);
		
	}
}
