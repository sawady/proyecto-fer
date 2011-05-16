package persistence.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.Equipo;
import model.PartidoDeCopa;
import persistence.hibernate.HibernateApplication;
import appModel.Home;

public class ActionEquiposOrdenadosPorVictorias implements Action {
	
	/* VARIABLES*************************************************************************/
	
	private Map<Equipo, Integer> tabla = new HashMap<Equipo, Integer>();
	
	
	/* METODOS*************************************************************************/
	public void execute() {
		
		Home<PartidoDeCopa> home = HibernateApplication.getInstance().getHome(PartidoDeCopa.class);
		Home<Equipo> homeEquipos = HibernateApplication.getInstance().getHome(Equipo.class);
		
		List<PartidoDeCopa> partidosDeCopa = home.getAllEntities();
		for(Equipo equipo : homeEquipos.getAllEntities()){
			this.getTabla().put(equipo, 0);
		}
		List<Equipo> resultado = new ArrayList<Equipo>(); 
		for(Entry<Equipo, Integer> asoc : this.getTabla().entrySet()){		
		}
		
	}
	
	/* gET&SET*************************************************************************/
	private Map<Equipo, Integer> getTabla() {
		return tabla;
	}

}
