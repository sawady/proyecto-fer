package model;

import java.util.List;

public class Equipo implements Nombrable{
	
/* VARIABLES ***************************************************/
	
	private List<Jugador> jugadores;
	private Tecnico tecnico;
	
/* CONSTRUSTOR ***************************************************/
	
	public Equipo(List<Jugador> jugadores, Tecnico tecnico) {
		super();
		this.jugadores = jugadores;
		this.tecnico = tecnico;
	}
		 	
/* METODOS ***************************************************/
	
	public Formacion armarFormacion(){
		return this.getTecnico().armarFormacion(this);
	}
	
/* GET&SET ***************************************************/

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public String getNombre() {
		return null;
	}

	
	/*  EQUALS&HASHCODE*********************************************************************/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((jugadores == null) ? 0 : jugadores.hashCode());
		result = prime * result + ((tecnico == null) ? 0 : tecnico.hashCode());
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
		Equipo other = (Equipo) obj;
		if (jugadores == null) {
			if (other.jugadores != null)
				return false;
		} else if (!jugadores.equals(other.jugadores))
			return false;
		if (tecnico == null) {
			if (other.tecnico != null)
				return false;
		} else if (!tecnico.equals(other.tecnico))
			return false;
		return true;
	}


	
	
	
}
