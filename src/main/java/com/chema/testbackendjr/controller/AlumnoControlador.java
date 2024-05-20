package com.chema.testbackendjr.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
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

import com.chema.testbackendjr.jpa.entities.Alumno;
import com.chema.testbackendjr.services.AlumnoServicio;
import com.chema.testbackendjr.services.InscripcionServicio;

@RestController
@RequestMapping("/alumnos")
public class AlumnoControlador {
	
	@Autowired
	private AlumnoServicio alumnoServicio;
	
	@GetMapping("/")
	public List<Alumno> obtenerAlumnos(){
		return alumnoServicio.obtenerListaAlumno();
	}
	
	@PostMapping("/")
	public ResponseEntity<String> agregarAlumno(@RequestParam(required = true) String nombre){
		Alumno alumno = alumnoServicio.crearAlumno(nombre);
		return ResponseEntity.ok("Alumno creado exitosamente: " + alumno);
	}
	
	@PutMapping("/{idAlumno}/")
	public ResponseEntity<String> actualizarAlumno(@PathVariable Integer idAlumno, @RequestParam(required = true) String nombre){
		try {
			Alumno alumno = alumnoServicio.actualizarAlumno(idAlumno, nombre);
			return ResponseEntity.ok("Alumno actualizado exitosamente: " + alumno);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Actualizacion fallida: " + e.getMessage());
		}
	}
	
}
