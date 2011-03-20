package model;

import java.util.ArrayList;
import java.util.List;

public class FormacionStrategyImpl implements FormacionStrategy {
	/* VARIABLES ***************************************************/

	private List<Posicion> posiciones = new ArrayList<Posicion>();

	/* CONSTRUSTOR ***************************************************/
	/* METODOS ***************************************************/
	
	public Formacion armarFormacion(Equipo eq) {
		
		ArrayList<Jugador> auxList = new ArrayList<Jugador>();
		auxList.addAll(eq.getJugadores());
		
		Formacion f = new Formacion();
		for (Posicion pos: this.getPosiciones()){
			f.titulares.add(buscarMejorEnPos(pos, auxList)); 
			//falta q saq el jugador
		}
		
		return f;
	}
	
	public Jugador buscarMejorEnPos(Posicion pos, List<Jugador> lista){
		return null;		
	}
	
	/* GET&SET ***************************************************/

	
	public List<Posicion> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(List<Posicion> posiciones) {
		this.posiciones = posiciones;
	}

}
