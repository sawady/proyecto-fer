package persistence.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import model.Equipo;
import persistence.hibernate.HibernateApplication;

public abstract class ActionCrearPartidos implements Action {
	
	protected HibernateApplication application = HibernateApplication.getInstance();
	protected List<List<Equipo>> rivales = new ArrayList<List<Equipo>>();
	protected List<Equipo> equipos;
	protected Random r = new Random();
	protected static long contadorDias = 1;
	protected int cantPartidos;
	
	public ActionCrearPartidos(int cantPartidosDeCopa){
		this.cantPartidos = cantPartidosDeCopa;
	}
	
	public abstract void execute();
	
	//genera una fecha para un partido simple y lo guarda en la lista que le corresponde
	protected Date nuevaFecha(){
		Date d = new Date(ActionCrearPartidos.contadorDias*100000);
		ActionCrearPartidos.contadorDias += 864;
		return d;
	}
	
	/* METODOS*************************************************************************/
	//genera los equipos rivales para un partido simple, verificando que no sea contra Él mismo
	protected void generarRivales(){
		equipos = application.getHome(Equipo.class).getAllEntities();
		ArrayList<Equipo> temporal;
		for(Equipo eq1 : equipos){
			for(Equipo eq2 : equipos){
				if(!eq1.equals(eq2)){
					temporal = new ArrayList<Equipo>();
					temporal.add(eq1);
					temporal.add(eq2);
					rivales.add(temporal);
				}
			}
		}
	}

}
