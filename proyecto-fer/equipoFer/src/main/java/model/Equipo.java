package model;

import java.util.HashSet;
import java.util.Set;

import appModel.Entity;

public class Equipo extends Entity implements Nombrable{
	
/* VARIABLES ***************************************************/
	
	private Set<Jugador> jugadores; 
	private Tecnico tecnico; 
	private String nombre;
	
/* CONSTRUSTOR ***************************************************/
	
	public Equipo(String nombre, Tecnico tecnico) {
		super();
		this.jugadores = new HashSet<Jugador>();
		this.tecnico = tecnico;
		this.nombre = nombre;
	}
	
	public Equipo(Set<Jugador> jugadores, Tecnico tecnico) {
		super();
		this.jugadores = jugadores;
		this.tecnico = tecnico;
	}
		 	
/* METODOS ***************************************************/
	
	public Formacion armarFormacion(){
		return this.getTecnico().armarFormacion(this);
	}
	
/* GET&SET ***************************************************/

	public Set<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(HashSet<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Equipo addJugador(Jugador jugador) {
		this.getJugadores().add(jugador);
		return this;
	}
	
	public Equipo removeJugador(Jugador jugador) {
		this.getJugadores().remove(jugador);
		return this;
	}		
	
}
