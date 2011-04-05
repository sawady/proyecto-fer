package model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Jugador implements Nombrable{
	
	/* VARIABLES ***************************************************/
	
	private Set<Habilidad> habilidades;
	private String nombre;
	
	/* CONSTRUSTOR ***************************************************/
	
	public Jugador(HashSet<Habilidad> habilidades, String nombre) {
		super();
		this.habilidades = habilidades;
		this.nombre = nombre;
	}
	
	/* METODOS ***************************************************/
	
	public int getValorHabilidad(Posicion pos){
		int result = 0;
		Iterator<Habilidad>it = this.getHabilidades().iterator();
		//recorro el set
		while(it.hasNext()){
			result = max(it.next().getValor(pos),result);
		}
		//ultimo elemento
		result = max(it.next().getValor(pos),result);

		
		return result;
	}
	


	private int max(int v1, int v2) {
		if(v1<=v2)
			return v2;
		else
			return v1;
	}
	/* GET&SET ***************************************************/

	
	public Set<Habilidad> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(HashSet<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	
}
