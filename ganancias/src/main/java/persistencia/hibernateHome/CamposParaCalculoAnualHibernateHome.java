package persistencia.hibernateHome;

import org.hibernate.Session;

import model.entities.CamposParaCalculoAnual;

public class CamposParaCalculoAnualHibernateHome extends
		HibernateHome<CamposParaCalculoAnual> {

	public CamposParaCalculoAnualHibernateHome(ThreadLocal<Session> tl) {
		super(tl, CamposParaCalculoAnual.class);
	}

	public CamposParaCalculoAnual getByInRango(float gananciaNetaC) {
		return null;
	}
	
}
