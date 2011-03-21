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
		return null;
	}

	
	/* EQUALS & HASHCODE**************************************************/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((form_strategy == null) ? 0 : form_strategy.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tecnico other = (Tecnico) obj;
		if (form_strategy == null) {
			if (other.form_strategy != null)
				return false;
		} else if (!form_strategy.equals(other.form_strategy))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	
	
}
