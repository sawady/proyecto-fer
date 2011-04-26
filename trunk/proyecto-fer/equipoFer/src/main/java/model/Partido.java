package model;

import appModel.Entity;

public abstract class Partido extends Entity {
	
	
	/* VARIABLES ***************************************************/

	protected Equipo equipo1;
	protected Equipo equipo2;
	
	
	/* METODOS ***************************************************/

	public abstract Equipo getGanador();
	
	/* GET&SET ***************************************************/

	public Equipo getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}
	public Equipo getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}
	

	

}
