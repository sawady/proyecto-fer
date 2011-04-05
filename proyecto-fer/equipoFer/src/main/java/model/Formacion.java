package model;

import java.util.HashSet;
import java.util.Set;

public class Formacion {

/* VARIABLES ***************************************************/
	
	public Set<Titular> titulares = new HashSet<Titular>();
	public Set<Jugador> suplentes = new HashSet<Jugador>();
	public Equipo equipo;
	
 /* CONSTRUSTOR ***************************************************/
	
	public Formacion(Set<Titular> titulares, Set<Jugador> suplentes,
			Equipo equipo) {
		this.titulares = titulares;
		this.suplentes = suplentes;
		this.equipo = equipo;
	}

/* GET&SET ***************************************************/
	
	public Set<Titular> getTitulares() {
		return titulares;
	}
	
	public Set<Jugador> getSuplentes() {
		return suplentes;
	}
	
	public Equipo getEquipo() {
		return equipo;
	}

	public void setTitulares(HashSet<Titular> titulares) {
		this.titulares = titulares;
	}

	public void setSuplentes(HashSet<Jugador> suplentes) {
		this.suplentes = suplentes;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
}
