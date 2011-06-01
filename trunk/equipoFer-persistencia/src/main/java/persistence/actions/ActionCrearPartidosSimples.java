package persistence.actions;

import java.util.List;

import model.Equipo;
import model.PartidoSimple;
import appModel.Home;


public class ActionCrearPartidosSimples extends ActionCrearPartidos {
	
	public ActionCrearPartidosSimples(int cantPartidosSimples) {
		super(cantPartidosSimples);
	}

	/*METODOS *************************************************************************/
	public void execute() {
		this.generarRivales();
		
		List<Equipo> rivalesActuales;
		int cantRivales = this.rivales.size();
		PartidoSimple partidoSimple;
		Home<PartidoSimple> home = application.getHome(PartidoSimple.class);
		
		for(int i=0; i <= this.cantPartidos; i++){
			rivalesActuales = this.rivales.get(r.nextInt(cantRivales));
			partidoSimple = new PartidoSimple(rivalesActuales.get(0), r.nextInt(6), rivalesActuales.get(1), r.nextInt(6), this.nuevaFecha());
			home.agregar(partidoSimple);
		}
		

	}

}
