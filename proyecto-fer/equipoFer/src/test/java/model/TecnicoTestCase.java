package model;

import model.clasesPrincipales.Equipo;
import model.clasesPrincipales.Tecnico;
import model.formaciones.FormacionStrategy;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class TecnicoTestCase {
	
	@Test
	public void delegacionDelArmadoDeFormacion(){
		FormacionStrategy mockFormacionStrategy   = mock(FormacionStrategy.class);
		Equipo mockEquipo = mock(Equipo.class);
		Tecnico tec = new Tecnico("Juan", mockFormacionStrategy);
		tec.armarFormacion(mockEquipo);
		verify(mockFormacionStrategy).armarFormacion(mockEquipo);
	}
}
