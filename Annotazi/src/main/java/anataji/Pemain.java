package anataji;

public class Pemain {

	@Lapangan(value = "id", sejenisKunci = true)
	private Long id;

	@Lapangan
	private String nama;

	private int nombor;

	public Pemain(Long id, String nama) {
		this.id = id;
		this.nama = nama;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

}
