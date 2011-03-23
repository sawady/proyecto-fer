package model;

import java.util.ArrayList;
import java.util.List;

public class FormacionStrategyImpl implements FormacionStrategy {
	/* VARIABLES ***************************************************/

	private List<Posicion> posiciones = new ArrayList<Posicion>();

	/* CONSTRUCTOR ***************************************************/
	
	public FormacionStrategyImpl(List<Posicion> posiciones) {
		super();
		this.posiciones = posiciones;
	}

	
	/* METODOS ***************************************************/
	
	public Formacion armarFormacion(Equipo eq) {
		
		ArrayList<Jugador> auxList = new ArrayList<Jugador>();
		auxList.addAll(eq.getJugadores());
		Formacion f = new Formacion();
		
		for (Posicion pos: this.getPosiciones()){
			Jugador jugadorTemp = buscarMejorEnPos(pos,auxList);
			auxList.remove(jugadorTemp);
			f.getTitulares().add(new Titular(jugadorTemp, pos));
		}
		
		f.getSuplentes().addAll(auxList);
		f.setEquipo(eq);
		return f;
	}
	
	
	public Jugador buscarMejorEnPos(Posicion pos, List<Jugador> lista){
		Jugador jugadorGanador = lista.get(0); 
		for(Jugador j:lista){
			if(jugadorGanador.getValorHabilidad(pos)< j.getValorHabilidad(pos)){
				jugadorGanador = j;
			}
		}
		return jugadorGanador;
	}
	
	/* GET&SET ***************************************************/

	
	public List<Posicion> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(List<Posicion> posiciones) {
		this.posiciones = posiciones;
	}


}


