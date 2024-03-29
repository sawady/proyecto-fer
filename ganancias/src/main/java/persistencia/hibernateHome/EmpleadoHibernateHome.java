package persistencia.hibernateHome;

import model.entities.Empleado;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class EmpleadoHibernateHome extends HibernateHome<Empleado> {

	public EmpleadoHibernateHome(ThreadLocal<Session> tl) {
		super(tl, Empleado.class);
			}

	public Empleado getByNombre(String nombre) {
		return (Empleado) this.getCriteria().add(Restrictions.eq("nombre", nombre)).uniqueResult();
	}
	
	public Empleado getByCuil(int cuil) {
		return (Empleado) this.getCriteria().add(Restrictions.eq("CUIL", cuil)).uniqueResult();
	}
}
