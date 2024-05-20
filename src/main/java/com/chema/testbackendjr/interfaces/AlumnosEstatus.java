package com.chema.testbackendjr.interfaces;

public class AlumnosEstatus {
	
	private String nombre;
	private boolean estaAprobado;
	
	public AlumnosEstatus(String nombre, boolean aprobado) {
		super();
		this.nombre = nombre;
		this.estaAprobado = aprobado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isAprobado() {
		return estaAprobado;
	}
	public void setAprobado(boolean aprobado) {
		this.estaAprobado = aprobado;
	}
	
	@Override
	public String toString() {
		return "Alumno:" + nombre + ", Resultado: " + estaAprobado;
	}
	
}
