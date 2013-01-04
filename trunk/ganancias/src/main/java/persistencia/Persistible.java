package persistencia;

public interface Persistible {
	
	/* METODOS/////////////////////////////////////////////////////////////////////////////////*/
	
	public int getId();
	public void setId(int id);
	public int getVersion();
	public void setVersion(int version);

}