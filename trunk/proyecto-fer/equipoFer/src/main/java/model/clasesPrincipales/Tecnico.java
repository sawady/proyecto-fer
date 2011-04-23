package model.clasesPrincipales;

import model.formaciones.Formacion;
import model.formaciones.FormacionStrategy;
import model.util.Nombrable;
import appModel.Entity;

public class Tecnico extends Entity implements Nombrable {
	
/* VARIABLES ***************************************************/

	private String nombre;
	private FormacionStrategy form_strategy;
	
/* CONSTRUSTOR ***************************************************/
	
	public Tecnico() {
	}
	
	public Tecnico(String nombre, FormacionStrategy form_strategy) {
		super();
		this.nombre = nombre;
		this.form_strategy = form_strategy;
	}
	
/* METODOS ***************************************************/

	public Formacion armarFormacion(Equipo eq){
		return this.getForm_strategy().armarFormacion(eq);
	}

/* PRINT ***************************************************/
	@Override
	public void printValues() {
		System.out.println("Tecnico Nombre: " + this.getNombre());
		System.out.println("Tecnico FormStrategy:");
		this.getForm_strategy().printValues();
		
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
