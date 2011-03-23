package model;

public class PartidoDeCopa extends Partido {

	private int golesPorPenalEq1;
	private int golesPorPenalEq2;
	private PartidoSimple partidoIda;
	private PartidoSimple partidoVuelta;

	public int getGolesPorPenalEq1() {
		return golesPorPenalEq1;
	}

	public void setGolesPorPenalEq1(int golesPorPenalEq1) {
		this.golesPorPenalEq1 = golesPorPenalEq1;
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

	public Equipo getGanador() {
		
		Equipo ganadorIda    = this.getPartidoIda().getGanador();
		Equipo ganadorVuelta = this.getPartidoVuelta().getGanador(); 
		
		if((ganadorIda == null && ganadorVuelta == null) || // caso empataron 
		   (ganadorIda != null &&  ganadorVuelta != null && ganadorIda != ganadorVuelta))
		{
			if(this.getGolesPorPenalEq1() > this.getGolesPorPenalEq2())
				return this.getEquipo1();
			else
				return this.getEquipo2();
		}
		else if(ganadorIda == null)
			return ganadorVuelta;
		else if(ganadorVuelta == null)
			return ganadorIda;
		else
			return ganadorVuelta; // ganadorIda == ganadorVuelta
		
		
	}
}
