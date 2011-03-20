package model;

import java.util.List;

public class Jugador implements Nombrable{
	
	/* VARIABLES ***************************************************/
	
	private List<Habilidad> habilidades;
	
	/* CONSTRUSTOR ***************************************************/
	/* METODOS ***************************************************/
	
	public int getValorHabilidad(Posicion pos){
		int result = 0;
		for( Habilidad x:this.getHabilidades()){
			result = max(x.getValor(pos), result);
		}
		return result;
	}
	
	private int max(int v1, int v2) {
		if(v1<=v2)
			return v2;
		else
			return v1;
	}
	/* GET&SET ***************************************************/

	
	public List<Habilidad> getHabilidades() {
		return habilidades;
	}

	public String getNombre() {
		return null;
	}

	/* EQUALS&HASHCODE ***************************************************/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((habilidades == null) ? 0 : habilidades.hashCode());
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
		Jugador other = (Jugador) obj;
		if (habilidades == null) {
			if (other.habilidades != null)
				return false;
		} else if (!habilidades.equals(other.habilidades))
			return false;
		return true;
	}


	
}
