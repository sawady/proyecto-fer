package model;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class EquipoTestCase {
	
	@Test
	public void delegacionDelArmadoDeFormacion(){
		Tecnico mockTecnico   = mock(Tecnico.class);
		Set<Jugador> mockJugadores = mock(HashSet.class);
		Equipo eq = new Equipo("River", mockJugadores,mockTecnico);
		eq.armarFormacion();
		verify(mockTecnico).armarFormacion(eq);
	}
	

}
