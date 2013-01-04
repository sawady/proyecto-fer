package persistencia.hibernateHome;

import persistencia.Entity;
import persistencia.Home;
import persistencia.HomeFactory;



public class HibernateHomeFactory extends HomeFactory {
	
	/* VARIABLES ***********************************************************************************/
	
	private ThreadLocal tl; 
	
	/* CONSTRUCTOR ***********************************************************************************/
	public HibernateHomeFactory(ThreadLocal tlocal){
		this.tl = tlocal;
	}

	/* METODOS ***********************************************************************************/
	@Override
	public Home<?> newHomeInstance(Class<?> clazz) {
		return new HibernateHome<Entity>(this.tl, (Class<Entity>) clazz);
	}

}
