package model;

import java.util.List;

public class Jugador implements Nombrable{
	
	/* VARIABLES ***************************************************/
	
	private List<Habilidad> habilidades;
	
	/* CONSTRUSTOR ***************************************************/
	
	public Jugador(List<Habilidad> habilidades) {
		super();
		this.habilidades = habilidades;
	}
	
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

	
}
