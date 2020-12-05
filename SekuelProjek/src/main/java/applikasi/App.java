package applikasi;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");

		String url = "jdbc:sqlite:kucing.db";
		// kalau guna mysql alamatnya seperti di bawah
		// url ="jdbc:mysql://localhost:3306/<tablename>?serverTimeZone=UTC"
		// dan tambah connection parameters
		// DriverManager.getConnection(url, "root","hello") <- contoh user root, pwd hello

		try {
			var conn = DriverManager.getConnection(url);
			System.out.println(conn);

			var stmt = conn.createStatement();

			var sql = "create table if not exists user (id integer primary key autoincrement, name text not null)";
			stmt.execute(sql);

//			sql = "insert into user (id, name) values (10, 'Ali M')";
//			stmt.execute(sql);
			
			int[] ids = {0,1,2};
			String[] names = {"ALi", "Boo", "Chac"};
			sql = "insert into user (id, name) values (?, ?)";
			var masukStmt = conn.prepareStatement(sql);
			for(int i = 0; i < ids.length; i++) {
//				masukStmt.setInt(1, ids[i]);
				masukStmt.setString(2,  names[i]);
				masukStmt.executeUpdate();
			}
			masukStmt.close();

			sql ="select id, name from user";
			var rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println("id:" + id + " , nama: " + name);
			}
			sql = "drop table user";
//			stmt.execute(sql);

			stmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
