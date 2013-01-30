package model.entities;

import java.util.ArrayList;
import java.util.List;


public class SistemaEntities {
	public List<Class<?>> getEntities(){
		List<Class<?>> result = new ArrayList<Class<?>>();
		
		result.add(CamposParaCalculoAnual.class);
		result.add(DeduccionA.class);
		result.add(DeduccionB.class);
		result.add(DeduccionC.class);
		result.add(Empleado.class);
		result.add(ResultadoDeCalculo.class);
		result.add(TopeSalarial.class);
		return result;
	}

}
