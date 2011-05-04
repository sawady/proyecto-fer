package persistence.test;

import model.Equipo;
import model.MyDate;
import model.PartidoSimple;
import persistence.actions.Action;
import persistence.actions.ActionCrearEquipo;
import persistence.hibernate.HibernateApplication;
import appModel.Home;

public class ActionPersistirPartidosSimple implements Action {

	public void execute() {
		
		final HibernateApplication application = HibernateApplication.getInstance();
		
		Home<Equipo> homeEquipo = application.getHome(Equipo.class);
		
		Equipo boca = homeEquipo.getNombrable("Boca");
		Equipo river = homeEquipo.getNombrable("River");
		
		PartidoSimple bocaVsRiver1 = new PartidoSimple(boca, 3, river, 5, new MyDate("21/03/2010 10:30").getFechaYHora());
		PartidoSimple bocaVsRiver2 = new PartidoSimple(boca, 2, river, 4, new MyDate("22/03/2010 4:30").getFechaYHora());
						
		application.getHome(PartidoSimple.class).agregar(bocaVsRiver1);
		application.getHome(PartidoSimple.class).agregar(bocaVsRiver2);
	}
	
}