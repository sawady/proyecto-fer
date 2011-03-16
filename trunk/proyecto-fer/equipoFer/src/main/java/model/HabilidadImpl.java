package model;

public class HabilidadImpl implements Habilidad{
	
	private Posicion posicion;
	private int valor;
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getValor(Posicion pos) {
		
		if(pos == this.getPosicion())
			return this.getValor();		
		else
			return 0;
		
	}

}
