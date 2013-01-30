package model.entities;

import persistencia.Entity;

public class TopeSalarial extends Entity {

	private float soltero;
	private float casado;
	
	public TopeSalarial() {
		super();
	}
	
	public TopeSalarial(float soltero, float casado) {
		super();
		this.soltero = soltero;
		this.casado = casado;
	}


	public float getSoltero() {
		return soltero;
	}
	public void setSoltero(float soltero) {
		this.soltero = soltero;
	}
	public float getCasado() {
		return casado;
	}
	public void setCasado(float casado) {
		this.casado = casado;
	}
	
	
}
