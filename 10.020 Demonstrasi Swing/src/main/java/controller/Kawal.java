package controller;

import java.sql.DriverManager;
import java.sql.SQLException;

import gui.BingkaiUtama;
import gui.PanelUtama;
import model.Pengguna;
import model.PenggunaDao;
import model.PenggunaDaoImpl;

public class Kawal {
	private BingkaiUtama mainFrame;
	private PanelUtama mainPanel;

	public Kawal() {
		buatDatabase();
		PenggunaDao pengguna = new PenggunaDaoImpl();

		mainPanel = new PanelUtama();
		mainPanel.setPemerhatiBorang((nama, katalaluan) -> {
			System.out.println(nama + " : " + katalaluan);
			pengguna.simpanAtauCreate(new Pengguna(nama, katalaluan));
		});
		mainFrame = new BingkaiUtama();

		mainFrame.setContentPane(mainPanel);

	}

	private void buatDatabase() {
		String url = "jdbc:sqlite:almari.db";
		var pd = model.Pangkalandata.insta();
		try {
			var conn = DriverManager.getConnection(url);
			pd.setSambunganSql(conn);
//			var stmt = conn.createStatement();

//			var sql = "create table if not exists user (id integer primary key autoincrement, name text not null, password text not null)";
//			stmt.execute(sql);

//			stmt.close();
//			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
}
