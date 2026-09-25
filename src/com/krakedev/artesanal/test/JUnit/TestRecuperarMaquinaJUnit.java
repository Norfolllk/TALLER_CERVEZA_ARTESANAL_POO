package com.krakedev.artesanal.test.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestRecuperarMaquinaJUnit {

	@Test
	public void testAgregarMaquinaNueva() {
		NegocioMejorado negocio = new NegocioMejorado();
		boolean resultado = negocio.agregarMaquina("Pilsener", "Rubia", 0.02);

		assertTrue(resultado);
		assertEquals(1, negocio.getMaquinas().size());
	}

	@Test
	public void testRecuperarMaquinaExistente() {
		NegocioMejorado negocio = new NegocioMejorado();
		Maquina existente = new Maquina("M-50", "Pilsener", "Rubia", 0.02);
		negocio.getMaquinas().add(existente);
		Maquina encontrada = negocio.recuperarMaquinas("M-50");
		assertNotNull(encontrada);
		assertEquals("Pilsener", encontrada.getNombreCerveza());
	}

	@Test
	public void testRecuperarMaquinaInexistente() {
		NegocioMejorado negocio = new NegocioMejorado();
		Maquina encontrada = negocio.recuperarMaquinas("M-99");
		assertNull(encontrada);
	}
}
