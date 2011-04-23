package persistence;

import java.util.HashSet;
import java.util.Set;

import appModel.Home;
import appModel.Persistible;
import model.Equipo;
import model.Formacion;

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