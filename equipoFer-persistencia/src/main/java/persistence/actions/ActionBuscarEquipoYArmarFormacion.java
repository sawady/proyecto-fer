package persistence.actions;

import model.Equipo;
import model.Formacion;
import persistence.hibernate.HibernateApplication;

public class ActionBuscarEquipoYArmarFormacion implements Action {
	
	
	/* VARIABLES*************************************************************************/
	private String nombreEquipo;
	
	/* CONSTRUCTOR*************************************************************************/
	
	public ActionBuscarEquipoYArmarFormacion(String nombreEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
	}
	/* METODOS*************************************************************************/
	
	public void execute() {
		Equipo equipo = HibernateApplication.getInstance().getHome(Equipo.class).getNombrable(this.getNombreEquipo());
		
		HibernateApplication.getInstance().getHome(Formacion.class).agregar(equipo.armarFormacion());
	}
	/* GET&SET*************************************************************************/
	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}


}
