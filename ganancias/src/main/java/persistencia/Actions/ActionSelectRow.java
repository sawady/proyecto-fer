package persistencia.Actions;

import model.entities.CamposParaCalculoAnual;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.CamposParaCalculoAnualHibernateHome;

public class ActionSelectRow implements Action{
	private int id;
	private CamposParaCalculoAnual result;
	private Float value;
	
	public ActionSelectRow(Float valueAt) {
		super();
		this.value = valueAt;
	}


	@Override
	public void execute() {
		CamposParaCalculoAnualHibernateHome homeDecAnual = (CamposParaCalculoAnualHibernateHome) HibernateApplication
				.getInstance().getHome(CamposParaCalculoAnual.class);	
		this.setResult(homeDecAnual.getByDesde(this.value));
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
