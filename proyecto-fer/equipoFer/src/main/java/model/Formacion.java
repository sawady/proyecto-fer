package model;

import java.util.ArrayList;
import java.util.List;

public class Formacion {
	
	public List<Titular> titulares = new ArrayList<Titular>();
	public List<Jugador> suplentes;
	public Equipo equipo;
	
	public List<Titular> getTitulares() {
		return titulares;
	}
	
	public List<Jugador> getSuplentes() {
		return suplentes;
	}
	
	public Equipo getEquipo() {
		return equipo;
	}

}
