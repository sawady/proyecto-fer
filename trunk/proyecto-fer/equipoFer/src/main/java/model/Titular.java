package model;

import appModel.Entity;

public class Titular extends Entity {
	
/* VARIABLES ***************************************************/
	
	public Jugador jugador;
	public Posicion pos;
	public Formacion formacion;
	
	/* CONSTRUSTOR ***************************************************/
	public Titular(Jugador jugador, Posicion pos, Formacion form) {
		super();
		this.jugador = jugador;
		this.pos = pos;
		this.formacion = form;
	}
	
	
	/* METODOS ***************************************************/
	
	/* GET&SET ***************************************************/
	
	public Jugador getJugador() {
		return jugador;
	}
	
	public Posicion getPos() {
		return pos;
	}
	
	public Formacion getFormacion() {
		return formacion;
	}


	public void setFormacion(Formacion formacion) {
		this.formacion = formacion;
	}
	
}
