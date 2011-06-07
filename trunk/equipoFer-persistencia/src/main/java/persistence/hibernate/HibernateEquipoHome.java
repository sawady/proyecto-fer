package persistence.hibernate;

import java.util.List;

import model.Equipo;

import org.hibernate.Session;

public class HibernateEquipoHome extends HibernateHome<Equipo> {

	public HibernateEquipoHome(ThreadLocal<Session> tl) {
		super(tl, Equipo.class);
	}
	
	public List<Equipo> getEquiposOrdenadosPorVictorias(){
		return this.tlocal.get().createQuery("from " + this.getClazz().getName() + " as e order by e.cantVictorias desc" ).list();
	}
	
}
