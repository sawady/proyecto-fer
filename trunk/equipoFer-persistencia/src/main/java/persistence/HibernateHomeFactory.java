package persistence;

import appModel.Entity;
import appModel.Home;
import appModel.HomeFactory;

public class HibernateHomeFactory extends HomeFactory {
	
	private ThreadLocal tl; 
	
	public HibernateHomeFactory(ThreadLocal tlocal){
		this.tl = tlocal;
	}

	@Override
	public Home<?> newHomeInstance(Class<?> clazz) {
		return new HibernateHome<Entity>(this.tl, (Class<Entity>) clazz);
	}

}
