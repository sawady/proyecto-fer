package model.entities;

import persistencia.Entity;

public class CamposParaCalculoAnual extends Entity {

	private float desde;
	private float hasta;
	private float base;
	private float por_extra;
	private float sobre_exced;
	
	
	
	public CamposParaCalculoAnual() {
		super();
	}
	public CamposParaCalculoAnual(int id) {
		super(id);
	}
	public CamposParaCalculoAnual(float desde, float hasta, float base,
			float por_extra, float sobre_exced) {
		super();
		this.desde = desde;
		this.hasta = hasta;
		this.base = base;
		this.por_extra = por_extra;
		this.sobre_exced = sobre_exced;
	}
	public float getDesde() {
		return desde;
	}
	public void setDesde(float desde) {
		this.desde = desde;
	}
	public float getHasta() {
		return hasta;
	}
	public void setHasta(float hasta) {
		this.hasta = hasta;
	}
	public float getBase() {
		return base;
	}
	public void setBase(float base) {
		this.base = base;
	}
	public float getPor_extra() {
		return por_extra;
	}
	public void setPor_extra(float por_extra) {
		this.por_extra = por_extra;
	}
	public float getSobre_exced() {
		return sobre_exced;
	}
	public void setSobre_exced(float sobre_exced) {
		this.sobre_exced = sobre_exced;
	}
}
