package persistence;

import model.Equipo;
import model.Formacion;

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
