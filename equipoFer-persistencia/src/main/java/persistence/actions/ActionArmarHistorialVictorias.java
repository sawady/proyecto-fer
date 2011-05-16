package persistence.actions;

import java.util.List;

import model.Equipo;
import model.PartidoSimple;
import persistence.hibernate.HibernateApplication;
import persistence.hibernate.HibernatePartidoSimpleHome;

public class ActionArmarHistorialVictorias implements Action {
	
	/* VARIABLES*************************************************************************/
	
	private Equipo eq1;
	private Equipo eq2;
	private int victoriasEq1;
	private int victoriasEq2;
	private int empates;

	/* CONSTRUCTOR*************************************************************************/
	
	public ActionArmarHistorialVictorias(Equipo eq1, Equipo eq2) {
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
		
		List<PartidoSimple> partidos = (List<PartidoSimple>) home.getByAdversarios(this.getEq1(), this.getEq2());
		
		
		for (PartidoSimple partidoSimple : partidos) {
			if (partidoSimple.empataron()){
				setEmpates(getEmpates() + 1);
			}
			else if (partidoSimple.getGanador().equals(this.getEq1())){
				setVictoriasEq1(getVictoriasEq1() + 1);
			}
			else {
				setVictoriasEq2(getVictoriasEq2() + 1);
			}
			
		}
		
	}
	
	/* GET&SET*************************************************************************/
	public Equipo getEq1() {
		return eq1;
	}

	public void setEq1(Equipo eq1) {
		this.eq1 = eq1;
	}

	public Equipo getEq2() {
		return eq2;
	}

	public void setEq2(Equipo eq2) {
		this.eq2 = eq2;
	}
	

	private void setVictoriasEq1(int victoriasEq1) {
		this.victoriasEq1 = victoriasEq1;
	}

	private int getVictoriasEq1() {
		return victoriasEq1;
	}

	private void setVictoriasEq2(int victoriasEq2) {
		this.victoriasEq2 = victoriasEq2;
	}

	private int getVictoriasEq2() {
		return victoriasEq2;
	}

	private void setEmpates(int empates) {
		this.empates = empates;
	}

	private int getEmpates() {
		return empates;
	}

}
