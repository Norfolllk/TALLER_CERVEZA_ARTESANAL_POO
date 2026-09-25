package com.krakedev.artesanal.test.Negocio;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestNegocio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Maquina nueva = new Maquina("M003", "Cerveza club", "Cerveza fria", 0.02, 8000);
		Negocio negocio1 = new Negocio("Oasis del Barril", nueva);

		System.out.println("Nombre : " + negocio1.getNombre());
		System.out.println("Maquina : " + negocio1.getMaquinaA());

		Maquina m1 = negocio1.getMaquinaA();
		double capacidad = m1.getCapacidadMaxima();
		System.out.println("Capacidad : " + capacidad);
	}
}