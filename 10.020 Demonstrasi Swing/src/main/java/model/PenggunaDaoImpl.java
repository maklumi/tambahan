package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PenggunaDaoImpl implements PenggunaDao {

	@Override
	public void simpanAtauCreate(Pengguna p) {
		var conn = Pangkalandata.insta().getSambunganSql();

		try {
			var stmt = conn.prepareStatement("insert into user (name, password) values (?,?)");

			stmt.setString(1, p.getName());
			stmt.setString(2, p.getPassword());

			stmt.executeUpdate();

			stmt.close();
		} catch (SQLException e) {
			throw new DaoError(e);
		}

	}

	@Override
	public Optional<Pengguna> cariAtauFindById(int id) {
		var conn = Pangkalandata.insta().getSambunganSql();
		Optional<Pengguna> pengguna;
		try {
			var stmt = conn.prepareStatement("select name,password from user where id=?");
			stmt.setInt(1, id);
			var rs = stmt.executeQuery();

			var name = rs.getString("name");
			var pwd = rs.getString("password");
			pengguna = Optional.ofNullable(new Pengguna(id, name, pwd));
			stmt.close();
		} catch (SQLException e) {
			throw new DaoError(e);
		}
		return pengguna;
	}

	@Override
	public void padamAtauDelete(Pengguna p) {
		var conn = Pangkalandata.insta().getSambunganSql();
		try {
			var stmt = conn.prepareStatement("delete from user where id=?");
			stmt.setInt(1, p.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {

			throw new DaoError(e);
		}
	}

	@Override
	public List<Pengguna> dapatkanAtauReadSemua() {
		var conn = Pangkalandata.insta().getSambunganSql();

		List<Pengguna> lisPengguna = new ArrayList<Pengguna>();

		try {
			var stmt = conn.createStatement();

			var rs = stmt.executeQuery("select id, name, password from user");

			while (rs.next()) {
				var id = rs.getInt("id");
				var name = rs.getString("name");
				var pwd = rs.getString("password");
				lisPengguna.add(new Pengguna(id, name, pwd));
			}

			stmt.close();
		} catch (SQLException e) {
			throw new DaoError(e);
		}

		return lisPengguna;
	}

	public void kemaskinin(Pengguna p) {
		var conn = Pangkalandata.insta().getSambunganSql();
		try {
			var stmt = conn.prepareStatement("update user set name=?, password=? where id=?");
			stmt.setInt(3, p.getId());
			stmt.setString(2, p.getPassword());
			stmt.setString(1, p.getName());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new DaoError(e);
		}
	}

}
