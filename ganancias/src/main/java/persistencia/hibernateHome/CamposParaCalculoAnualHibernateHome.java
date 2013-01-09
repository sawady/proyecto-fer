package persistencia.hibernateHome;

import model.entities.CamposParaCalculoAnual;

import org.hibernate.Session;

public class CamposParaCalculoAnualHibernateHome extends
		HibernateHome<CamposParaCalculoAnual> {

	public CamposParaCalculoAnualHibernateHome(ThreadLocal<Session> tl) {
		super(tl, CamposParaCalculoAnual.class);
	}

	public CamposParaCalculoAnual getByInRango(float gananciaNetaC) {
		return null;
	}
	
}
