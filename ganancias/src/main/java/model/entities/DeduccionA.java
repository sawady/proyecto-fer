package model.entities;

import persistencia.Entity;

public class DeduccionA extends Entity{
	private float min_no_imp;
	private float dedu_espe;
	private float conyuge;
	private float hijos;
	private float otros;
	

	public DeduccionA() {
		super();
	}
	public DeduccionA(int id) {
		super(id);
	}
	
	public DeduccionA(float min_no_imp, float dedu_espe, float conyuge,
			float hijos, float otros) {
		super();
		this.min_no_imp = min_no_imp;
		this.dedu_espe = dedu_espe;
		this.conyuge = conyuge;
		this.hijos = hijos;
		this.otros = otros;
	}
	public float getMin_no_imp() {
		return min_no_imp;
	}
	public void setMin_no_imp(float min_no_imp) {
		this.min_no_imp = min_no_imp;
	}
	public float getDedu_espe() {
		return dedu_espe;
	}
	public void setDedu_espe(float dedu_espe) {
		this.dedu_espe = dedu_espe;
	}
	public float getConyuge() {
		return conyuge;
	}
	public void setConyuge(float conyuge) {
		this.conyuge = conyuge;
	}
	public float getHijos() {
		return hijos;
	}
	public void setHijos(float hijos) {
		this.hijos = hijos;
	}
	public float getOtros() {
		return otros;
	}
	public void setOtros(float otros) {
		this.otros = otros;
	}
	
	

	

}
