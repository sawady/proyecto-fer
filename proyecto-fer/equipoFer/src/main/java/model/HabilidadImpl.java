package model;

import appModel.Entity;

public class HabilidadImpl extends Entity implements Habilidad{
	
	/* VARIABLES ***************************************************/

	private Posicion posicion;
	private int valor;
	private Jugador jugador;
	
	/* CONSTRUSTOR ***************************************************/
	
	public HabilidadImpl(Posicion posicion, int valor, Jugador jug) {
		super();
		this.posicion = posicion;
		this.jugador = jug;
		this.valor = valor;
	}

	
	/* METODOS ***************************************************/
	/* GET&SET ***************************************************/

	public Posicion getPosicion() {
		return posicion;
	}
	
	
	public Jugador getJugador() {
		return jugador;
	}


	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}


	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}
	

	public int getValor() {
		return valor;
	}
	
	public int getValor(Posicion pos) {
		
		if(pos.equals(this.getPosicion()))
			return this.getValor();		
		else
			return 0;		
	}

}
