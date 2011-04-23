package persistence.Actions;

import persistence.hibernate.HibernateApplication;
import model.Equipo;
import model.Formacion;

public class ActionArmarFormacionDeEquipo implements Action{
	
	private Equipo equipo;

	public ActionArmarFormacionDeEquipo(Equipo eq) {
		super();
		this.equipo = eq;
	}

	public void execute() {
		HibernateApplication.getInstance().getHome(Formacion.class).agregar(this.equipo.armarFormacion());		
	}

}
