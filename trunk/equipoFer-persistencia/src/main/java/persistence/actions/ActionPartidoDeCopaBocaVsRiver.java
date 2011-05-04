package persistence.actions;

import model.Equipo;
import model.MyDate;
import model.PartidoDeCopa;
import model.PartidoSimple;
import persistence.hibernate.HibernateApplication;
import persistence.hibernate.HibernatePartidoSimpleHome;
import appModel.Home;

public class ActionPartidoDeCopaBocaVsRiver implements Action {
	


		public void execute() {
			
			final HibernateApplication application = HibernateApplication.getInstance();
			Home<Equipo> homeEquipo = application.getHome(Equipo.class);
			
			HibernatePartidoSimpleHome partidoSimpleHome = (HibernatePartidoSimpleHome) application.getHome(PartidoSimple.class);
			
			PartidoSimple bocaVsRiver1 = partidoSimpleHome.getByFecha(new MyDate("21/03/2010 10:30").getFechaYHora());
			PartidoSimple bocaVsRiver2 = partidoSimpleHome.getByFecha(new MyDate("22/03/2010 4:30").getFechaYHora());
			
			PartidoDeCopa bocaVsRiver = new PartidoDeCopa(0, 0, bocaVsRiver1, bocaVsRiver2, bocaVsRiver1.getEquipo1(), bocaVsRiver1.getEquipo2());
			
			application.getHome(PartidoDeCopa.class).agregar(bocaVsRiver);
		}
		
	}
