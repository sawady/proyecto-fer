package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import appModel.Entity;

public class Equipo extends Entity implements Nombrable{
	
/* VARIABLES ***************************************************/
	
	private Set<Jugador> jugadores; // Persistir!!
	private Tecnico tecnico; // no se persistirlo :ToDO
	private String nombre;
	
/* CONSTRUSTOR ***************************************************/
	
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
	
}
