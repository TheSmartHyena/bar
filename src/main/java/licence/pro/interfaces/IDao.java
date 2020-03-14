package licence.pro.interfaces;

import java.util.List;

public interface IDao<T> {

	void create(T objet);

	void update(T objet);

	void delete(T objet);

	T read();

	List<T> getList();
}
