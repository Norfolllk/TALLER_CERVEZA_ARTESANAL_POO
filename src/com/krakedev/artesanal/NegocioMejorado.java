package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {

	private ArrayList<Maquina> maquinas;

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
		Maquina nueva = new Maquina(codigo, nombreCerveza, descripcion, precioPorMl);
		maquinas.add(nueva);
		return true;
	}
	
	public void cargarMaquinas() {
		for (int i = 0; i < maquinas.size(); i++) {
			Maquina maquina = maquinas.get(i);
			maquina.llenarMaquina();
		}
	}
	
	public Maquina recuperarMaquinas(String codigo) {
		for (int i = 0; i < maquinas.size(); i++) {
			Maquina maquina = maquinas.get(i);
			if (maquina.getCodigo().equals(codigo)) {
				return maquina;
			}
		}
		return null;
	}
}