package com.krakedev.artesanal.test.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestClientesJUnit {

	@Test
	public void testRegistrarCliente() {
		NegocioMejorado negocio = new NegocioMejorado();
		negocio.registrarCliente("Mario", "123456789");
		assertEquals(1, negocio.getClientes().size());
		assertEquals(100, negocio.getClientes().get(0).getCodigo());
	}

	@Test
	public void testCodigosConsecutivos() {
		NegocioMejorado negocio = new NegocioMejorado();
		negocio.registrarCliente("Mario", "123456789");
		negocio.registrarCliente("Andres", "123456788");
		assertEquals(100, negocio.getClientes().get(0).getCodigo());
		assertEquals(101, negocio.getClientes().get(1).getCodigo());
	}

	@Test
	public void testBuscarClientePorCedulaExistente() {
		NegocioMejorado negocio = new NegocioMejorado();
		negocio.registrarCliente("Mario", "123456789");
		Cliente encontrado = negocio.buscarClientePorCedula("123456789");
		assertNotNull(encontrado);
		assertEquals("Mario", encontrado.getNombre());
	}

	@Test
	public void testBuscarClientePorCedulaInexistente() {
		NegocioMejorado negocio = new NegocioMejorado();
		Cliente encontrado = negocio.buscarClientePorCedula("000000000");
		assertNull(encontrado);
	}

	@Test
	public void testBuscarClientePorCodigoExistente() {

		NegocioMejorado negocio = new NegocioMejorado();
		negocio.registrarCliente("Mario", "123456789");
		Cliente encontrado = negocio.buscarClientePorCodigo(100);
		assertNotNull(encontrado);
		assertEquals("Mario", encontrado.getNombre());
	}

	@Test
	public void testBuscarClientePorCodigoInexistente() {
		NegocioMejorado negocio = new NegocioMejorado();
		Cliente encontrado = negocio.buscarClientePorCodigo(999);
		assertNull(encontrado);
	}

}
