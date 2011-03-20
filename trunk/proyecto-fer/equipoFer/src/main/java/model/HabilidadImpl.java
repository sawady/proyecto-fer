package model;

public class HabilidadImpl implements Habilidad{
	
	/* VARIABLES ***************************************************/

	private Posicion posicion;
	private int valor;
	
	/* CONSTRUSTOR ***************************************************/
	/* METODOS ***************************************************/
	/* GET&SET ***************************************************/

	
	public Posicion getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
	
	public int getValor(Posicion pos) {
		
		if(pos == this.getPosicion())
			return this.getValor();		
		else
			return 0;
		
	}

}
