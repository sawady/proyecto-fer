package model;

public class PartidoSimple extends Partido {

	private int golesEq1;
	private int golesEq2;
	private Formacion formacionEq1;
	private Formacion formacionEq2;

	public Formacion getFormacionEq1() {
		return formacionEq1;
	}

	public void setFormacionEq1(Formacion formacionEq1) {
		this.formacionEq1 = formacionEq1;
	}

	public Formacion getFormacionEq2() {
		return formacionEq2;
	}

	public void setFormacionEq2(Formacion formacionEq2) {
		this.formacionEq2 = formacionEq2;
	}

	public int getGolesEq1() {
		return golesEq1;
	}

	public void setGolesEq1(int golesEq1) {
		this.golesEq1 = golesEq1;
	}

	public int getGolesEq2() {
		return golesEq2;
	}

	public void setGolesEq2(int golesEq2) {
		this.golesEq2 = golesEq2;
	}

	public Equipo getGanador() {
		if(this.getGolesEq1() > this.getGolesEq2())
			return this.getEquipo1();
		else if(this.getGolesEq1() == this.getGolesEq2())
			return this.getEquipo2();
		else // caso en que empataron
			return null;
	}
}
