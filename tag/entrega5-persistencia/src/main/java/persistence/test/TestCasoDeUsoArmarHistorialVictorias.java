package persistence.test;

import persistence.actions.ActionArmarHistorialVictorias;
import persistence.hibernate.HibernateApplication;

public class TestCasoDeUsoArmarHistorialVictorias {
	
	public static void main(String[] args) {
		
		ActionArmarHistorialVictorias action = new ActionArmarHistorialVictorias("River", "Boca");

		HibernateApplication.getInstance().execute(action);
		
	}

}
