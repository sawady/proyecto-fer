package appModel;

import java.util.ArrayList;
import java.util.List;

import model.Equipo;
import model.Formacion;
import model.FormacionStrategy;
import model.Habilidad;
import model.Jugador;
import model.Tecnico;
import model.Titular;

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
