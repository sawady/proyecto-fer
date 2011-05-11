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
	//estas listas son necesarias para que los partidos de copa
	//contengan partidos simples con los mismos rivales
	private static List<String>fechasPSimpleBocaRiver= new ArrayList<String>();
	private static List<String>fechasPSimpleBocaIndependiente= new ArrayList<String>();
	private static List<String>fechasPSimpleBocaRacing= new ArrayList<String>();
	private static List<String>fechasPSimpleRiverIndependiente= new ArrayList<String>();
	private static List<String>fechasPSimpleRacingRiver= new ArrayList<String>();
	//lista q contiene a las anteriores para poder elegir de manera aleatoria que rivales tendra un pCopa
	private static List< List<String> >todasLasListas = new ArrayList< List<String> >();
	// valores aleatoriod
	private static Random r= new Random();
	
	
	//metodo para tener un poco de prolijidad
	private void inicialize(){
		// recordar dd/MM/yyyy HH:mm formato de la fecha
		//Creo una lista de String con lo equipos para elegirlos aleatoriamente.
		equipos.add("Boca");
		equipos.add("River");
		equipos.add("Independiente");
		equipos.add("Racing");
		//
		todasLasListas.add(fechasPSimpleBocaIndependiente);
		todasLasListas.add(fechasPSimpleBocaRacing);
		todasLasListas.add(fechasPSimpleBocaRiver);
		todasLasListas.add(fechasPSimpleRacingRiver);
		todasLasListas.add(fechasPSimpleRiverIndependiente);
	}
	
	//genera los equipos rivales para un partido simple, verificando que no sea contra el mismo
	private List<String> generarRivales(){
		List<String>toReturn = new ArrayList<String>();
		toReturn.add(equipos.get(r.nextInt(4)));
		String equipo2 = equipos.get(r.nextInt(4));
		while(toReturn.get(0).equalsIgnoreCase(equipo2)){
			equipo2 = equipos.get(r.nextInt(4));
		}
		toReturn.add(equipo2);
		return toReturn;
	}
	
	//genera una fecha para un partido simple y lo guarda en la lista que le corresponde
	private String generarFechaPartido(List<String>xs){
		String fecha;
		//creo una fecha
		fecha=  r.nextInt(27) + "/" + r.nextInt(13) + "/2010 " + r.nextInt(25) + ":" + r.nextInt(61);
		//mientras ya contenga a la fecha, creo una distinta
		while(xs.contains(fecha)){
			fecha =r.nextInt(27) + "/" + r.nextInt(13) + "/2010 " + r.nextInt(25) + ":" + r.nextInt(61);
		}
		//agrego la nueva fecha al listado de fechas de partidosSimples
		xs.add(fecha);
		return fecha; 
	}
	
	//elige 2 partidoSimple para uno de Copa, teniendo en ambos partidos los mismos rivales, elegidos al azar
	private List<String>losPartidosSimplesParaLaCopa(){
		//elije dos fechas de los partidos simples creados
		//luego verificar que no elija dos fechas iguales, 
		List<String>toReturn = new ArrayList<String>();
		List<String>temp = todasLasListas.get(r.nextInt(todasLasListas.size()));
		toReturn.add(temp.get(r.nextInt(temp.size())));
		String elOtroPartido = temp.get(r.nextInt(temp.size()));
		while(toReturn.get(0).equalsIgnoreCase(elOtroPartido)){
			 elOtroPartido = temp.get(r.nextInt(temp.size()));
		}
		toReturn.add(elOtroPartido);
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
		//las fechas q se generen son distintas, y lo guardo en una lista segun el los rivales
		for(int i=0; i<=50; i++){
			List<String>x =self.generarRivales();
			String fecha;
			
			/////////////////////////////////////////////////////////////////////////
			if(
					(x.get(0).equalsIgnoreCase("river") ||(x.get(0).equalsIgnoreCase("independiente"))
					&&
					(x.get(1).equalsIgnoreCase("river") ||(x.get(1).equalsIgnoreCase("independiente"))					))
					
			){fecha = self.generarFechaPartido(fechasPSimpleRiverIndependiente);}
			else{
				if(
						(x.get(0).equalsIgnoreCase("river") ||(x.get(0).equalsIgnoreCase("boca"))
						&&
						(x.get(1).equalsIgnoreCase("river") ||(x.get(1).equalsIgnoreCase("boca"))					))
						
				){fecha = self.generarFechaPartido(fechasPSimpleBocaRiver);}
				else{ if
				(
						(x.get(0).equalsIgnoreCase("river") ||(x.get(0).equalsIgnoreCase("racing"))
						&&
						(x.get(1).equalsIgnoreCase("river") ||(x.get(1).equalsIgnoreCase("racing"))					))
						
				){fecha = self.generarFechaPartido(fechasPSimpleRacingRiver);}
				else{
					if(
							(x.get(0).equalsIgnoreCase("boca") ||(x.get(0).equalsIgnoreCase("racing"))
							&&
							(x.get(1).equalsIgnoreCase("boca") ||(x.get(1).equalsIgnoreCase("racing"))					))
							
					){fecha = self.generarFechaPartido(fechasPSimpleBocaRacing);}
					else{fecha = self.generarFechaPartido(fechasPSimpleBocaIndependiente);}
				}
			}
			}
			/////////////////////////////////////////////////////////////////////////
			//creo el partido simple en la base
			application.execute(new ActionCrearPartidoSimple(x.get(0),x.get(1), fecha));
		}
		
		//Creo los partidos de copa
		for(int i=0; i<=10; i++){
			List<String>x =self.losPartidosSimplesParaLaCopa();
			application.execute(new ActionCrearPartidoDeCopa(x.get(0),x.get(1)));
		}
	}

}
