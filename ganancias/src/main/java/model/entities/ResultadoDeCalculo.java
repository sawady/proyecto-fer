package model.entities;

import persistencia.Entity;

public class ResultadoDeCalculo extends Entity{
	private double CUIL;
	private String nom_y_ape;
	private float RNIF;
	private float gananciaA;
	private float gananciaB;
	private float gananciaC;
	private float imp_ganan_periodo;
	private float imp_ganan_a_pagar_mes;
	private float Dev_IIGG;
	
	
	public float getImp_ganan_periodo() {
		return imp_ganan_periodo;
	}
	public void setImp_ganan_periodo(float imp_ganan_periodo) {
		this.imp_ganan_periodo = imp_ganan_periodo;
	}
	
	public double getCUIL() {
		return CUIL;
	}
	public void setCUIL(double cUIL) {
		CUIL = cUIL;
	}
	public String getNom_y_ape() {
		return nom_y_ape;
	}
	public void setNom_y_ape(String nom_y_ape) {
		this.nom_y_ape = nom_y_ape;
	}
	public float getRNIF() {
		return RNIF;
	}
	public void setRNIF(float rNIF) {
		RNIF = rNIF;
	}
	public float getGananciaA() {
		return gananciaA;
	}
	public void setGananciaA(float gananciaA) {
		this.gananciaA = gananciaA;
	}
	public float getGananciaB() {
		return gananciaB;
	}
	public void setGananciaB(float gananciaB) {
		this.gananciaB = gananciaB;
	}
	public float getGananciaC() {
		return gananciaC;
	}
	public void setGananciaC(float gananciaC) {
		this.gananciaC = gananciaC;
	}
	public float getImp_ganan_a_pagar_mes() {
		return imp_ganan_a_pagar_mes;
	}
	public void setImp_ganan_a_pagar_mes(float imp_ganan_a_pagar_mes) {
		this.imp_ganan_a_pagar_mes = imp_ganan_a_pagar_mes;
	}
	public float getDev_IIGG() {
		return Dev_IIGG;
	}
	public void setDev_IIGG(float dev_IIGG) {
		Dev_IIGG = dev_IIGG;
	}
	
	
}
