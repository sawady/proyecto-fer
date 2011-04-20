package persistence;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import appModel.Entity;
import appModel.Home;

public class HibernateHome<T extends Entity> implements Home<T>{
	//home que se encarga d las operaciones d la session

	private ThreadLocal<Session> tlocal;
	private Class<T> clazz;
	
	public HibernateHome(ThreadLocal<Session> tl, Class<T> clazz){
		this.tlocal = tl;
		this.clazz = clazz;
	}
	
	public void agregar(T object) {
		this.tlocal.get().save(object);
	}

	public void eliminar(T object) {
		this.tlocal.get().delete(object);
	}

	public void actualizar(T object) {
		this.tlocal.get().update(object);
	}

	@SuppressWarnings("unchecked")
	public T getWithId(int id) {
		return (T) this.tlocal.get().createCriteria(this.clazz).add(Restrictions.idEq(id)).uniqueResult();
	}

}
