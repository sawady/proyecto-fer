package model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Jugador;

import org.junit.Test;

public class JugadorTestCase {
	
	@Test
	public void testGetValorHabilidadCuandoLaHabilidadEsta(){
		Habilidad mockHab1 = mock(Habilidad.class);
		Habilidad mockHab2 = mock(Habilidad.class);
		Habilidad mockHab3 = mock(Habilidad.class);
		
		when(mockHab1.getValor(Posicion.ARQUERO)).thenReturn(10);
		when(mockHab2.getValor(Posicion.CENTRAL)).thenReturn(20);
		when(mockHab3.getValor(Posicion.DELANTERO)).thenReturn(30);

		Set<Habilidad> listaHab = new HashSet<Habilidad>();
		listaHab.add(mockHab1);
		listaHab.add(mockHab2);
		listaHab.add(mockHab3);
		
		Jugador j = new Jugador(listaHab, "pepe");
		assertEquals(j.getValorHabilidad(Posicion.ARQUERO),10);
		assertEquals(j.getValorHabilidad(Posicion.CENTRAL),20);
		assertEquals(j.getValorHabilidad(Posicion.DELANTERO),30);
	}
	
	public void testGetValorHabilidadCuandoLaHabilidadNoEsta(){
		Set<Habilidad> listaHabVacia = new HashSet<Habilidad>();
		Jugador j = new Jugador(listaHabVacia, "juan");
		assertEquals(j.getValorHabilidad(Posicion.ARQUERO),0);
		assertEquals(j.getValorHabilidad(Posicion.CENTRAL),0);
		assertEquals(j.getValorHabilidad(Posicion.DELANTERO),0);
	}

}
