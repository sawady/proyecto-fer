package model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FormacionStrategyImplTestCase {
	
	@Test
	public void testArmarFormacion(){
		Jugador jug1 = mock(Jugador.class);
		Jugador jug2 = mock(Jugador.class);
		Jugador jug3 = mock(Jugador.class);
		Jugador jug4 = mock(Jugador.class);
		Jugador jug5 = mock(Jugador.class);
		Jugador jug6 = mock(Jugador.class);
		Jugador jug7 = mock(Jugador.class);
		
		when(jug1.getValorHabilidad(Posicion.ARQUERO)).thenReturn(31);
		when(jug2.getValorHabilidad(Posicion.ARQUERO)).thenReturn(20);
		when(jug3.getValorHabilidad(Posicion.ARQUERO)).thenReturn(30);
		when(jug4.getValorHabilidad(Posicion.ARQUERO)).thenReturn(0);
		when(jug5.getValorHabilidad(Posicion.ARQUERO)).thenReturn(0);
		when(jug6.getValorHabilidad(Posicion.ARQUERO)).thenReturn(0);
		when(jug7.getValorHabilidad(Posicion.ARQUERO)).thenReturn(0);
		
		when(jug1.getValorHabilidad(Posicion.ENGANCHE)).thenReturn(200);
		when(jug2.getValorHabilidad(Posicion.ENGANCHE)).thenReturn(101);
		when(jug4.getValorHabilidad(Posicion.ENGANCHE)).thenReturn(102);
		when(jug3.getValorHabilidad(Posicion.ENGANCHE)).thenReturn(0);
		when(jug5.getValorHabilidad(Posicion.ENGANCHE)).thenReturn(0);
		when(jug6.getValorHabilidad(Posicion.ENGANCHE)).thenReturn(0);
		when(jug7.getValorHabilidad(Posicion.ENGANCHE)).thenReturn(0);
		
		when(jug6.getValorHabilidad(Posicion.VOLANTEDEFENSIVO)).thenReturn(5);
		when(jug2.getValorHabilidad(Posicion.VOLANTEDEFENSIVO)).thenReturn(60);
		when(jug3.getValorHabilidad(Posicion.VOLANTEDEFENSIVO)).thenReturn(61);
		when(jug1.getValorHabilidad(Posicion.VOLANTEDEFENSIVO)).thenReturn(0);
		when(jug4.getValorHabilidad(Posicion.VOLANTEDEFENSIVO)).thenReturn(0);
		when(jug5.getValorHabilidad(Posicion.VOLANTEDEFENSIVO)).thenReturn(0);
		when(jug7.getValorHabilidad(Posicion.VOLANTEDEFENSIVO)).thenReturn(0);
		
		
		when(jug6.getValorHabilidad(Posicion.DELANTERO)).thenReturn(5);
		when(jug7.getValorHabilidad(Posicion.DELANTERO)).thenReturn(60);
		when(jug5.getValorHabilidad(Posicion.DELANTERO)).thenReturn(61);
		when(jug1.getValorHabilidad(Posicion.DELANTERO)).thenReturn(0);
		when(jug2.getValorHabilidad(Posicion.DELANTERO)).thenReturn(0);
		when(jug3.getValorHabilidad(Posicion.DELANTERO)).thenReturn(0);
		when(jug4.getValorHabilidad(Posicion.DELANTERO)).thenReturn(0);
		
		List<Titular> titularesDeseados = new ArrayList<Titular>();
		titularesDeseados.add(new Titular(jug1, Posicion.ARQUERO));
		titularesDeseados.add(new Titular(jug2, Posicion.VOLANTEDEFENSIVO));
		titularesDeseados.add(new Titular(jug3, Posicion.VOLANTEDEFENSIVO));
		titularesDeseados.add(new Titular(jug4, Posicion.ENGANCHE));
		titularesDeseados.add(new Titular(jug5, Posicion.DELANTERO));
		
		List<Jugador> suplentesDeseados = new ArrayList<Jugador>();
		suplentesDeseados.add(jug6);
		suplentesDeseados.add(jug7);
		
		List<Jugador> listaJug = new ArrayList<Jugador>();
		listaJug.add(jug1);
		listaJug.add(jug2);
		listaJug.add(jug3);
		listaJug.add(jug4);
		listaJug.add(jug5);
		listaJug.add(jug6);
		listaJug.add(jug7);
		
		List<Posicion> listaPos = new ArrayList<Posicion>();
		listaPos.add(Posicion.ARQUERO);
		listaPos.add(Posicion.VOLANTEDEFENSIVO);
		listaPos.add(Posicion.VOLANTEDEFENSIVO);
		listaPos.add(Posicion.ENGANCHE);
		listaPos.add(Posicion.DELANTERO);
		
		Equipo mockEquipo = mock(Equipo.class);
		when(mockEquipo.getJugadores()).thenReturn(listaJug);
		
		FormacionStrategy formStrat = new FormacionStrategyImpl(listaPos);
		
		Formacion resultado = formStrat.armarFormacion(mockEquipo);
		
		assertTrue(resultado.getTitulares().containsAll(titularesDeseados));
		assertTrue(resultado.getSuplentes().containsAll(suplentesDeseados));
		assertEquals(resultado.getEquipo(), mockEquipo);
		
	}

}
