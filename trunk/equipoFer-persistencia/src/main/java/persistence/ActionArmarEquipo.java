package persistence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import appModel.HomeFactory;

import model.Equipo;
import model.Formacion;
import model.FormacionStrategy;
import model.FormacionStrategyImpl;
import model.Habilidad;
import model.HabilidadImpl;
import model.Jugador;
import model.Posicion;
import model.Tecnico;

public class ActionArmarEquipo implements Action{

	public void execute() {
		
		Jugador jug1 = new Jugador("Juan");
		Jugador jug2 = new Jugador("Jose");
		Jugador jug3 = new Jugador("Martin");
		Jugador jug4 = new Jugador("Marcelo");
		Jugador jug5 = new Jugador("Fabian");
		Jugador jug6 = new Jugador("Carlos");
		Jugador jug7 = new Jugador("Seba");
		
		Set<Jugador> listaJug = new HashSet<Jugador>();
		listaJug.add(jug1);
		listaJug.add(jug2);
		listaJug.add(jug3);
		listaJug.add(jug4);
		listaJug.add(jug5);
		listaJug.add(jug6);
		listaJug.add(jug7);
		
		jug1.addHabilidad(new HabilidadImpl(Posicion.ARQUERO, 12, jug1));
		jug2.addHabilidad(new HabilidadImpl(Posicion.CENTRAL, 12, jug2));
		jug3.addHabilidad(new HabilidadImpl(Posicion.DELANTERO, 12, jug3));
		jug4.addHabilidad(new HabilidadImpl(Posicion.ENGANCHE, 12, jug4));
		jug5.addHabilidad(new HabilidadImpl(Posicion.LATERAL, 12, jug5));
		jug6.addHabilidad(new HabilidadImpl(Posicion.VOLANTEDEFENSIVO, 12, jug6));
		jug7.addHabilidad(new HabilidadImpl(Posicion.MEDIAPUNTA, 12, jug7));
		

		List<Posicion> listaPos = new ArrayList<Posicion>();
		listaPos.add(Posicion.ARQUERO);
		listaPos.add(Posicion.VOLANTEDEFENSIVO);
		listaPos.add(Posicion.VOLANTEDEFENSIVO);
		listaPos.add(Posicion.ENGANCHE);
		listaPos.add(Posicion.DELANTERO);


		
		FormacionStrategy fs = new FormacionStrategyImpl(listaPos);
		Tecnico tecnico   = new Tecnico("Bianchi", fs);
		Equipo eq = new Equipo("River", listaJug, tecnico);
		
		Formacion f = eq.armarFormacion();
		
		HibernateApplication.getInstance().getHome(Formacion.class).agregar(f);
	}

}
