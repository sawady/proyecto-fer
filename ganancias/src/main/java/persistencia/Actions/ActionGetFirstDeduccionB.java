package persistencia.Actions;

import model.entities.DeduccionB;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.HibernateHome;

public class ActionGetFirstDeduccionB  implements Action{
	private DeduccionB result;

	@Override
	public void execute() {
		HibernateHome<DeduccionB> homeDecB = (HibernateHome<DeduccionB>) HibernateApplication
				.getInstance().getHome(DeduccionB.class);
		this.setResult(homeDecB.getFirst());
	}

	public DeduccionB getResult() {
		return result;
	}

	public void setResult(DeduccionB result) {
		this.result = result;
	}
	

}
