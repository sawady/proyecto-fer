package persistence;

import model.Equipo;

public class AccionBuscarEquipo implements Action {
	
	private String nombre;
	private Equipo eq;

	public AccionBuscarEquipo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public void execute() {		
		Equipo eq = HibernateApplication.getInstance().getHome(Equipo.class).buscar(new Equipo(this.nombre));
	}

	public Equipo getEquipo() {
		return this.eq;
	}
}