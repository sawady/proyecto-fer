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
	
	
	/* METODOS ***************************************************/
	
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
	

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result
//				+ ((formacion == null) ? 0 : formacion.hashCode());
//		result = prime * result + ((jugador == null) ? 0 : jugador.hashCode());
//		result = prime * result
//				+ ((posicion == null) ? 0 : posicion.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Titular other = (Titular) obj;
//		if (formacion == null) {
//			if (other.formacion != null)
//				return false;
//		} else if (!formacion.equals(other.formacion))
//			return false;
//		if (jugador == null) {
//			if (other.jugador != null)
//				return false;
//		} else if (!jugador.equals(other.jugador))
//			return false;
//		if (posicion != other.posicion)
//			return false;
//		return true;
//	}

	@Override
	public void printValues() {
		System.out.println("Titular Jugador: ");
		this.getJugador().printValues();
//		System.out.println("Titular Posicion: " + this.getPosicion().toString());
//		System.out.println("Titular Formacion:");
//		this.getFormacion().printValues();
	}
	
}
