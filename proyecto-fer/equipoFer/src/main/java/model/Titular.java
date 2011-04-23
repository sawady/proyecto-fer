package model;

import appModel.Entity;

public class Titular extends Entity {
	
/* VARIABLES ***************************************************/
	
	public Jugador jugador;
	public Posicion posicion;
	public Formacion formacion;
	
	/* CONSTRUSTOR ***************************************************/
	public Titular(){}
	
	public Titular(Jugador jugador, Posicion pos, Formacion form) {
		super();
		this.jugador = jugador;
		this.posicion = pos;
		this.formacion = form;
	}
	
	
	/* PRINT ***************************************************/
	@Override
	public void printValues() {
		System.out.println("Titular Jugador: ");
		this.getJugador().printValues();
//		System.out.println("Titular Posicion: " + this.getPosicion().toString());
//		System.out.println("Titular Formacion:");
//		this.getFormacion().printValues();
	}	
	/* GET&SET ***************************************************/
	
	public Jugador getJugador() {
		return jugador;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}


	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}


	public Formacion getFormacion() {
		return formacion;
	}


	public void setFormacion(Formacion formacion) {
		this.formacion = formacion;
	}
}
