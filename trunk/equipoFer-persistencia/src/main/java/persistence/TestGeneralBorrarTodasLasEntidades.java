package persistence;

import appModel.Home;
import appModel.Persistible;

public class TestGeneralBorrarTodasLasEntidades {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HibernateApplication.getInstance().execute(new Action() {
			
			public void execute() {
				for(Home<?> home : HibernateApplication.getInstance().getAllHomes()){
					
					home.deleteAllEntities();
				}
			}
		});

	}

}
