package persistence.test;

import persistence.actions.ActionCrearEquipo;
import persistence.actions.ActionCrearPartidoDeCopa;
import persistence.actions.ActionCrearPartidoSimple;
import persistence.hibernate.HibernateApplication;

public class TestCasoDeUsoPersistirPartidoCopayPartidoSimple {
	
	/*MAIN *************************************************************************/

	public static void main(String[] args) {
		final HibernateApplication application = HibernateApplication.getInstance();
		
		application.execute(new ActionCrearEquipo("Boca"));
		application.execute(new ActionCrearEquipo("River"));
		// dd/MM/yyyy HH:mm formato de la fecha
		application.execute(new ActionCrearPartidoSimple("Boca","River", "10/10/2010 22:30"));

		application.execute(new ActionCrearPartidoDeCopa("10/10/2010 22:30","10/10/2010 22:30"));

	}
}
