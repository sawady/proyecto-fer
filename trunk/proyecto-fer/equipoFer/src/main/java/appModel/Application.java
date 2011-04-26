package appModel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Application {

	/* VARIABLES ***************************************************/

	private Map<Class<?>, Home<?>> homes = new HashMap<Class<?>, Home<?>>();
	
	/* CONSTRUCTOR ***************************************************/

	public Application(HomeFactory factory) {
		factory.addHomes(homes);	
	}
	
	
	/* GET&SET***************************************************/

	public Map<Class<?>, Home<?>> getHomes() {
		return homes;
	}

	public void setHomes(Map<Class<?>, Home<?>> homes) {
		this.homes = homes;
	}
	
	public Collection<Home<?>> getAllHomes(){
		return this.getHomes().values();	
	}

	@SuppressWarnings("unchecked")
	public <T extends Persistible> Home<T> getHome(Class<? extends T> type) {
		return (Home<T>) this.homes.get(type);
	}
	
}
