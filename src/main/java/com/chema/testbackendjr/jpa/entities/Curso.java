package com.chema.testbackendjr.jpa.entities;

import java.util.ArrayList;
import java.util.List;

import com.chema.testbackendjr.interfaces.TipoCurso;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table( name = "Cursos" )
public class Curso {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String nombre;
	
	@OneToMany(mappedBy = "curso")
	private List<Inscripcion> inscripciones = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private TipoCurso tipoCurso;

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

	public TipoCurso getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(TipoCurso tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	
}
