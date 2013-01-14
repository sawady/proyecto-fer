package persistencia.Actions;

import model.entities.DeduccionB;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.HibernateHome;

public class ActionEditarDeduccionB implements Action {
	private HibernateHome<DeduccionB> homeDecAnual;
	private DeduccionB nuevo;

	public ActionEditarDeduccionB(DeduccionB nuevo) {
		super();
		this.nuevo = nuevo;
	}

	@Override
	public void execute() {
		homeDecAnual = (HibernateHome<DeduccionB>) HibernateApplication
				.getInstance().getHome(DeduccionB.class);
		homeDecAnual.deleteAllEntities();
		homeDecAnual.agregar(nuevo);
	}

}
