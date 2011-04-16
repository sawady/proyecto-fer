package appModel;


public class DefaultHomeFactory extends HomeFactory {

	@Override
	public Home<?> newHomeInstance(Class<?> clazz) {
		return new CollectionBasedHome<Entity>();
	}

}