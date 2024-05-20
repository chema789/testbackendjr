package com.chema.testbackendjr.jpa.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table( name = "Alumnos" )
public class Alumno {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nombre;
	
	@OneToMany(mappedBy = "alumno")
	private List<Inscripcion> inscripciones = new ArrayList<>();
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}
	
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + "]";
	}
}
