package model.formaciones;

import model.clasesPrincipales.Equipo;
import appModel.Persistible;

public interface FormacionStrategy extends Persistible {
	
	public Formacion armarFormacion(Equipo eq);

}
