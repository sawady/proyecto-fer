package persistencia.Actions;

import model.entities.CamposParaCalculoAnual;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.CamposParaCalculoAnualHibernateHome;

public class ActionEditarTablaCalculoAnual implements Action {
	private CamposParaCalculoAnualHibernateHome homeDecAnual;
	private CamposParaCalculoAnual aModificar;
	private CamposParaCalculoAnual nuevo;

	public ActionEditarTablaCalculoAnual(CamposParaCalculoAnual aModificar,
			CamposParaCalculoAnual nuevo) {
		super();
		this.aModificar = aModificar;
		this.nuevo = nuevo;
	}

	@Override
	public void execute() {
		homeDecAnual = (CamposParaCalculoAnualHibernateHome) HibernateApplication
				.getInstance().getHome(CamposParaCalculoAnual.class);
		homeDecAnual.eliminar(aModificar);
		homeDecAnual.agregar(nuevo);
	}

}
