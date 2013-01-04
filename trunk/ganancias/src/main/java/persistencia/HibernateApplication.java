package persistencia;


import model.entities.CamposParaCalculoAnual;
import model.entities.Empleado;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import persistencia.hibernateHome.CamposParaCalculoAnualHibernateHome;
import persistencia.hibernateHome.EmpleadoHibernateHome;
import persistencia.hibernateHome.HibernateHomeFactory;



public class HibernateApplication extends Application {
	
	/* VARIABLES*************************************************************************/
	//inicia la secion del hibernate
	public static HibernateApplication instance;
	private SessionFactory sessionFactory;
	private ThreadLocal<Session> tl;
	
	/*CONSTRUCTOR *************************************************************************/
	public static synchronized HibernateApplication getInstance(){
		if(instance == null){
			instance = initialize();
		}
		return instance;
	}
	
	public HibernateApplication(HomeFactory factory, ThreadLocal<Session> tlocal) {
		super(factory);
		this.getHomes().put(Empleado.class, new EmpleadoHibernateHome(tlocal));
		this.getHomes().put(CamposParaCalculoAnual.class, new CamposParaCalculoAnualHibernateHome(tlocal));
	}
	
	/* METODOS*************************************************************************/
	
	private static HibernateApplication initialize() {
		ThreadLocal<Session> tlocal = new ThreadLocal<Session>();
		HibernateApplication instance = new HibernateApplication(new HibernateHomeFactory(tlocal), tlocal);
		instance.sessionFactory = new Configuration().configure().buildSessionFactory();
		instance.tl = tlocal;
		return instance;
		
	}
	
//	public void execute(Action action){
//		Session session = this.sessionFactory.openSession();
//		this.tl.set(session);
//		Transaction transaction = session.beginTransaction();
//		
//		try{
//			action.execute();
//			transaction.commit();
//		}
//		catch(RuntimeException e) {
//			transaction.rollback();
//			throw e;
//		}
//		finally {
//			session.close();
//		}
//	}

}
