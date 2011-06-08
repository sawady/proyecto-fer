package persistence.actions;

import java.util.Date;
import java.util.List;

import model.Equipo;
import model.PartidoDeCopa;
import model.PartidoSimple;
import appModel.Home;

public class ActionCrearPartidosDeCopa extends ActionCrearPartidos {

	Home<PartidoDeCopa> homePartidoDeCopa = application.getHome(PartidoDeCopa.class);
	
	public ActionCrearPartidosDeCopa(int cantPartidosDeCopa) {
		super(cantPartidosDeCopa);
	}

	private void crearPartidoDeCopa(Date fecha1, Date fecha2,
			Equipo equipo, Equipo equipo2) {
		
		//busco los partidos x fecha
		PartidoSimple partidoIda = new PartidoSimple(equipo, r.nextInt(6), equipo2, r.nextInt(6), fecha1);
		PartidoSimple partidoVuelta = new PartidoSimple(equipo, r.nextInt(6), equipo2, r.nextInt(6), fecha2);
		
		int golPenalE1;
		int golPenalE2;
		
		// decido a traves de un criterio simple, si el partido de copa poseera goles de penal o no
		if(partidoIda.empataron() && partidoVuelta.empataron()){				
			golPenalE1 = this.r.nextInt(6);
			golPenalE2 = this.r.nextInt(6);
			if(golPenalE1==golPenalE2){
				golPenalE1 +=1; 
			}
		}			
		else{
			golPenalE1 = 0;
			golPenalE2 = 0;
		}
		
		//creo el partido de copa
		PartidoDeCopa partidoDeCopa = new PartidoDeCopa(golPenalE1, golPenalE2, partidoIda, partidoVuelta, equipo, equipo2);
		
		homePartidoDeCopa.agregar(partidoDeCopa);
	}


	public void execute() {		
		this.generarRivales();
		
		List<Equipo> rivalesActuales;
		int cantRivales = this.rivales.size();
		
		for(int i=0; i <= this.cantPartidos; i++){
			rivalesActuales = this.rivales.get(r.nextInt(cantRivales));
			this.crearPartidoDeCopa(this.nuevaFecha(), this.nuevaFecha(), rivalesActuales.get(0), rivalesActuales.get(1));
		}
		
	}


}
