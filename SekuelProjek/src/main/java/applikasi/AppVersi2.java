package applikasi;

import java.sql.SQLException;

public class AppVersi2 {

	public static void main(String[] args) {
		var pd = Pangkalandata.insta();

		try {
			pd.buatSambungan();
		} catch (SQLException e) {
			System.out.println("gagal sambung");
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
