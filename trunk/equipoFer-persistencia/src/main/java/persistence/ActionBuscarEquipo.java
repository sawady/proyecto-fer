package persistence;

import model.Equipo;

public class ActionBuscarEquipo implements Action {
	
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

	public ActionBuscarEquipo(String nombreEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
	}

	public void execute() {
		this.setResultado(
				HibernateApplication.getInstance().getHome(Equipo.class).getNombrable(this.getNombreEquipo())
		);
	}
}
