package persistence.hibernate;

import java.util.List;

import model.util.Nombrable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import appModel.Entity;
import appModel.Home;

public class HibernateHome<T extends Entity> implements Home<T>{

	private ThreadLocal<Session> tlocal;
	private Class<T> clazz;
	
	public ThreadLocal<Session> getTlocal() {
		return tlocal;
	}

	public void setTlocal(ThreadLocal<Session> tlocal) {
		this.tlocal = tlocal;
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

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
	
	private Criteria getCriteria(){
		return this.tlocal.get().createCriteria(this.clazz);
	}

	@SuppressWarnings("unchecked")
	public T getWithId(int id) {
		return (T) this.getCriteria().add(Restrictions.idEq(id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllEntities() {
		return this.getCriteria().add(Restrictions.isNotNull("id")).list();
	}

	public void deleteAllEntities() {
		for(T obj : this.getAllEntities())
			this.tlocal.get().delete(obj);
	}

	@SuppressWarnings("unchecked")
	public T getNombrable(String nombre) {
		return (T) this.getCriteria().add(Restrictions.like("nombre", nombre)).uniqueResult();
	}

}
