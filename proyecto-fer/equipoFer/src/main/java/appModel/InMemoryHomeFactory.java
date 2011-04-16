package appModel;


public class InMemoryHomeFactory extends HomeFactory {

	@Override
	public Home<?> newHomeInstance(Class<?> clazz) {
		return new CollectionBasedHome<Entity>();
	}
	

}
