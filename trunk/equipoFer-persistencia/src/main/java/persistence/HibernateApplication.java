package persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApplication {
	//inicia la secion del hibernate
	private SessionFactory sessionFactory;
	
	public HibernateApplication(){
		this.sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	//abre una secion para un usuario
	public HibernateUserApplication getUserApplication(){
		Session session = this.sessionFactory.openSession();
		
		ThreadLocal<Session> tl = new ThreadLocal<Session>();//esta variable(tl) no tendria q estar declarada
														///fuera de este metodo??????
		
		return new HibernateUserApplication(session);
	}

}
