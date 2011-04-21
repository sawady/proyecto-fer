package appModel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserApplication {
	
	private Map<Class<?>, Home<?>> homes = new HashMap<Class<?>, Home<?>>();
	
	public Map<Class<?>, Home<?>> getHomes() {
		return homes;
	}

	public void setHomes(Map<Class<?>, Home<?>> homes) {
		this.homes = homes;
	}
	
	public Collection<Home<?>> getAllHomes(){
		return this.getHomes().values();	
	}

	public UserApplication(HomeFactory factory) {
		factory.addHomes(homes);	
	}

	@SuppressWarnings("unchecked")
	public <T extends Entity> Home<T> getHome(Class<? extends T> type) {
		return (Home<T>) this.homes.get(type);
	}
	
}
