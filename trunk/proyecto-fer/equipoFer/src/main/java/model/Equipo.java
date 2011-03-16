package model;

import java.util.List;

public class Equipo implements Nombrable{
	
	private List<Jugador> jugadores;
	private Tecnico tecnico;
	
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

	public Formacion armarFormacion(){
		return this.getTecnico().armarFormacion(this);
	}

	public String getNombre() {
		return null;
	}

}
