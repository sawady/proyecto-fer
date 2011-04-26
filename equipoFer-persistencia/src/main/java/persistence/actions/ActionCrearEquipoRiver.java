package persistence.actions;

import java.util.ArrayList;
import java.util.List;

import model.clasesPrincipales.Equipo;
import model.clasesPrincipales.Jugador;
import model.clasesPrincipales.Tecnico;
import model.formaciones.FormacionStrategy;
import model.formaciones.FormacionStrategyImpl;
import model.habilidad.HabilidadImpl;
import model.util.Posicion;
import persistence.hibernate.HibernateApplication;

public class ActionCrearEquipoRiver  implements Action{
	
	public void execute() {
			
			List<Posicion> listaPos = new ArrayList<Posicion>();
			listaPos.add(Posicion.ARQUERO);
			listaPos.add(Posicion.VOLANTEDEFENSIVO);
			listaPos.add(Posicion.CENTRAL);
			listaPos.add(Posicion.ENGANCHE);
			listaPos.add(Posicion.DELANTERO);
			
			FormacionStrategy fs = new FormacionStrategyImpl(listaPos);
			Tecnico tecnico   = new Tecnico("Bianchi", fs);
			Equipo eq = new Equipo("River", tecnico);
	
			Jugador jug1 = new Jugador("Juan", eq);
			Jugador jug2 = new Jugador("Jose", eq);
			Jugador jug3 = new Jugador("Martin", eq);
			Jugador jug4 = new Jugador("Marcelo", eq);
			Jugador jug5 = new Jugador("Fabian", eq);
			Jugador jug6 = new Jugador("Carlos", eq);
			Jugador jug7 = new Jugador("Seba", eq);
			
			
			jug1.addHabilidad(new HabilidadImpl(Posicion.ARQUERO, 12, jug1));
			jug2.addHabilidad(new HabilidadImpl(Posicion.VOLANTEDEFENSIVO, 12, jug2));
			jug3.addHabilidad(new HabilidadImpl(Posicion.CENTRAL, 12, jug3));
			jug4.addHabilidad(new HabilidadImpl(Posicion.ENGANCHE, 12, jug4));
			jug5.addHabilidad(new HabilidadImpl(Posicion.ENGANCHE, 12, jug5));
			jug6.addHabilidad(new HabilidadImpl(Posicion.DELANTERO, 12, jug6));
			jug7.addHabilidad(new HabilidadImpl(Posicion.DELANTERO, 12, jug7));
			
			eq.addJugador(jug1);
			eq.addJugador(jug2);
			eq.addJugador(jug3);
			eq.addJugador(jug4);
			eq.addJugador(jug5);
			eq.addJugador(jug6);
			eq.addJugador(jug7);		
			
			HibernateApplication.getInstance().getHome(Equipo.class).agregar(eq);
			
	}

}
