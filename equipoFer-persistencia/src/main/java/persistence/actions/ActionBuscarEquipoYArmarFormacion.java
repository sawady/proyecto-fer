package persistence.actions;

import model.clasesPrincipales.Equipo;
import model.formaciones.Formacion;
import persistence.hibernate.HibernateApplication;

public class ActionBuscarEquipoYArmarFormacion implements Action {
	
	private String nombreEquipo;
	
	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public ActionBuscarEquipoYArmarFormacion(String nombreEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
	}

	public void execute() {
		Equipo equipo = HibernateApplication.getInstance().getHome(Equipo.class).getNombrable(this.getNombreEquipo());
		
		HibernateApplication.getInstance().getHome(Formacion.class).agregar(equipo.armarFormacion());
	}
}
