package appModel;

import java.util.ArrayList;
import java.util.List;

import model.clasesPrincipales.Equipo;
import model.clasesPrincipales.Jugador;
import model.clasesPrincipales.Tecnico;
import model.clasesPrincipales.Titular;
import model.formaciones.Formacion;
import model.formaciones.FormacionStrategy;
import model.habilidad.Habilidad;

public class EquipoFerEntities {
	//lista de entitys del proyecto
	public List<Class<?>> getEntities(){
		List<Class<?>> result = new ArrayList<Class<?>>();
		
		result.add(Equipo.class);
		result.add(Formacion.class);
		result.add(FormacionStrategy.class);
		result.add(Habilidad.class);
		result.add(Jugador.class);
		result.add(Tecnico.class);
		result.add(Titular.class);
		
		return result;
	}

}
