package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import appModel.Entity;

public class FormacionStrategyImpl extends Entity implements FormacionStrategy {
	/* VARIABLES ***************************************************/

	private List<Posicion> posiciones = new ArrayList<Posicion>();

	/* CONSTRUCTOR ***************************************************/
	public FormacionStrategyImpl() {
		
	}
	public FormacionStrategyImpl(List<Posicion> listaPos) {
		super();
		this.posiciones = listaPos;
	}
	
	/* METODOS ***************************************************/
	
	public Formacion armarFormacion(Equipo eq) {
		
		Formacion formacion_result = new Formacion(eq);
		
		List<Jugador> jugadoresPosibles = new ArrayList<Jugador>();
		jugadoresPosibles.addAll(eq.getJugadores()); //para realizar la busqueda

		Iterator<Posicion>it = this.getPosiciones().iterator();
				
		while (it.hasNext()){
			Posicion pos = it.next();
			Jugador jugadorTemp = buscarMejorEnPos(pos,jugadoresPosibles);
			jugadoresPosibles.remove(jugadorTemp);
			formacion_result.addTitular(new Titular(jugadorTemp, pos, formacion_result));
		}

		//agrego los suplentes
		for(Jugador jugador : jugadoresPosibles){
			formacion_result.addSuplente(jugador);
		}
		
		return formacion_result;
	}
	
	
	public Jugador buscarMejorEnPos(Posicion pos, List<Jugador> lista){
		
		Jugador jugadorGanador = lista.get(0); 
		
		for(Jugador j:lista){
			if(jugadorGanador.getValorHabilidad(pos) < j.getValorHabilidad(pos)){
				jugadorGanador = j;
			}
		}
		
		return jugadorGanador;
	}

/* PRINT***************************************************/

	@Override
	public void printValues() {
//		System.out.println("FormacionStrategy Posiciones:");
//		for(Posicion posicion : this.getPosiciones())
//			System.out.println(posicion.toString());
	}
	
	/* GET&SET ***************************************************/

	
	public List<Posicion> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(List<Posicion> posiciones) {
		this.posiciones = posiciones;
	}

}


