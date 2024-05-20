package com.chema.testbackendjr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chema.testbackendjr.interfaces.TipoCurso;
import com.chema.testbackendjr.jpa.entities.Curso;
import com.chema.testbackendjr.jpa.repositories.CursoRepositorio;

@Service
public class CursoServicio {

	@Autowired
	private CursoRepositorio cursoRepositorio;
	
	public List<Curso> obtenerListaCurso() {
		return cursoRepositorio.findAll();		
	}

	public Curso crearCurso(String nombre, TipoCurso tipoCurso) {
		Curso curso = new Curso();
		curso.setNombre(nombre);
		curso.setTipoCurso(tipoCurso);
		cursoRepositorio.save(curso);
		return curso;
	}
	
	public Curso actualizarCurso(Integer id, String nombre, TipoCurso tipoCurso) throws Exception {
		Optional<Curso> cursoOpt = cursoRepositorio.findById(id);
		
		if(cursoOpt.isPresent()) {
			Curso curso = cursoOpt.get();
			curso.setNombre(nombre);
			curso.setTipoCurso(tipoCurso);
			cursoRepositorio.save(curso);
			return curso;
		}else {
			throw new Exception("No existe curso con ese ID");
		}
	}
	
}
