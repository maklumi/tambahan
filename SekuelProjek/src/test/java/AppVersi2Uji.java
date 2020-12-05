import static org.junit.Assert.*;

import org.junit.Test;

public class AppVersi2Uji {

	@Test
	public void test() {
		var props = System.getProperty("env");
		if (props == null) {
			props = "ada";
		}
		assertNotNull("props tidak kosong", props);
		assertEquals("cek sama tak", "ada", props);
	}
	
	

}
