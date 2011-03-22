package model;

import java.util.List;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class EquipoTestCase {
	
	@Test
	public void delegacionDelArmadoDeFormacion(){
		Tecnico mockTecnico   = mock(Tecnico.class);
		List<Jugador> mockJugadores = mock(List.class);
		Equipo eq = new Equipo(mockJugadores,mockTecnico);
		eq.armarFormacion();
		verify(mockTecnico).armarFormacion(eq);
	}
	

}
