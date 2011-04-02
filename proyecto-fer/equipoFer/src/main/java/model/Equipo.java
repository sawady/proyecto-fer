package model;

import java.util.List;

public class Equipo implements Nombrable{
	
/* VARIABLES ***************************************************/
	
	private List<Jugador> jugadores; // no se persistirlo ToDO
	private Tecnico tecnico; // no se persistirlo ToDO
	private String nombre;
	
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
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
