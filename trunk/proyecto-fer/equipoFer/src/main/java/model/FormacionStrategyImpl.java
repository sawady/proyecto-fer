package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import appModel.Entity;

public class FormacionStrategyImpl extends Entity implements FormacionStrategy {
	/* VARIABLES ***************************************************/

	private List<Posicion> posiciones = new ArrayList<Posicion>();

	/* CONSTRUCTOR ***************************************************/
	
	public FormacionStrategyImpl(List<Posicion> listaPos) {
		super();
		this.posiciones = listaPos;
	}
	
	/* METODOS ***************************************************/
	
	public Formacion armarFormacion(Equipo eq) {
		
		ArrayList<Jugador> auxList = new ArrayList<Jugador>();
		auxList.addAll(eq.getJugadores()); //para realizar la busqueda
		Set<Titular>titulares= new HashSet<Titular>(); ///titulares
		Set<Jugador>suplentes= new HashSet<Jugador>(); // suplentes

		Iterator<Posicion>it= this.getPosiciones().iterator();
				
		while (it.hasNext()){
			Posicion pos = it.next();
			Jugador jugadorTemp = buscarMejorEnPos(pos,auxList);
			auxList.remove(jugadorTemp);
			titulares.add(new Titular(jugadorTemp, pos));
		}

		//agrego los suplentes
		for(Jugador j:auxList){
			suplentes.add(j);
		}
		
		Formacion form_result = new Formacion(titulares, suplentes,eq);
		
		for(Titular t : titulares){
			t.setFormacion(form_result);
		}
		
		return form_result;
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
	
	/* GET&SET ***************************************************/

	
	public List<Posicion> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(List<Posicion> posiciones) {
		this.posiciones = posiciones;
	}

}


