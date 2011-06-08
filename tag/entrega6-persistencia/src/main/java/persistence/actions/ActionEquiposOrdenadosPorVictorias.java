package persistence.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import model.Equipo;
import model.PartidoSimple;
import persistence.hibernate.HibernateApplication;
import persistence.hibernate.HibernateEquipoHome;
import appModel.Home;

public class ActionEquiposOrdenadosPorVictorias implements Action {
	
	/* VARIABLES*************************************************************************/
	
	private Map<Equipo, Integer> tabla = new HashMap<Equipo, Integer>();
	private List<Equipo> resultado;

	
	
	/* METODOS*************************************************************************/

/* Vieja Forma
	public void execute() {
		
		Home<PartidoSimple> homePS = HibernateApplication.getInstance().getHome(PartidoSimple.class);
		Home<Equipo> homeEquipos = HibernateApplication.getInstance().getHome(Equipo.class);
		
		List<PartidoSimple> partidosSimples = homePS.getAllEntities();
		
		for(Equipo equipo : homeEquipos.getAllEntities()){
			this.getTabla().put(equipo, 0);
		}
		
		for(PartidoSimple psimple : partidosSimples){
			Equipo ganador = psimple.getGanador();
			if(ganador != null){
				this.getTabla().put(ganador, this.getTabla().get(ganador) + 1);
			}
		}
		
		List<Entry<Equipo, Integer>> listaAOrdenar = new ArrayList<Entry<Equipo, Integer>>();
		Set<Entry<Equipo, Integer>> entrySet = this.getTabla().entrySet();
	
		for(Entry<Equipo, Integer> asoc : entrySet){
			insertarOrdenado(listaAOrdenar, asoc);
		}
		
		setResultado(new ArrayList<Equipo>());
		
		for(Entry<Equipo, Integer> asoc : listaAOrdenar){
			getResultado().add(0, asoc.getKey());
		}
		
		this.imprimirResultados();
		
	}
	

	private void insertarOrdenado(List<Entry<Equipo,Integer>> lista, Entry<Equipo,Integer> elem){

		int i = 0;
		while (i < lista.size() && lista.get(i).getValue() < elem.getValue()){
			i++;
		}
		lista.add(i, elem);
		
	}
*/
	
	public void execute() {
		
		HibernateEquipoHome homeEquipos = (HibernateEquipoHome) HibernateApplication.getInstance().getHome(Equipo.class);
		
		this.setResultado(homeEquipos.getEquiposOrdenadosPorVictorias());
		
		this.imprimirResultados();
		
	};
	
	private void imprimirResultados() {
		System.out.println("Los equipos ordenados por victorias son:");
		
		for(Equipo eq : this.getResultado()){
			System.out.println("- " + eq.getNombre() + " con " + 
					eq.getCantVictorias() + " victorias");
		}
		
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
