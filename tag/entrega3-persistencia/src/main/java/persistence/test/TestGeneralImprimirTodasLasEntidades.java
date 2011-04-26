package persistence.test;

import persistence.actions.Action;
import persistence.hibernate.HibernateApplication;
import appModel.Home;
import appModel.Persistible;

public class TestGeneralImprimirTodasLasEntidades {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HibernateApplication.getInstance().execute(new Action() {
			
			public void execute() {
				for(Home<?> home : HibernateApplication.getInstance().getAllHomes()){
					
					for(Persistible persistible : home.getAllEntities()){
						persistible.printValues();
					}
				}
			}
		});

	}
}
