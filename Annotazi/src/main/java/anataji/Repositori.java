package anataji;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Repositori<T> {
	public void simpan(T t) {
		var clazz = t.getClass();

		var fields = clazz.getDeclaredFields();

		for (var feel : fields) {
			var anotasis = feel.getAnnotationsByType(Lapangan.class);

			if (anotasis.length == 0) {
//				System.out.println(Arrays.asList(anotasis));
				continue;
			}

			var anne = anotasis[0];
			var namaFeel = anne.value();
			var iaKunci = anne.sejenisKunci();

			if(namaFeel.length()==0) {
				namaFeel = feel.getName();
			}
			System.out.println("nama field = " + namaFeel + " , kunci = " + iaKunci);
		}

//		@formatter:off
//		var senaraiField =Arrays
//			.stream(clazz.getDeclaredFields())
//			.filter(f -> f.getAnnotationsByType(Lapangan.class).length>0)
//			.collect(Collectors.toList());
//		
//		@formatter:on
//		
//		System.out.println();
//		System.out.println(senaraiField);
	}
}
