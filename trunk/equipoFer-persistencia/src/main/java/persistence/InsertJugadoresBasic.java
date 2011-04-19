package persistence;


import model.Equipo;
import model.Jugador;
import model.Tecnico;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Muestra el uso basico de HB
 * @author leo
 *
 */
//modo de ejemplo, no pertenece a este proyecto!!!!!
public class InsertJugadoresBasic {
	public static void main(String[] args) {
		//Esta instancia es thread safe
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		//esta ya no es threadSafe
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			
			Equipo eq = new Equipo("Boca", new Tecnico("Bianchi", null));
			eq.addJugador(new Jugador("Pavoni", eq));
			eq.addJugador(new Jugador("Rafael", eq));
			eq.addJugador(new Jugador("Palermo", eq));
			eq.addJugador(new Jugador("Riquelme", eq));
			
			session.save(eq);
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
