package applikasi;

public class Pengguna {

	private int id;
	private String name;
	public Pengguna(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public Pengguna(String name) {
		this.name = name;
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

}
