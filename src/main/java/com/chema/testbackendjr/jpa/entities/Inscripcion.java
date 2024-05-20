package com.chema.testbackendjr.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table( name = "Inscripciones" )
public class Inscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn( name = "id_alumno" )
	private Alumno alumno;
	
	@ManyToOne
	@JoinColumn( name = "id_curso" )
	private Curso curso;
	
	@Min(value = 0, message = "La calificacion debe ser mayor o igual a 0")
	@Max(value = 10, message = "La calificacion debe ser menor o igual a 10")
	private Integer calificacion;
	
	@Min(value = 0, message = "La asistencia debe ser mayor o igual a 0")
	@Max(value = 100, message = "La asistencia debe ser menor o igual a 100")
	private Integer asistencias;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}
	
	
}
