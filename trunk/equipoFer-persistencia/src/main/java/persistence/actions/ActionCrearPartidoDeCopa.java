package persistence.actions;

import java.util.Random;

import model.Equipo;
import model.MyDate;
import model.PartidoDeCopa;
import model.PartidoSimple;
import persistence.hibernate.HibernateApplication;
import persistence.hibernate.HibernatePartidoSimpleHome;
import appModel.Home;

public class ActionCrearPartidoDeCopa implements Action {
	

	private String fecha1, fecha2;// para buscar los partidos simples x fecha
	
	private int golPenalE1, golPenalE2;//goles x penal de cada equipo 
	private Random r = new Random ();
	
	public ActionCrearPartidoDeCopa(String fecha1, String fecha2) {
		super();
		this.fecha1 = fecha1;
		this.fecha2 = fecha2;
	}

	public void execute() {
			
			final HibernateApplication application = HibernateApplication.getInstance();	
			HibernatePartidoSimpleHome partidoSimpleHome = (HibernatePartidoSimpleHome) application.getHome(PartidoSimple.class);

			//busco los partidos x fecha
			PartidoSimple partidoIda = partidoSimpleHome.getByFecha(new MyDate(this.fecha1).getFechaYHora());
			PartidoSimple partidoVuelta = partidoSimpleHome.getByFecha(new MyDate(this.fecha2).getFechaYHora());
			
			// decido a traves de un criterio simple, si el partido de copa poseera goles de penal o no
			if (( this.r.nextInt(50) % 2)==0){
				this.golPenalE1 = this.r.nextInt(6);
				this.golPenalE2 = this.r.nextInt(6);
			}
			else{
				this.golPenalE1 = 0;
				this.golPenalE2 = 0;
			}
			
			//creo el partido de copa
			PartidoDeCopa partidoDeCopa = new PartidoDeCopa(this.golPenalE1, this.golPenalE2, partidoIda, partidoVuelta, partidoIda.getEquipo1(), partidoIda.getEquipo2());
			
			//agrego el partido de copa a la home
			application.getHome(PartidoDeCopa.class).agregar(partidoDeCopa);
		}
		
	}
