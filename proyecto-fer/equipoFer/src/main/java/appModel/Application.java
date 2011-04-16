package appModel;

import java.util.HashMap;
import java.util.Map;

public class Application {
	
	private static Application instance;	
	private Map<Class<?>, Home<?>> homes = new HashMap<Class<?>, Home<?>>();

	@SuppressWarnings("unchecked")
	public synchronized <T extends Entity> Home<T> getHome(Class<? extends T> type) {
		return (Home<T>) this.homes.get(type);
	}
	
	public static Application initialize(HomeFactory factory) {
		instance = new Application();
		//HARDCODED: coupled with in-memory homes. 
		Map<Class<?>, Home<?>> homes = new HashMap<Class<?>, Home<?>>();
		factory.addHomes(homes);
		instance.homes = homes;
		return instance;
	}
	
	public static synchronized Application initialize() {
		return initialize(new DefaultHomeFactory()); //persist with collections in memory
	}
	
	public static synchronized Application getInstance() {
		if (instance == null) {
			instance = initialize();
		}
		return instance;
	}
	
}
