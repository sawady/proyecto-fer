package persistence.actions;

import persistence.hibernate.HibernateApplication;
import model.clasesPrincipales.Equipo;
import model.formaciones.Formacion;

public class ActionBuscarEquipoYArmarFormacion implements Action {
	
	private String nombreEquipo;
	private Equipo resultado;
	
	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public Equipo getResultado() {
		return resultado;
	}

	public void setResultado(Equipo resultado) {
		this.resultado = resultado;
	}

	public ActionBuscarEquipoYArmarFormacion(String nombreEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
	}

	public void execute() {
		this.resultado = HibernateApplication.getInstance().getHome(Equipo.class).getNombrable(this.getNombreEquipo());
		
		HibernateApplication.getInstance().getHome(Formacion.class).agregar(this.resultado.armarFormacion());
	}
}
