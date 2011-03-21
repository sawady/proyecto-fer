package model;

public class HabilidadImpl implements Habilidad{
	
	/* VARIABLES ***************************************************/

	private Posicion posicion;
	private int valor;
	
	/* CONSTRUSTOR ***************************************************/
	
	public HabilidadImpl(Posicion posicion, int valor) {
		super();
		this.posicion = posicion;
		this.valor = valor;
	}

	
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

	/* EQUALS & HASHCODE**************************************************/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((posicion == null) ? 0 : posicion.hashCode());
		result = prime * result + valor;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HabilidadImpl other = (HabilidadImpl) obj;
		if (posicion != other.posicion)
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}
	
	

}
