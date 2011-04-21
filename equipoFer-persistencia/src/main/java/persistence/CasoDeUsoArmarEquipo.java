package persistence;

public class CasoDeUsoArmarEquipo {
	public static void main(String[] args) {
		HibernateApplication.getInstance().execute(new AccionCrearEquipo());;
		AccionBuscarEquipo busqueda = new AccionBuscarEquipo("River");
		HibernateApplication.getInstance().execute(busqueda);
		HibernateApplication.getInstance().execute(new ActionArmarFormacionDeEquipo(busqueda.getEquipo()));

		
		
	}
}