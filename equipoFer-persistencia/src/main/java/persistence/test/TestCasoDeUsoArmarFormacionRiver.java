package persistence.test;

import persistence.actions.Action;
import persistence.actions.ActionBuscarEquipoYArmarFormacion;
import persistence.actions.ActionCrearEquipoRiver;
import persistence.hibernate.HibernateApplication;
import appModel.Home;

public class TestCasoDeUsoArmarFormacionRiver {
	
	public static void main(String[] args) {
		
		HibernateApplication.getInstance().execute(new Action() {
			
			public void execute() {
				for(Home<?> home : HibernateApplication.getInstance().getAllHomes()){
					
					home.deleteAllEntities();
				}
			}
		});
		
//		HibernateApplication.getInstance().execute(new Action() {
//			
//			public void execute() {
//				
//				List<Posicion> listaPos = new ArrayList<Posicion>();
//				
//				listaPos.add(Posicion.ARQUERO);
//				listaPos.add(Posicion.CENTRAL);
//				listaPos.add(Posicion.DELANTERO);
//				
//				FormacionStrategy form_strategy = new FormacionStrategyImpl(listaPos);
//				Tecnico tecnico = new Tecnico("Falsioni", form_strategy);
//				Equipo boca = new Equipo("Boca", tecnico);
//				
//				Jugador jugador = new Jugador("Pepe", boca);
//				Jugador jugador2 = new Jugador("Lautaro", boca);
//				Jugador jugador3 = new Jugador("Jose", boca);
//				Jugador jugador4 = new Jugador("Enrique", boca);
//				Jugador jugador5 = new Jugador("Tomas", boca);
//				
//				jugador.addHabilidad(new HabilidadImpl(Posicion.ARQUERO, 12, jugador));
//				jugador2.addHabilidad(new HabilidadImpl(Posicion.CENTRAL, 13, jugador2));
//				jugador3.addHabilidad(new HabilidadImpl(Posicion.CENTRAL, 14, jugador3));
//				jugador4.addHabilidad(new HabilidadImpl(Posicion.DELANTERO, 14, jugador4));
//				jugador5.addHabilidad(new HabilidadImpl(Posicion.DELANTERO, 14, jugador5));
//				
//				boca.addJugador(jugador);
//				boca.addJugador(jugador2);
//				boca.addJugador(jugador3);
//				boca.addJugador(jugador4);
//				boca.addJugador(jugador5);
//		
//				HibernateApplication.getInstance().getHome(Equipo.class).agregar(boca);
//				
//				Equipo boca2 = HibernateApplication.getInstance().getHome(Equipo.class).getNombrable("Boca");
//				
//				HibernateApplication.getInstance().getHome(Formacion.class).agregar(boca2.armarFormacion());
//				
//			}
//		});
	
		// creamos y persistimos el equipo river
		HibernateApplication.getInstance().execute(new ActionCrearEquipoRiver());
		
		// Buscamos por nombre al equipo river que creamos. Armamos su formacion
		// y la persistimos.
		HibernateApplication.getInstance().execute(new ActionBuscarEquipoYArmarFormacion("River"));
	}
}