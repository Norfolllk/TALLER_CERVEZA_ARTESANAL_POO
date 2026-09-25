package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {

	private ArrayList<Maquina> maquinas;
	private ArrayList<Cliente> clientes;
	private int ultimoCodigo = 100;

	public NegocioMejorado() {
		this.maquinas = new ArrayList<Maquina>();
	}
	
	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;	
	}
	
	public String generarCodigo() {
		int numero = (int) (Math.random() * 100) + 1;
		String codigo = "M-" + numero;
		return codigo;
	}
	
	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
		String codigo = generarCodigo();
		Maquina existente = recuperarMaquina(codigo);
		if (existente == null) {
			Maquina nueva = new Maquina(codigo, nombreCerveza, descripcion, precioPorMl);
			maquinas.add(nueva);
			return true;
		} else {
			return false;
		}
	}
	
	public void cargarMaquinas() {
		for (int i = 0; i < maquinas.size(); i++) {
			Maquina maquina = maquinas.get(i);
			maquina.llenarMaquina();
		}
	}
	
	public Maquina recuperarMaquina(String codigo) {
		for (int i = 0; i < maquinas.size(); i++) {
			Maquina maquina = maquinas.get(i);
			if (maquina.getCodigo().equals(codigo)) {
				return maquina;
			}
		}
		return null;
	}
	
	public void registrarCliente(String nombre, String cedula) {
		Cliente nuevo = new Cliente(nombre, cedula);
		nuevo.setCodigo(ultimoCodigo);
		ultimoCodigo++;
		clientes.add(nuevo);
	}
}