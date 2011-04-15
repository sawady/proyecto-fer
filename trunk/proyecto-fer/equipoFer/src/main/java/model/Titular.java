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

/* EQUALS & HASHCODE ***************************************************/

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jugador == null) ? 0 : jugador.hashCode());
		result = prime * result + ((pos == null) ? 0 : pos.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Titular other = (Titular) obj;
		if (jugador == null) {
			if (other.jugador != null)
				return false;
		} else if (!jugador.equals(other.jugador))
			return false;
		if (pos != other.pos)
			return false;
		return true;
	}
}
