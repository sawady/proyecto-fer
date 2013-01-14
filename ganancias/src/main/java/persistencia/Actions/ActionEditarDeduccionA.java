package persistencia.Actions;

import model.entities.DeduccionA;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.HibernateHome;

public class ActionEditarDeduccionA implements Action {
	private HibernateHome<DeduccionA> homeDecAnual;
	private DeduccionA nuevo;


	public ActionEditarDeduccionA(DeduccionA nuevo) {
		super();
		this.nuevo = nuevo;
	}

	@Override
	public void execute() {
		homeDecAnual = (HibernateHome<DeduccionA>) HibernateApplication
				.getInstance().getHome(DeduccionA.class);
		homeDecAnual.deleteAllEntities();
		homeDecAnual.agregar(nuevo);
	}

}
