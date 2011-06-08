package persistence.hibernate;

import appModel.Entity;
import appModel.Home;
import appModel.HomeFactory;

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
