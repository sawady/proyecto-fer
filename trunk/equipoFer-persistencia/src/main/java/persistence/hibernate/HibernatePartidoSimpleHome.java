package persistence.hibernate;

import java.util.Date;

import model.PartidoSimple;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class HibernatePartidoSimpleHome extends HibernateHome<PartidoSimple> {

	public HibernatePartidoSimpleHome(ThreadLocal<Session> tl) {
		super(tl, PartidoSimple.class);
	}
	
	public PartidoSimple getByFecha(Date date){
		return (PartidoSimple) this.getCriteria().add(Restrictions.eq("fecha", date)).uniqueResult();
	}


}
