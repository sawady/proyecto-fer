package appModel;

import java.util.HashMap;
import java.util.Map;

public class UserApplication {
	
	private static UserApplication instance;
	private Map<Class<?>, Home<?>> homes = new HashMap<Class<?>, Home<?>>();

	public UserApplication(HomeFactory factory) {
		Map<Class<?>, Home<?>> homes = new HashMap<Class<?>, Home<?>>();
		factory.addHomes(homes);	
	}

	@SuppressWarnings("unchecked")
	public <T extends Entity> Home<T> getHome(Class<? extends T> type) {
		return (Home<T>) this.homes.get(type);
	}
	
}
