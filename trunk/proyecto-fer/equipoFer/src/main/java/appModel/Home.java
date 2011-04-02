package appModel;


public interface Home<T extends Entity>  {
	
	// ********************************************************
	// ** ABM
	// ********************************************************
	
	public void agregar(T object);

	public void eliminar(T object);
	
	public void actualizar(T object);

}
