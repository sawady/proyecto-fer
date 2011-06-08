package persistence.test;

import java.util.List;

import model.Equipo;
import persistence.actions.ActionCrearEquipo;
import persistence.actions.ActionCrearPartidosDeCopa;
import persistence.actions.ActionCrearPartidosSimples;
import persistence.hibernate.HibernateApplication;

public class TestCasoDeUsoCrearMultiplesPartidosYEquipos {
	
	/* VARIABLES*************************************************************************/
	
	// valores aleatoriod
	public HibernateApplication application = HibernateApplication.getInstance();

		
	public void crearLosPartidos(int cantSimples, int cantDeCopa){		
		List<Equipo> rivalesActuales;
		// creo los 4 equipos
		application.execute(new ActionCrearEquipo("Boca"));
		application.execute(new ActionCrearEquipo("River"));
		application.execute(new ActionCrearEquipo("Independiente"));
		application.execute(new ActionCrearEquipo("Racing"));
		application.execute(new ActionCrearEquipo("Olimpo"));
		application.execute(new ActionCrearEquipo("Velez"));
		application.execute(new ActionCrearPartidosDeCopa(cantDeCopa));
		application.execute(new ActionCrearPartidosSimples(cantSimples));
	}
	
	/*MAIN *************************************************************************/
	public static void main(String[] args) {
		TestCasoDeUsoCrearMultiplesPartidosYEquipos self = new TestCasoDeUsoCrearMultiplesPartidosYEquipos();
		Cronometro cn = new Cronometro();
		cn.start();
		self.crearLosPartidos(1000, 1000);// 1000 simples y 1000 de copa con 2000 simples = 3000 simples y 1000 de copa
		cn.stop();
		cn.print();
	}

}
