package persistence.test;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import persistence.actions.Action;
import persistence.actions.ActionBuscarEquipoYArmarFormacion;
import persistence.actions.ActionCrearEquipo;
import persistence.hibernate.HibernateApplication;
import appModel.Home;

public class TestCasoDeUsoArmarFormacion implements Runnable {
	
	private String nombreEquipo;
	
	public TestCasoDeUsoArmarFormacion(String nombreEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
	}

	public static void main(String[] args) {

	  ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
      
      newFixedThreadPool.execute(new TestCasoDeUsoArmarFormacion("River"));
      newFixedThreadPool.execute(new TestCasoDeUsoArmarFormacion("Boca"));
      newFixedThreadPool.execute(new TestCasoDeUsoArmarFormacion("Racing"));
      newFixedThreadPool.execute(new TestCasoDeUsoArmarFormacion("Independiente"));
      newFixedThreadPool.execute(new TestCasoDeUsoArmarFormacion("Lanus"));
      newFixedThreadPool.execute(new TestCasoDeUsoArmarFormacion("Quilmes"));
      newFixedThreadPool.execute(new TestCasoDeUsoArmarFormacion("Ferro"));
      newFixedThreadPool.execute(new TestCasoDeUsoArmarFormacion("Estudiantes"));
      newFixedThreadPool.execute(new TestCasoDeUsoArmarFormacion("Banfield"));
      newFixedThreadPool.execute(new TestCasoDeUsoArmarFormacion("Chacarita"));
      newFixedThreadPool.execute(new TestCasoDeUsoArmarFormacion("Atlanta"));
      newFixedThreadPool.execute(new TestCasoDeUsoArmarFormacion("Chicago"));
						
	}

	public void run() {
		
		// creamos y persistimos el equipo river
		HibernateApplication.getInstance().execute(new ActionCrearEquipo(this.nombreEquipo));
		
		// Buscamos por nombre al equipo river que creamos. Armamos su formacion
		// y la persistimos.
		HibernateApplication.getInstance().execute(new ActionBuscarEquipoYArmarFormacion(this.nombreEquipo));
		
	}
		
		
	
		
	
}