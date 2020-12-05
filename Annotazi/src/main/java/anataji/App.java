
package anataji;

public class App {
	public static void main(String[] args) {
		var pemain = new Pemain(0L, "Sallah");

//		System.out.println(pemain);
		var repo = new Repositori<Pemain>();
		repo.simpan(pemain);
	}

}
