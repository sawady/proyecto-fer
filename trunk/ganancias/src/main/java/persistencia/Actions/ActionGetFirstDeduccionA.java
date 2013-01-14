package persistencia.Actions;

import model.entities.DeduccionA;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.HibernateHome;

public class ActionGetFirstDeduccionA implements Action{
	private DeduccionA result;

	@Override
	public void execute() {
		HibernateHome<DeduccionA> homeDecA = (HibernateHome<DeduccionA>) HibernateApplication
				.getInstance().getHome(DeduccionA.class);
		this.setResult(homeDecA.getFirst());
	}

	public DeduccionA getResult() {
		return result;
	}

	public void setResult(DeduccionA result) {
		this.result = result;
	}
	

}
