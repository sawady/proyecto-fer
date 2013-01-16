package persistencia.Actions;

import persistencia.HibernateApplication;
import persistencia.hibernateHome.CamposParaCalculoAnualHibernateHome;
import model.entities.CamposParaCalculoAnual;

public class ActionGetByCampoDesde implements Action{
	
	private CamposParaCalculoAnual result;
	private Float id;
	
	public ActionGetByCampoDesde(Float id) {
		this.id = id;
	}

	@Override
	public void execute() {
		CamposParaCalculoAnualHibernateHome home =  (CamposParaCalculoAnualHibernateHome) HibernateApplication
				.getInstance().getHome(CamposParaCalculoAnual.class);
		for (CamposParaCalculoAnual i : home.getAllEntities()) {
			System.out.println(i.getId());
			
		}
		this.setResult(home.getByDesde(id));
		
	}

	public CamposParaCalculoAnual getResult() {
		return result;
	}

	public void setResult(CamposParaCalculoAnual result) {
		this.result = result;
	}

	
}
