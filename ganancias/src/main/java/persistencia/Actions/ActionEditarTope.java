package persistencia.Actions;

import model.entities.TopeSalarial;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.HibernateHome;

public class ActionEditarTope implements Action {
	private HibernateHome<TopeSalarial> hometope;
	private TopeSalarial nuevo;


	public ActionEditarTope(TopeSalarial nuevo) {
		super();
		this.nuevo = nuevo;
	}

	@Override
	public void execute() {
		hometope = (HibernateHome<TopeSalarial>) HibernateApplication
				.getInstance().getHome(TopeSalarial.class);
		hometope.deleteAllEntities();
		hometope.agregar(nuevo);
	}

}

