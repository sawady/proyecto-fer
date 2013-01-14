package persistencia.Actions;

import model.entities.DeduccionC;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.HibernateHome;

public class ActionEditarDeduccionC implements Action {
	private HibernateHome<DeduccionC> homeDecAnual;
	private DeduccionC nuevo;

	public ActionEditarDeduccionC(
			DeduccionC nuevo) {
		super();
		this.nuevo = nuevo;
	}

	@Override
	public void execute() {
		homeDecAnual = (HibernateHome<DeduccionC>) HibernateApplication
				.getInstance().getHome(DeduccionC.class);
		homeDecAnual.deleteAllEntities();
		homeDecAnual.agregar(nuevo);
	}

}
