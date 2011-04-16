package persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import appModel.UserApplication;

public class HibernateApplication {
	
	private SessionFactory sessionFactory;
	
	public HibernateApplication(){
		this.sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public HibernateUserApplication getUserApplication(){
		Session session = this.sessionFactory.openSession();
		
		ThreadLocal<Session> tl = new ThreadLocal<Session>();
		
		return new HibernateUserApplication(session);
	}

}
