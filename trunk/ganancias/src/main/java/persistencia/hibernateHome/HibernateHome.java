package persistencia.hibernateHome;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import persistencia.Entity;
import persistencia.Home;

public class HibernateHome<T extends Entity> implements Home<T>{
	
	/* VARIABLES ***********************************************************************************/

	protected ThreadLocal<Session> tlocal;
	private Class<T> clazz;
	
	/* CONSTRUCTOR ***********************************************************************************/

	public HibernateHome(ThreadLocal<Session> tl, Class<T> clazz){
		this.tlocal = tl;
		this.clazz = clazz;
	}
	/* METODOS ***********************************************************************************/
	
	////////////////////////
	// ABM               //
	///////////////////////
	public void agregar(T object) {
		this.tlocal.get().save(object);
	}
	
	public void eliminar(T object) {
		this.tlocal.get().delete(object);
	}
	
	public void actualizar(T object) {
		this.tlocal.get().update(object);
	}
	
	public void deleteAllEntities() {
// Antes!!
//		for(T obj : this.getAllEntities())
//			this.tlocal.get().delete(obj);
		this.tlocal.get().createQuery("delete from " + this.clazz.getName()).executeUpdate();
	}

	////////////////////////////
	//BUSQUEDA
	///////////////////////////
	
	@SuppressWarnings("unchecked")
	public T getWithId(int id) {
		return (T) this.getCriteria().add(Restrictions.idEq(id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllEntities() {
		//Antes -> 
		//return this.getCriteria().add(Restrictions.isNotNull("id")).list();
		return this.tlocal.get().createQuery("from " + this.clazz.getName()).list();
	}
	
	public T getFirst(){
		return this.getAllEntities().get(0);
	}

	

	
	/* GET&&SET ***********************************************************************************/
	
	protected Criteria getCriteria(){
		return this.tlocal.get().createCriteria(this.clazz);
	}
	
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

	
}
