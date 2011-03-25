package model;

import java.util.ArrayList;
import java.util.List;

public class Formacion {

/* VARIABLES ***************************************************/
	
	public List<Titular> titulares = new ArrayList<Titular>();
	public List<Jugador> suplentes = new ArrayList<Jugador>();
	public Equipo equipo;
	
 /* CONSTRUSTOR ***************************************************/
	
	public Formacion(List<Titular> titulares, List<Jugador> suplentes,
			Equipo equipo) {
		this.titulares = titulares;
		this.suplentes = suplentes;
		this.equipo = equipo;
	}

/* GET&SET ***************************************************/
	
	public List<Titular> getTitulares() {
		return titulares;
	}
	
	public List<Jugador> getSuplentes() {
		return suplentes;
	}
	
	public Equipo getEquipo() {
		return equipo;
	}

	public void setTitulares(List<Titular> titulares) {
		this.titulares = titulares;
	}

	public void setSuplentes(List<Jugador> suplentes) {
		this.suplentes = suplentes;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
}
