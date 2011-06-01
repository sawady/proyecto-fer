package persistence.test;

import persistence.actions.ActionArmarHistorialVictorias;
import persistence.hibernate.HibernateApplication;

public class TestCasoDeUsoArmarHistorialVictorias {
	
	public static void main(String[] args) {
		
		ActionArmarHistorialVictorias action = new ActionArmarHistorialVictorias("River", "Boca");
		
		Cronometro cn = new Cronometro();
		cn.start();
		HibernateApplication.getInstance().execute(action);
		cn.stop();
		cn.print();
		
	}

}
