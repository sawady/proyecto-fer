package model;

public class Tecnico implements Nombrable {
	
/* VARIABLES ***************************************************/

	private String nombre;
	private FormacionStrategy form_strategy;
	
/* CONSTRUSTOR ***************************************************/
	
	
	public Tecnico(String nombre, FormacionStrategy form_strategy) {
		super();
		this.nombre = nombre;
		this.form_strategy = form_strategy;
	}
	
/* METODOS ***************************************************/

	public Formacion armarFormacion(Equipo eq){
		return this.getForm_strategy().armarFormacion(eq);
	}


/* GET&SET ***************************************************/
	
	public FormacionStrategy getForm_strategy() {
		return form_strategy;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setForm_strategy(FormacionStrategy form_strategy) {
		this.form_strategy = form_strategy;
	}

	public String getNombre() {
		return this.nombre;
	}
	
}
