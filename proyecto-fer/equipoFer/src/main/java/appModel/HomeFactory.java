package appModel;

import java.util.Map;

public abstract class HomeFactory {

	/* METODOS ***************************************************/

	public final void addHomes(Map<Class<?>, Home<?>> homes){
		
		for(Class<?> clazz : new EquipoFerEntities().getEntities()){
			homes.put(clazz, this.newHomeInstance(clazz));
		}
			
	}
	
	public abstract Home<?> newHomeInstance(Class<?> clazz);

}