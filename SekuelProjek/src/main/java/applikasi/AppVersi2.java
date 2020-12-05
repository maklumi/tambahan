package applikasi;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class AppVersi2 {

	public static void main(String[] args) {

		Properties props = new Properties();

		String env = System.getProperty("env");
		if (env == null) {
			env = "dev";
		}
		String failSetting = String.format("/settingpangkalandata.%s.properties", env);
		System.out.println(failSetting);
		try {
			props.load(AppVersi2.class.getResourceAsStream(failSetting));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		var pd = Pangkalandata.insta();

		try {
			pd.buatSambungan(props);
		} catch (SQLException e) {
			System.out.println("gagal sambung");
			return;
		}

		System.out.println("Tersambung..");

		PenggunaDao penggunaDao = new PenggunaDaoImpl();

		penggunaDao.simpanAtauCreate(new Pengguna("Baba"));
		penggunaDao.padamAtauDelete(new Pengguna(18, "--"));
		((PenggunaDaoImpl) penggunaDao).kemaskinin(new Pengguna(5, "Tak Comey"));
		System.out.println("Barisan:" + penggunaDao.dapatkanAtauReadSemua().size());
		System.out.println("Pengguna id=5 ialah " + penggunaDao.cariAtauFindById(5));
		try {
			pd.tutupSambungan();
			System.out.println("..sambungan tutup.");
		} catch (SQLException e) {
			System.out.println("gagal tutup sambungan");
		}
	}

}
