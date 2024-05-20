package com.chema.testbackendjr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chema.testbackendjr.interfaces.TipoCurso;
import com.chema.testbackendjr.jpa.entities.Alumno;
import com.chema.testbackendjr.jpa.entities.Curso;
import com.chema.testbackendjr.services.AlumnoServicio;
import com.chema.testbackendjr.services.CursoServicio;

@RestController
@RequestMapping("/cursos")
public class CursoControlador {

	
	@Autowired
	private CursoServicio cursoServicio;
	
	@GetMapping("/")
	public List<Curso> obtenerCursos(){
		return cursoServicio.obtenerListaCurso();
	}
	
	@PostMapping("/")
	public ResponseEntity<String> agregarCurso(@RequestParam(required = true) String nombre, @RequestParam(required = true) TipoCurso tipoCurso){
		Curso curso = cursoServicio.crearCurso(nombre, tipoCurso);
		return ResponseEntity.ok("Curso creado exitosamente: " + curso);
	}
	
	@PutMapping("/{idCurso}/")
	public ResponseEntity<String> actualizarCurso(@PathVariable Integer idCurso, @RequestParam(required = true) String nombre, @RequestParam(required = true) TipoCurso tipoCurso){
		try {
			Curso curso = cursoServicio.actualizarCurso(idCurso, nombre, tipoCurso);
			return ResponseEntity.ok("Curso actualizado exitosamente: " + curso);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Actualizacion fallida: " + e.getMessage());
		}
	}
	
}
