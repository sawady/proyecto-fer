package persistence;

import org.hibernate.Session;

import appModel.Entity;
import appModel.Home;
import appModel.HomeFactory;

public class HibernateHomeFactory extends HomeFactory {
	
	private Session session; 
	
	public HibernateHomeFactory(Session session){
		this.session = session;
	}

	@Override
	public Home<?> newHomeInstance(Class<?> clazz) {
		return new HibernateHome<Entity>(this.session, (Class<Entity>) clazz);
	}

}
