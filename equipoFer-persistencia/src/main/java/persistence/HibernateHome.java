package persistence;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import appModel.Entity;
import appModel.Home;

public class HibernateHome<T extends Entity> implements Home<T>{
	//home que se encarga d las operaciones d la session

	private Session session;
	private Class<T> clazz;
	
	public HibernateHome(Session session, Class<T> clazz){
		this.session = session;
		this.clazz = clazz;
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

	@SuppressWarnings("unchecked")
	public T getWithId(int id) {
		return (T) this.session.createCriteria(this.clazz).add(Restrictions.idEq(id)).uniqueResult();
	}

}
