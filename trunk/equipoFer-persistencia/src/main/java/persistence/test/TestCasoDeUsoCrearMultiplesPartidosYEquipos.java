package persistence.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import persistence.actions.ActionCrearEquipo;
import persistence.actions.ActionCrearPartidoDeCopa;
import persistence.actions.ActionCrearPartidoSimple;
import persistence.hibernate.HibernateApplication;

public class TestCasoDeUsoCrearMultiplesPartidosYEquipos {
	
	private static List<String>equipos= new ArrayList<String>();
	private static Random r= new Random();
	private void inicialize(){
		// recordar dd/MM/yyyy HH:mm formato de la fecha
		//Creo una lista de String con lo equipos para elegirlos aleatoriamente.
		equipos.add("Boca");
		equipos.add("River");
		equipos.add("Independiente");
		equipos.add("Racing");
	}
	private List<String> generarRivales(){
		List<String>toReturn = new ArrayList<String>();
		toReturn.add(equipos.get(r.nextInt(5)));
		String equipo2 = equipos.get(r.nextInt(5));
		while(toReturn.get(0).equalsIgnoreCase(equipo2)){
			equipo2 = equipos.get(r.nextInt(5));
		}
		toReturn.add(equipo2);
		return toReturn;
	}
	
	public static void main(String[] args) {
		TestCasoDeUsoCrearMultiplesPartidosYEquipos self = new TestCasoDeUsoCrearMultiplesPartidosYEquipos();
		self.inicialize();
		final HibernateApplication application = HibernateApplication.getInstance();
		
		
		// creo los 4 equipos
		application.execute(new ActionCrearEquipo(equipos.get(0)));
		application.execute(new ActionCrearEquipo(equipos.get(1)));
		application.execute(new ActionCrearEquipo(equipos.get(2)));
		application.execute(new ActionCrearEquipo(equipos.get(3)));
		

		
		
		
		//Creo los partidos Simples.
		//ToDo que las fechas q se generen sean distintas, 
		//deberia guardarlas para asi poder generar los 
		//partidos de copa
		//luego verificar que no elija dos fechas iguales, tengo que ver que los partidos que se enfrentan 
		//sean los mismos para que tenga sentido.
		for(int i=0; i<=3000; i++){
			List<String>x =self.generarRivales();
			application.execute(new ActionCrearPartidoSimple(x.get(0),x.get(1), "10/10/2010 22:30"));
		}
		
		//Todo

		application.execute(new ActionCrearPartidoDeCopa("10/10/2010 22:30","10/10/2010 22:30"));

	}

}
