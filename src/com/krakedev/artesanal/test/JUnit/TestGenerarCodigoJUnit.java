package com.krakedev.artesanal.test.JUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.NegocioMejorado;

public class TestGenerarCodigoJUnit {

	@Test
	public void testFormatoCodigo() {
		NegocioMejorado negocio = new NegocioMejorado();
		String codigo = negocio.generarCodigo();
		assertTrue(codigo.startsWith("M-"));
		int numero = Integer.parseInt(codigo.substring(2));
		assertTrue(numero >= 1 && numero <= 100);
	}
}
