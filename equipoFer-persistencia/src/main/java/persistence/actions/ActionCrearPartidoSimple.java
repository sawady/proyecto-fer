package persistence.actions;

import java.util.Date;
import java.util.Random;

import model.Equipo;
import model.MyDate;
import model.PartidoSimple;
import persistence.hibernate.HibernateApplication;
import appModel.Home;

public class ActionCrearPartidoSimple implements Action {
	
	/* VARIABLES*************************************************************************/
	private String eq1, eq2;
	private Random r = new Random();
	private Date fecha;

	/* CONSTRUCTOR*************************************************************************/
	public ActionCrearPartidoSimple(String nombre1, String nombre2, String fecha) {
		super();
		this.eq1 = nombre1;
		this.eq2 = nombre2;
		this.fecha= new MyDate(fecha).getFechaYHora();
	}

	
	/*METODOS *************************************************************************/
	public void execute() {
		
		final HibernateApplication application = HibernateApplication.getInstance();
		
		Home<Equipo> homeEquipo = application.getHome(Equipo.class);
		
		Equipo A = homeEquipo.getNombrable(this.eq1);
		Equipo B = homeEquipo.getNombrable(this.eq2);
		
		//genero cantidad de goles aleatoria
		PartidoSimple partido = new PartidoSimple(A, this.r.nextInt(6) , B, this.r.nextInt(6), this.fecha);	
		
		application.getHome(PartidoSimple.class).agregar(partido);
	}

}
