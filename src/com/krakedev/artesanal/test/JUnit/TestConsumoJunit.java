package com.krakedev.artesanal.test.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestConsumoJunit {

	@Test
	public void testConsumirCerveza() {

		NegocioMejorado negocio = new NegocioMejorado();
		negocio.getMaquinas().add(new Maquina("M-1", "Pilsener", "Rubia", 0.02, 8000));
		negocio.cargarMaquinas();
		negocio.registrarCliente("Mario", "123456789");
		negocio.consumirCerveza(100, "M-1", 1000);
		assertEquals(6800, negocio.recuperarMaquina("M-1").getCantidadActual(), 0.0001);
		assertEquals(20.0, negocio.buscarClientePorCodigo(100).getTotalConsumido(), 0.0001);
	}

	@Test
	public void testConsumoAcumulado() {
		NegocioMejorado negocio = new NegocioMejorado();
		negocio.getMaquinas().add(new Maquina("M-1", "Pilsener", "Rubia", 0.02, 8000));
		negocio.cargarMaquinas();
		negocio.registrarCliente("Mario", "123456789");
		negocio.consumirCerveza(100, "M-1", 1000);
		negocio.consumirCerveza(100, "M-1", 500);
		assertEquals(30.0, negocio.buscarClientePorCodigo(100).getTotalConsumido(), 0.0001);
	}

	@Test
	public void testConsultarValorVendido() {
		NegocioMejorado negocio = new NegocioMejorado();
		negocio.getMaquinas().add(new Maquina("M-1", "Pilsener", "Rubia", 0.02, 8000));
		negocio.cargarMaquinas();
		negocio.registrarCliente("Mario", "123456789");
		negocio.registrarCliente("Andres", "123456788");
		negocio.consumirCerveza(100, "M-1", 1000);
		negocio.consumirCerveza(101, "M-1", 500);
		assertEquals(30.0, negocio.consultarValorVendido(), 0.0001);
	}
}
