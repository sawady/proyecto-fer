package appModel;

import java.util.List;


public interface Home<T extends Entity>  {
	
	// ********************************************************
	// ** ABM
	// ********************************************************
	
	public void agregar(T object);

	public void eliminar(T object);
	
	public void actualizar(T object);
	
	public T getWithId(int id);
	
	public List<T> getAllEntities();
	
	public void deleteAllEntities();
	
}
