package com.krakedev.artesanal.test.JUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {

	@Test
	public void testRecargaExitosa() {
		Maquina rubia = new Maquina("M001", "Pilsener", "cerveza", 0.02, 8000);
		boolean resultado = rubia.recargarCerveza(3000);
		assertTrue(resultado);
		assertEquals(3000, rubia.getCantidadActual(), 0.0001);
	}

	
	@Test
	public void testRecargaFallidaPorDesborde() {
		Maquina negra = new Maquina("M002", "Club", "cerveza fría", 0.03, 8000);
		negra.recargarCerveza(7000);
		boolean resultado = negra.recargarCerveza(1000);
		assertTrue(!resultado);
		assertEquals(7000, negra.getCantidadActual(), 0.0001);
	}

}