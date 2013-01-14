package persistencia.Actions;

import model.entities.DeduccionC;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.HibernateHome;

public class ActionGetFirstDeduccionC  implements Action{
	private DeduccionC result;

	@Override
	public void execute() {
		HibernateHome<DeduccionC> homeDecC = (HibernateHome<DeduccionC>) HibernateApplication
				.getInstance().getHome(DeduccionC.class);
		this.setResult(homeDecC.getFirst());
	}

	public DeduccionC getResult() {
		return result;
	}

	public void setResult(DeduccionC result) {
		this.result = result;
	}
	

}
