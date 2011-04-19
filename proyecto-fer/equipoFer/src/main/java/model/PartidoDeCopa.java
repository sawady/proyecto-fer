package model;

public class PartidoDeCopa extends Partido {
	//KZ7ky7RZ9AN2 
	/* VARIABLES ***************************************************/

	private int golesPorPenalEq1;
	private int golesPorPenalEq2;
	private PartidoSimple partidoIda;
	private PartidoSimple partidoVuelta;

	/* CONSTRUSTOR ***************************************************/

	public PartidoDeCopa(){}
	
	public PartidoDeCopa(int golesPorPenalEq1, int golesPorPenalEq2,
			PartidoSimple partidoIda, PartidoSimple partidoVuelta, Equipo equipo1, Equipo equipo2) {
		this.golesPorPenalEq1 = golesPorPenalEq1;
		this.golesPorPenalEq2 = golesPorPenalEq2;
		this.partidoIda = partidoIda;
		this.partidoVuelta = partidoVuelta;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}
	
	/* METODOS ***************************************************/

	public Equipo getGanador() {
		
		Equipo ganadorIda    = this.getPartidoIda().getGanador();
		Equipo ganadorVuelta = this.getPartidoVuelta().getGanador(); 
		
		if((ganadorIda == null && ganadorVuelta == null) || // caso empataron 
		   (ganadorIda != null &&  ganadorVuelta != null && ganadorIda != ganadorVuelta))//caso en c/u gano un partido
		{
			if(this.getGolesPorPenalEq1() > this.getGolesPorPenalEq2())
				return this.getEquipo1();
			else
				return this.getEquipo2();
		}
		else if(ganadorIda == null) // empataron partida de ida
			return ganadorVuelta;
		else if(ganadorVuelta == null) //empataron partido de vuelta
			return ganadorIda;
		else
			return ganadorVuelta; // ganadorIda == ganadorVuelta
	}
	
	
	/* GET&SET ***************************************************/

	public void setGolesPorPenalEq1(int golesPorPenalEq1) {
		this.golesPorPenalEq1 = golesPorPenalEq1;
	}

	public int getGolesPorPenalEq1() {
		return golesPorPenalEq1;
	}
	
	public int getGolesPorPenalEq2() {
		return golesPorPenalEq2;
	}

	public void setGolesPorPenalEq2(int golesPorPenalEq2) {
		this.golesPorPenalEq2 = golesPorPenalEq2;
	}

	public PartidoSimple getPartidoIda() {
		return partidoIda;
	}

	public void setPartidoIda(PartidoSimple partidoIda) {
		this.partidoIda = partidoIda;
	}

	public PartidoSimple getPartidoVuelta() {
		return partidoVuelta;
	}

	public void setPartidoVuelta(PartidoSimple partidoVuelta) {
		this.partidoVuelta = partidoVuelta;
	}


}
