package com.chema.testbackendjr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chema.testbackendjr.jpa.entities.Alumno;
import com.chema.testbackendjr.jpa.entities.Curso;
import com.chema.testbackendjr.jpa.entities.Inscripcion;
import com.chema.testbackendjr.jpa.repositories.AlumnoRepositorio;
import com.chema.testbackendjr.jpa.repositories.CursoRepositorio;
import com.chema.testbackendjr.jpa.repositories.InscripcionRepositorio;

@Service
public class AlumnoServicio {

	@Autowired
	private AlumnoRepositorio alumnoRepositorio;
	
	@Autowired
	private CursoRepositorio cursoRepositorio;
	
	@Autowired
	private InscripcionRepositorio inscripcionRepositorio;
	
	public List<Alumno> obtenerListaAlumno() {
		return alumnoRepositorio.findAll();		
	}
	
	public boolean estaAprobado(Inscripcion inscripcion){
		Optional<Curso> curso = cursoRepositorio.findById(inscripcion.getCurso().getId());
		
		if(curso.isPresent()) {
			switch(curso.get().getTipoCurso()) {
			case CALIFICACION:
				return inscripcion.getCalificacion()>=7;
			case ASISTENCIA:
				return inscripcion.getAsistencias()>=80;
			case MIXTO:
				return (inscripcion.getAsistencias()>=80 && inscripcion.getCalificacion()>=7);
			default: 
				return false;
			}
		}
		return false;
	}
}
