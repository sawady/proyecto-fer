package model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class JugadorTestCase {
	
	@Test
	public void testGetValorHabilidadCuandoLaHabilidadEsta(){
		Habilidad mockHab1 = mock(Habilidad.class);
		Habilidad mockHab2 = mock(Habilidad.class);
		Habilidad mockHab3 = mock(Habilidad.class);
		
		when(mockHab1.getValor(Posicion.ARQUERO)).thenReturn(10);
		when(mockHab2.getValor(Posicion.CENTRAL)).thenReturn(20);
		when(mockHab3.getValor(Posicion.DELANTERO)).thenReturn(30);

		List<Habilidad> listaHab = new ArrayList<Habilidad>();
		listaHab.add(mockHab1);
		listaHab.add(mockHab2);
		listaHab.add(mockHab3);
		
		Jugador j = new Jugador(listaHab);
		assertEquals(j.getValorHabilidad(Posicion.ARQUERO),10);
		assertEquals(j.getValorHabilidad(Posicion.CENTRAL),20);
		assertEquals(j.getValorHabilidad(Posicion.DELANTERO),30);
	}
	
	public void testGetValorHabilidadCuandoLaHabilidadNoEsta(){
		List<Habilidad> listaHabVacia = new ArrayList<Habilidad>();
		Jugador j = new Jugador(listaHabVacia);
		assertEquals(j.getValorHabilidad(Posicion.ARQUERO),0);
		assertEquals(j.getValorHabilidad(Posicion.CENTRAL),0);
		assertEquals(j.getValorHabilidad(Posicion.DELANTERO),0);
	}

}
