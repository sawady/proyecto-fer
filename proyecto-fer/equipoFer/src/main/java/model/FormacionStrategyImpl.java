package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FormacionStrategyImpl implements FormacionStrategy {
	/* VARIABLES ***************************************************/

	private Set<Posicion> posiciones = new HashSet<Posicion>();

	/* CONSTRUCTOR ***************************************************/
	
	public FormacionStrategyImpl(HashSet<Posicion> posiciones) {
		super();
		this.posiciones = posiciones;
	}

	
	/* METODOS ***************************************************/
	
	public Formacion armarFormacion(Equipo eq) {
		
		ArrayList<Jugador> auxList = new ArrayList<Jugador>();
		auxList.addAll(eq.getJugadores()); //para realizar la busqueda
		Set<Titular>titulares= new HashSet<Titular>(); ///para armar la formacion
		Set<Jugador>suplentes= new HashSet<Jugador>(); //para armar la formacion


		Iterator<Posicion>it= this.getPosiciones().iterator();
		while (it.hasNext()){
			Jugador jugadorTemp = buscarMejorEnPos(it.next(),auxList);
			auxList.remove(jugadorTemp);
			titulares.add(new Titular(jugadorTemp, it.next()));
			
		}
		//ultimo elemento
		Jugador jugadorTemp = buscarMejorEnPos(it.next(),auxList);
		auxList.remove(jugadorTemp);
		titulares.add(new Titular(jugadorTemp, it.next()));

		//agrego los suplentes
		for(Jugador j:auxList){
			suplentes.add(j);
		}
		return new Formacion(titulares, suplentes,eq);
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

	
	public Set<Posicion> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(HashSet<Posicion> posiciones) {
		this.posiciones = posiciones;
	}


}


