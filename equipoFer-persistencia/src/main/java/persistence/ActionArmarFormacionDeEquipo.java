package persistence;

import model.Equipo;
import model.Formacion;

public class ActionArmarFormacionDeEquipo implements Action{
	private Equipo eq;

	public ActionArmarFormacionDeEquipo(Equipo eq) {
		super();
		this.eq = eq;
	}

	public void execute() {

		Formacion f = eq.armarFormacion();
		HibernateApplication.getInstance().getHome(Formacion.class).agregar(f);
	}

}
