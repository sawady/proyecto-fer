package persistence.test;

import persistence.actions.Action;
import persistence.hibernate.HibernateApplication;
import appModel.Home;

public class TestGeneralBorrarTodasLasEntidades {

	/* MAIN*************************************************************************/
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
