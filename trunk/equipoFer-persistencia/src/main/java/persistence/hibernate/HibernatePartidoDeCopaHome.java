package persistence.hibernate;

import org.hibernate.Session;

import model.Equipo;
import model.PartidoDeCopa;
import model.PartidoSimple;

public class HibernatePartidoDeCopaHome extends HibernateHome<PartidoDeCopa> {

	public HibernatePartidoDeCopaHome(ThreadLocal<Session> tl) {
		super(tl, PartidoDeCopa.class);
	}
	
	@Override
	public void agregar(PartidoDeCopa object) {
		super.agregar(object);
		Equipo eq = object.getGanador();
		if(eq != null){
			eq.incrementarCantVictorias();
		}
	}

	@Override
	public void eliminar(PartidoDeCopa object) {
		// TODO Auto-generated method stub
		super.eliminar(object);
		Equipo eq = object.getGanador();
		if(eq != null){
			eq.decrementarCantVictorias();
		}
	}

	@Override
	public void deleteAllEntities() {
		super.deleteAllEntities();
		this.tlocal.get().createQuery("update " + Equipo.class.getName() + " e set e.cantVictorias = :cant").setInteger("cant", 0).executeUpdate();;
	}

}
