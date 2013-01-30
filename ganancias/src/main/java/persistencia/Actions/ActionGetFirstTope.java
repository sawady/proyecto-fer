package persistencia.Actions;

import model.entities.TopeSalarial;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.HibernateHome;

public class ActionGetFirstTope implements Action{
	private TopeSalarial result;

	@Override
	public void execute() {
		HibernateHome<TopeSalarial> hometope = (HibernateHome<TopeSalarial>) HibernateApplication
				.getInstance().getHome(TopeSalarial.class);
		this.setResult(hometope.getFirst());
	}

	public TopeSalarial getResult() {
		return result;
	}

	public void setResult(TopeSalarial result) {
		this.result = result;
	}
	

}

