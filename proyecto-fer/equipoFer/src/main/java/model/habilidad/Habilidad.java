package model.habilidad;

import model.util.Posicion;
import appModel.Persistible;

public interface Habilidad extends Persistible{
	
	public int getValor(Posicion pos);

}
