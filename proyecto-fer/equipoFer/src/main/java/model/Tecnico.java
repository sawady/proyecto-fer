package model;

public class Tecnico implements Nombrable {
	
	private String nombre;
	private FormacionStrategy form_strategy;
	
	public FormacionStrategy getForm_strategy() {
		return form_strategy;
	}
	
	public Formacion armarFormacion(Equipo eq){
		return this.getForm_strategy().armarFormacion(eq);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setForm_strategy(FormacionStrategy form_strategy) {
		this.form_strategy = form_strategy;
	}

	public String getNombre() {
		return null;
	}

}
