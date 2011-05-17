package persistence.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import model.Equipo;
import model.PartidoDeCopa;
import persistence.hibernate.HibernateApplication;
import appModel.Home;

public class ActionEquiposOrdenadosPorVictorias implements Action {
	
	/* VARIABLES*************************************************************************/
	
	private Map<Equipo, Integer> tabla = new HashMap<Equipo, Integer>();
	private List<Equipo> resultado;

	
	
	/* METODOS*************************************************************************/

	public void execute() {
		
		Home<PartidoDeCopa> homePdC = HibernateApplication.getInstance().getHome(PartidoDeCopa.class);
		Home<Equipo> homeEquipos = HibernateApplication.getInstance().getHome(Equipo.class);
		
		List<PartidoDeCopa> partidosDeCopa = homePdC.getAllEntities();
		for(Equipo equipo : homeEquipos.getAllEntities()){
			this.getTabla().put(equipo, 0);
		}
		List<Entry<Equipo, Integer>> listaAOrdenar = new ArrayList<Entry<Equipo, Integer>>();
		Set<Entry<Equipo, Integer>> entrySet = this.getTabla().entrySet();
	
		for(Entry<Equipo, Integer> asoc : entrySet){
			insertarOrdenado(listaAOrdenar, asoc);
		}
		
		setResultado(new ArrayList<Equipo>());
		
		for(Entry<Equipo, Integer> asoc : listaAOrdenar){
			getResultado().add(asoc.getKey());
		}
		
	}
	
	private void insertarOrdenado(List<Entry<Equipo,Integer>> lista, Entry<Equipo,Integer> elem){

		
		int i = 0;
		while (i < lista.size() && lista.get(i).getValue() < elem.getValue()){
			i++;

		for(Entry<Equipo, Integer> asoc : this.getTabla().entrySet()){		

		}
		lista.add(i, elem);}
		
	}
	
	/* gET&SET*************************************************************************/
	private Map<Equipo, Integer> getTabla() {
		return tabla;
	}

	private void setResultado(List<Equipo> resultado) {
		this.resultado = resultado;
	}

	private List<Equipo> getResultado() {
		return resultado;
	}

}
