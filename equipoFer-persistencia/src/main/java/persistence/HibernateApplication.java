package persistence;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import appModel.HomeFactory;
import appModel.UserApplication;

public class HibernateApplication extends UserApplication {
	
	//inicia la secion del hibernate
	public static HibernateApplication instance;
	private SessionFactory sessionFactory;
	private ThreadLocal<Session> tl;
	
	public static HibernateApplication getInstance(){
		if(instance == null){
			initialize();
		}
		return instance;
	}
	
	private static void initialize() {
		ThreadLocal<Session> tlocal = new ThreadLocal<Session>();
		instance = new HibernateApplication(new HibernateHomeFactory(tlocal));
		instance.sessionFactory = new Configuration().configure().buildSessionFactory();
		instance.tl = tlocal;
		
	}
	
	public HibernateApplication(HomeFactory factory) {
		super(factory);
	}
	
	public void execute(Action action){
		Session session = this.sessionFactory.openSession();
		this.tl.set(session);
		Transaction transaction = session.beginTransaction();
		
		try{
			action.execute();
			transaction.commit();
		}
		catch(RuntimeException e) {
			transaction.rollback();
			throw e;
		}
		finally {
			session.close();
		}
	}

}
