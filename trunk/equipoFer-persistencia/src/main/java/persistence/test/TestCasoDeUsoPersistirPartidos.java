package persistence.test;

import persistence.actions.ActionCrearEquipo;
import persistence.actions.ActionPartidoDeCopaBocaVsRiver;
import persistence.actions.ActionPartidosSimplesBocaVsRiver;
import persistence.hibernate.HibernateApplication;

public class TestCasoDeUsoPersistirPartidos {

	public static void main(String[] args) {
		final HibernateApplication application = HibernateApplication.getInstance();
		
		application.execute(new ActionCrearEquipo("Boca"));
		application.execute(new ActionCrearEquipo("River"));
		
		application.execute(new ActionPartidosSimplesBocaVsRiver());

		application.execute(new ActionPartidoDeCopaBocaVsRiver());

	}
}
