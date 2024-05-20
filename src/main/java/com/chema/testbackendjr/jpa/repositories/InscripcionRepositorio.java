package com.chema.testbackendjr.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chema.testbackendjr.jpa.entities.Inscripcion;

public interface InscripcionRepositorio extends JpaRepository<Inscripcion, Integer>{
	List<Inscripcion> findByCursoId(int cursoId);
}
