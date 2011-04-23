package persistence.actions;

import persistence.hibernate.HibernateApplication;
import model.clasesPrincipales.Equipo;
import model.formaciones.Formacion;

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
