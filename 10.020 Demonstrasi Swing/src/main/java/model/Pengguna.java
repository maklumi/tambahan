package model;

public class Pengguna {

	private int id;
	private String name;
	private String password;
	
	public Pengguna(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.setPassword(password);
	}
	public Pengguna(String name, String password) {
		this.name = name;
		this.setPassword(password);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Pengguna [id=" + id + " , nama="+name+"]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
