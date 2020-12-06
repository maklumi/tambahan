package model;

import java.util.List;
import java.util.Optional;

public interface Dao<Apaje> {
	void simpanAtauCreate(Apaje T);

	Optional<Apaje> cariAtauFindById(int id);

	void padamAtauDelete(Apaje T);
	
	List<Apaje> dapatkanAtauReadSemua();
}
