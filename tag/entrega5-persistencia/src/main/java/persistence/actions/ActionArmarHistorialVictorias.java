package persistence.actions;

import java.util.List;

import appModel.Home;

import model.Equipo;
import model.PartidoSimple;
import persistence.hibernate.HibernateApplication;
import persistence.hibernate.HibernatePartidoSimpleHome;

public class ActionArmarHistorialVictorias implements Action {
	
	/* VARIABLES*************************************************************************/
	
	private String eq1;
	private String eq2;
	private int victoriasEq1;
	private int victoriasEq2;
	private int empates;

	/* CONSTRUCTOR*************************************************************************/
	
	public ActionArmarHistorialVictorias(String eq1, String eq2) {
		super();
		this.eq1 = eq1;
		this.eq2 = eq2;
		
		this.victoriasEq1=0;
		this.victoriasEq2=0;
		this.empates=0;
	}

	/* METODOS*************************************************************************/

	public void execute() {
		
		HibernatePartidoSimpleHome home = (HibernatePartidoSimpleHome) HibernateApplication.getInstance().getHome(PartidoSimple.class);
		
		Home<Equipo> homeEquipo = HibernateApplication.getInstance().getHome(Equipo.class);
		
		Equipo eq1 = homeEquipo.getNombrable(this.getEq1());
		Equipo eq2 = homeEquipo.getNombrable(this.getEq2());
		
		List<PartidoSimple> partidos = (List<PartidoSimple>) home.getByAdversarios(eq1, eq2);
		
		for (PartidoSimple partidoSimple : partidos) {
			if (partidoSimple.empataron()){
				setEmpates(getEmpates() + 1);
			}
			else if (partidoSimple.getGanador().equals(eq1)){
				setVictoriasEq1(getVictoriasEq1() + 1);
			}
			else {
				setVictoriasEq2(getVictoriasEq2() + 1);
			}
		}	
		
		this.imprimirResultados();
		
	}
	
	private void imprimirResultados(){
		System.out.println(this.getEq1() + " gano " + this.getVictoriasEq1() + "partidos");
		System.out.println(this.getEq2() + " gano " + this.getVictoriasEq2() + "partidos");
		System.out.println("Empataron " + this.getEmpates() + "partidos");
	}
	
	/* GET&SET*************************************************************************/
	public String getEq1() {
		return eq1;
	}

	public void setEq1(String eq1) {
		this.eq1 = eq1;
	}

	public String getEq2() {
		return eq2;
	}

	public void setEq2(String eq2) {
		this.eq2 = eq2;
	}

	public int getVictoriasEq1() {
		return victoriasEq1;
	}

	public void setVictoriasEq1(int victoriasEq1) {
		this.victoriasEq1 = victoriasEq1;
	}

	public int getVictoriasEq2() {
		return victoriasEq2;
	}

	public void setVictoriasEq2(int victoriasEq2) {
		this.victoriasEq2 = victoriasEq2;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

}
