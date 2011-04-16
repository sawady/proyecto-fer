package persistence;


import model.Jugador;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Muestra el uso basico de HB
 * @author leo
 *
 */
public class InsertJugadoresBasic {
	public static void main(String[] args) {
		//Esta instancia es thread safe
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		//esta ya no es threadSafe
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(new Jugador("Pavoni"));
			session.save(new Jugador("Santoro"));
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
