package persistencia.hibernateHome;

import model.entities.WsAux;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class WsAuxHibernateHome  extends HibernateHome<WsAux> {

	public WsAuxHibernateHome(ThreadLocal<Session> tl) {
		super(tl, WsAux.class);
			}


	public WsAux getByCuil(String cuil) {
		return (WsAux) this.getCriteria().add(Restrictions.eq("CUIL", cuil)).uniqueResult();
	}
}