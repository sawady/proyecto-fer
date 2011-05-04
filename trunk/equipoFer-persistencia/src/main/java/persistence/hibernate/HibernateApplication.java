package persistence.hibernate;


import model.PartidoSimple;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import persistence.actions.Action;

import appModel.HomeFactory;
import appModel.Application;

public class HibernateApplication extends Application {
	
	//inicia la secion del hibernate
	public static HibernateApplication instance;
	private SessionFactory sessionFactory;
	private ThreadLocal<Session> tl;
	
	public static synchronized HibernateApplication getInstance(){
		if(instance == null){
			instance = initialize();
		}
		return instance;
	}
	
	private static HibernateApplication initialize() {
		ThreadLocal<Session> tlocal = new ThreadLocal<Session>();
		HibernateApplication instance = new HibernateApplication(new HibernateHomeFactory(tlocal), tlocal);
		instance.sessionFactory = new Configuration().configure().buildSessionFactory();
		instance.tl = tlocal;
		return instance;
		
	}
	
	public HibernateApplication(HomeFactory factory, ThreadLocal<Session> tlocal) {
		super(factory);
		this.getHomes().put(PartidoSimple.class, new HibernatePartidoSimpleHome(tlocal));
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
