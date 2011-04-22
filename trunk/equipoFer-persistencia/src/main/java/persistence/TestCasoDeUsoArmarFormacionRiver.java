package persistence;

import java.util.HashSet;
import java.util.Set;

import appModel.Home;
import appModel.Persistible;
import model.Equipo;
import model.Formacion;

public class TestCasoDeUsoArmarFormacionRiver {
	
	public static void main(String[] args) {
		
		// creamos y persistimos el equipo river
		HibernateApplication.getInstance().execute(new ActionCrearEquipoRiver());
		
		// buscamos por nombre al equipo river que creamos
		ActionBuscarEquipo actionBuscarEquipo = new ActionBuscarEquipo("River");
		HibernateApplication.getInstance().execute(actionBuscarEquipo);
		Equipo eq = actionBuscarEquipo.getResultado();
		
		eq.getJugadores();
		eq.getTecnico();
		
		// armamos y persistimos la formacion del equipo que buscamos por nombre		
		HibernateApplication.getInstance().execute(new ActionArmarFormacionDeEquipo(eq));
	}
}