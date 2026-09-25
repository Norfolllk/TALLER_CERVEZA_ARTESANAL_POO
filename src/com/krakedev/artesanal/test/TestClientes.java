package com.krakedev.artesanal.test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {

	public static void main(String[] args) {
		NegocioMejorado negocio = new NegocioMejorado();
		negocio.registrarCliente("Mario", "123456789");
	}
}
