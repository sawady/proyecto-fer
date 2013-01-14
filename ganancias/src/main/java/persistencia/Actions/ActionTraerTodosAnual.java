package persistencia.Actions;

import java.util.List;

import model.entities.CamposParaCalculoAnual;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.CamposParaCalculoAnualHibernateHome;

public class ActionTraerTodosAnual implements Action {
	private List<CamposParaCalculoAnual>result;

	@Override
	public void execute() {
		CamposParaCalculoAnualHibernateHome homeDecAnual = (CamposParaCalculoAnualHibernateHome) HibernateApplication
				.getInstance().getHome(CamposParaCalculoAnual.class);
		this.setResult(homeDecAnual.getAllEntities());
	
	}

	public List<CamposParaCalculoAnual> getResult() {
		return result;
	}

	public void setResult(List<CamposParaCalculoAnual> result) {
		this.result = result;
	}

}
