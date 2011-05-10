package model;

import java.util.Date;



public class PartidoSimple extends Partido {
	
	/* VARIABLES ***************************************************/

	private Date fecha;
	private int golesEq1;
	private int golesEq2;
	private Formacion formacionEq1;
	private Formacion formacionEq2;

	
	/* CONSTRUSTOR ***************************************************/

	public PartidoSimple(){}
	
	public PartidoSimple(Equipo equipo1, int golEq1, Equipo equipo2, int golEq2, Date fecha) {
			this.equipo1 = equipo1;
			this.golesEq1 = golEq1;
			this.formacionEq1 = equipo1.armarFormacion(); // es correcto tener un metodo dentro de un constructor??
			this.equipo2 = equipo2;
			this.golesEq2 = golEq2;
			this.formacionEq2 = equipo2.armarFormacion();
			this.fecha = fecha;
	}

	/* METODOS ***************************************************/

	public Equipo getGanador() {
		if(this.getGolesEq1() > this.getGolesEq2())
			return this.getEquipo1();
		else if(this.getGolesEq1() < this.getGolesEq2())
			return this.getEquipo2();
		else // caso en que empataron
			return null;
	}
	
	public boolean empataron(){
		return this.getGanador()==null;
	} 
	
	/* GET&SET ***************************************************/

	
	public Formacion getFormacionEq1() {
		return formacionEq1;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	@Override
	public void printValues() {
		// TODO Auto-generated method stub
		
	}


}
