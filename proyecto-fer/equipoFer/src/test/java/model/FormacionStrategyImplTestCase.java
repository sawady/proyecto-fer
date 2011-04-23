package model;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.clasesPrincipales.Equipo;
import model.clasesPrincipales.Jugador;
import model.clasesPrincipales.Titular;
import model.formaciones.Formacion;
import model.formaciones.FormacionStrategy;
import model.formaciones.FormacionStrategyImpl;
import model.util.Posicion;

import org.junit.Test;

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
		
		
		Set<Jugador> listaJug = new HashSet<Jugador>();
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
		
		Set<Jugador> suplentesDeseados = new HashSet<Jugador>();
		suplentesDeseados.add(jug6);
		suplentesDeseados.add(jug7);
		
		Formacion resultado = formStrat.armarFormacion(mockEquipo);
		
		Set<Titular> titularesDeseados = new HashSet<Titular>();
		titularesDeseados.add(new Titular(jug1, Posicion.ARQUERO, resultado));
		titularesDeseados.add(new Titular(jug2, Posicion.VOLANTEDEFENSIVO, resultado));
		titularesDeseados.add(new Titular(jug3, Posicion.VOLANTEDEFENSIVO, resultado));
		titularesDeseados.add(new Titular(jug4, Posicion.ENGANCHE, resultado));
		titularesDeseados.add(new Titular(jug5, Posicion.DELANTERO, resultado));
		
		assertEquals(resultado.getTitulares().size(), 5);
		assertTrue(resultado.getTitulares().containsAll(titularesDeseados));
		assertTrue(resultado.getSuplentes().containsAll(suplentesDeseados));
		assertEquals(resultado.getEquipo(), mockEquipo);
	}

}
