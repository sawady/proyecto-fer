package model;

import java.util.HashSet;
import java.util.Set;
import appModel.Entity;

public class Formacion extends Entity {

/* VARIABLES ***************************************************/
	
	public Set<Titular> titulares = new HashSet<Titular>();
	public Set<Jugador> suplentes = new HashSet<Jugador>();
	public Equipo equipo;
	
 /* CONSTRUSTOR ***************************************************/
	
	public Formacion() {
	}
	public Formacion(Equipo equipo) {
		this.titulares = new HashSet<Titular>();
		this.suplentes = new HashSet<Jugador>();
		this.equipo = equipo;
	}
	
	public Formacion(Set<Titular> titulares, Set<Jugador> suplentes,
			Equipo equipo) {
		this.titulares = titulares;
		this.suplentes = suplentes;
		this.equipo = equipo;
	}
/* PRINT***************************************************/
	@Override
	public void printValues() {
		System.out.println("Formacion Equipo:");
		this.getEquipo().printValues();
		System.out.println("Formacion Titulares:");
		for(Titular titular : this.getTitulares())
			titular.printValues();
		System.out.println("Formacion Suplentes:");
		for(Jugador jugador : this.getSuplentes())
			jugador.printValues();
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
	
	
	public void setTitulares(Set<Titular> titulares) {
		this.titulares = titulares;
	}

	public void setSuplentes(Set<Jugador> suplentes) {
		this.suplentes = suplentes;
	}

	public void addTitular(Titular titular) {
		this.getTitulares().add(titular);
	}
	
	public void addSuplente(Jugador jugador) {
		this.getSuplentes().add(jugador);
	}
	
	
}
