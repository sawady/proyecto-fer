package persistence.test;

import model.Equipo;
import model.Partido;
import model.PartidoDeCopa;
import model.PartidoSimple;

import org.joda.time.DateTime;

import persistence.actions.Action;
import persistence.actions.ActionCrearEquipo;
import persistence.hibernate.HibernateApplication;
import appModel.Home;

public class TestCasoDeUsoPersistirPartidos {

	public static void main(String[] args) {
		
		final HibernateApplication application = HibernateApplication.getInstance();
		application.execute(new ActionCrearEquipo("Boca"));
		application.execute(new ActionCrearEquipo("River"));
		
		Home<Equipo> homeEquipo = application.getHome(Equipo.class);
		Equipo boca = homeEquipo.getNombrable("Boca");
		Equipo river = homeEquipo.getNombrable("River");
		
		PartidoSimple bocaVsRiver1 = new PartidoSimple(boca, 3, river, 5, new DateTime());
		PartidoSimple bocaVsRiver2 = new PartidoSimple(boca, 2, river, 4, new DateTime().plusDays(3));
		
		final PartidoDeCopa bocaVsRiver = new PartidoDeCopa(0, 0, bocaVsRiver1, bocaVsRiver2, boca, river);
		
		application.execute(new Action() {
			
			public void execute() {
				application.getHome(Partido.class).agregar(bocaVsRiver);
			}
		});
	}

}
