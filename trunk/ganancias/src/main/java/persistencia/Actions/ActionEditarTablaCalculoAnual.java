package persistencia.Actions;

import model.entities.CamposParaCalculoAnual;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.CamposParaCalculoAnualHibernateHome;

public class ActionEditarTablaCalculoAnual implements Action {
	private CamposParaCalculoAnualHibernateHome homeDecAnual;
	private CamposParaCalculoAnual nuevo;
	private float id;


	public ActionEditarTablaCalculoAnual(float id, CamposParaCalculoAnual nuevo2) {
		super();
		this.nuevo = nuevo2;
		this.id = id;
	}

	@Override
	public void execute() {
		homeDecAnual = (CamposParaCalculoAnualHibernateHome) HibernateApplication
				.getInstance().getHome(CamposParaCalculoAnual.class);
		CamposParaCalculoAnual temp =homeDecAnual.getByDesde(id);
		
//		temp.setBase(nuevo.getBase());
//		temp.setDesde(nuevo.getDesde());
//		temp.setHasta(nuevo.getHasta());
//		temp.setPor_extra(nuevo.getPor_extra());
//		temp.setSobre_exced(nuevo.getSobre_exced());
	
		//homeDecAnual.actualizar(temp);
		homeDecAnual.eliminar(temp);
		homeDecAnual.agregar(nuevo);
	
	}

}
