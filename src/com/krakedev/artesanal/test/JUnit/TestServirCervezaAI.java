package com.krakedev.artesanal.test.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {

	// Margen de error permitido para comparaciones con valores double
	private static final double TOLERANCIA = 0.001;

	// Caso 1: La máquina tiene suficiente cerveza disponible.
	// Se debe servir correctamente, descontar la cantidad servida
	// y retornar el valor a pagar (cantidad * precioPorMl).
	@Test
	public void testServirConSuficienteCerveza() {
		Maquina rubia = new Maquina("M001", "Pilsener", "Cerveza Rubia", 0.02, 10000);
		rubia.recargarCerveza(5000);

		double valorPagar = rubia.servirCerveza(1000);

		assertEquals(20.0, valorPagar, TOLERANCIA);
		assertEquals(4000, rubia.getCantidadActual(), TOLERANCIA);
	}

	// Caso 2: La máquina NO tiene suficiente cerveza disponible.
	// No debe servir nada, no debe modificar la cantidad actual
	// y debe retornar 0.
	@Test
	public void testServirSinSuficienteCerveza() {
		Maquina rubia = new Maquina("M001", "Pilsener", "Cerveza Rubia", 0.02, 10000);
		rubia.recargarCerveza(100);

		double valorPagar = rubia.servirCerveza(500);

		assertEquals(0, valorPagar, TOLERANCIA);
		assertEquals(100, rubia.getCantidadActual(), TOLERANCIA);
	}

	// Caso 3: El cliente sirve exactamente la cantidad disponible.
	// La cantidad actual debe quedar en 0 y debe retornar el valor correcto.
	@Test
	public void testServirCantidadExacta() {
		Maquina rubia = new Maquina("M001", "Pilsener", "Cerveza Rubia", 0.02, 10000);
		rubia.recargarCerveza(1000);

		double valorPagar = rubia.servirCerveza(1000);

		assertEquals(20.0, valorPagar, TOLERANCIA);
		assertEquals(0, rubia.getCantidadActual(), TOLERANCIA);
	}

	// Caso 4: La máquina está vacía (cantidadActual = 0).
	// No debe servir nada, no debe modificar la cantidad y debe retornar 0.
	@Test
	public void testServirMaquinaVacia() {
		Maquina rubia = new Maquina("M001", "Pilsener", "Cerveza Rubia", 0.02, 10000);

		double valorPagar = rubia.servirCerveza(500);

		assertEquals(0, valorPagar, TOLERANCIA);
		assertEquals(0, rubia.getCantidadActual(), TOLERANCIA);
	}

	// Caso 5: Uso del constructor alternativo (sin capacidadMaxima explícita,
	// por defecto 10000). Se sirve correctamente y se valida el valor a pagar.
	@Test
	public void testServirConConstructorAlternativo() {
		Maquina negra = new Maquina("M002", "Club", "Cerveza Negra", 0.03);
		negra.recargarCerveza(2000);

		double valorPagar = negra.servirCerveza(1500);

		assertEquals(45.0, valorPagar, TOLERANCIA);
		assertEquals(500, negra.getCantidadActual(), TOLERANCIA);
	}

	// Caso 6: Servir una cantidad de 0 ml.
	// Debe considerarse un servicio válido (cantidadActual >= 0),
	// no modifica la cantidad actual y retorna 0 como valor a pagar.
	@Test
	public void testServirCantidadCero() {
		Maquina rubia = new Maquina("M001", "Pilsener", "Cerveza Rubia", 0.02, 10000);
		rubia.recargarCerveza(3000);

		double valorPagar = rubia.servirCerveza(0);

		assertEquals(0, valorPagar, TOLERANCIA);
		assertEquals(3000, rubia.getCantidadActual(), TOLERANCIA);
	}

}