package persistence.test;

import persistence.actions.ActionArmarHistorialVictorias;
import persistence.actions.ActionEquiposOrdenadosPorVictorias;
import persistence.hibernate.HibernateApplication;

public class TestCasoDeUsoEquiposOrdenadosPorVictorias {
	
	public static void main(String[] args) {
		
		ActionEquiposOrdenadosPorVictorias action = new ActionEquiposOrdenadosPorVictorias();

		HibernateApplication.getInstance().execute(action);
		
	}

}
