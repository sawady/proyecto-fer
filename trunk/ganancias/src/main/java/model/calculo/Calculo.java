package model.calculo;

import model.entities.CamposParaCalculoAnual;
import model.entities.DeduccionA;
import model.entities.DeduccionC;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.CamposParaCalculoAnualHibernateHome;
import persistencia.hibernateHome.HibernateHome;

public class Calculo {
	protected DeduccionA deduccionA;
	protected DeduccionC deduccionC;
	protected CamposParaCalculoAnual calculo_anual;
	protected CamposParaCalculoAnualHibernateHome calculo_anual_home = (CamposParaCalculoAnualHibernateHome) HibernateApplication.getInstance().getHome(CamposParaCalculoAnual.class);
	protected float resultadoGananciaNetaC;


	
	public Calculo() {
		super();
		HibernateHome<DeduccionA>temporal = (HibernateHome<DeduccionA>) HibernateApplication.getInstance().getHome(DeduccionA.class);
		this.deduccionA = temporal.getFirst();
		HibernateHome<DeduccionC>temporal2 = (HibernateHome<DeduccionC>) HibernateApplication.getInstance().getHome(DeduccionC.class);
		this.deduccionC =  temporal2.getFirst();
	}
	
	
	
	public DeduccionA getDeduccionA() {
		return deduccionA;
	}

	public void setDeduccionA(DeduccionA deduccionA) {
		this.deduccionA = deduccionA;
	}

	public DeduccionC getDeduccionC() {
		return deduccionC;
	}

	public void setDeduccionC(DeduccionC deduccionC) {
		this.deduccionC = deduccionC;
	}
	public CamposParaCalculoAnual getCalculo_anual() {
		return calculo_anual;
	}

	public void setCalculo_anual(CamposParaCalculoAnual calculo_anual) {
		this.calculo_anual = calculo_anual;
	}
}
