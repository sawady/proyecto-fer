package persistencia.Actions;

import model.entities.CamposParaCalculoAnual;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.CamposParaCalculoAnualHibernateHome;

public class ActionSelectRow implements Action{
	private int id;
	private CamposParaCalculoAnual result;

	
	public ActionSelectRow(int id) {
		super();
		this.id = id;
	}


	@Override
	public void execute() {
		CamposParaCalculoAnualHibernateHome homeDecAnual = (CamposParaCalculoAnualHibernateHome) HibernateApplication
				.getInstance().getHome(CamposParaCalculoAnual.class);	
		this.setResult(homeDecAnual.getWithId(id));
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public CamposParaCalculoAnual getResult() {
		return result;
	}


	public void setResult(CamposParaCalculoAnual result) {
		this.result = result;
	}
	

}
