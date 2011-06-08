package model;

import appModel.Persistible;

public interface FormacionStrategy extends Persistible {
	
	public Formacion armarFormacion(Equipo eq);

}
