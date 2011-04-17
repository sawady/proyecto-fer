package persistence;

import org.hibernate.Session;

import appModel.Entity;
import appModel.Home;

public class HibernateHome<T extends Entity> implements Home<T>{
	//home que se encarga d las operaciones d la session

	private Session session;
	
	public HibernateHome(Session session){
		this.session = session;
	}
	
	public void agregar(T object) {
		this.session.save(object);
	}

	public void eliminar(T object) {
		this.session.delete(object);
	}

	public void actualizar(T object) {
		this.session.update(object);
	}

}
