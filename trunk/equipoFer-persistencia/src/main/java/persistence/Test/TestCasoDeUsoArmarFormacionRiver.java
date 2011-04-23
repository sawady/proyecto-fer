package persistence.Test;

import persistence.Actions.Action;
import persistence.Actions.ActionBuscarEquipoYArmarFormacion;
import persistence.Actions.ActionCrearEquipoRiver;
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
		
		// creamos y persistimos el equipo river
		HibernateApplication.getInstance().execute(new ActionCrearEquipoRiver());
		
		// Buscamos por nombre al equipo river que creamos. Armamos su formacion
		// y la persistimos.
		HibernateApplication.getInstance().execute(new ActionBuscarEquipoYArmarFormacion("River"));
	}
}