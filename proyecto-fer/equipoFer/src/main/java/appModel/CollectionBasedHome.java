package appModel;

import java.util.HashSet;
import java.util.Set;

public class CollectionBasedHome<T extends Entity> implements Home<T> {

	private Set<T> collection = new HashSet<T>();
	
	@Override
	public void agregar(T object) {
		this.collection.add(object);
	}

	@Override
	public void eliminar(T object) {
		this.collection.remove(object);
	}

	@Override
	public void actualizar(T object) {
		// No hago nada
	}

}
