package persistence.hibernate;

import java.util.Date;
import java.util.List;

import model.Equipo;
import model.PartidoSimple;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class HibernatePartidoSimpleHome extends HibernateHome<PartidoSimple> {
	
	/* CONSTRUCTOR ***********************************************************************************/

	public HibernatePartidoSimpleHome(ThreadLocal<Session> tl) {
		super(tl, PartidoSimple.class);
	}
	
	/* METODOS ***********************************************************************************/
	public PartidoSimple getByFecha(Date date){
		return (PartidoSimple) this.getCriteria().add(Restrictions.eq("fecha", date)).uniqueResult();
	}
	
	public List<?> getByAdversarios(Equipo equipo, Equipo equipo2){
		return this.getCriteria()
		.add(Restrictions.or( Restrictions.and(Restrictions.eq("equipo1", equipo), Restrictions.eq("equipo2", equipo2)), 
							  Restrictions.and(Restrictions.eq("equipo1", equipo2), Restrictions.eq("equipo2", equipo))))
		.list();
	}


}
