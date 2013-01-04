package persistencia;

import java.util.Map;


import model.entities.SistemaEntities;

public abstract class HomeFactory {

	/* METODOS ***************************************************/

	public final void addHomes(Map<Class<?>, Home<?>> homes){
		
		for(Class<?> clazz : new SistemaEntities().getEntities()){
			homes.put(clazz, this.newHomeInstance(clazz));
		}
			
	}
	
	public abstract Home<?> newHomeInstance(Class<?> clazz);

}