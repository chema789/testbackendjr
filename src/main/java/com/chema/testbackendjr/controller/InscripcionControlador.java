package com.chema.testbackendjr.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.chema.testbackendjr.interfaces.AlumnosEstatus;
import com.chema.testbackendjr.jpa.entities.Inscripcion;
import com.chema.testbackendjr.services.AlumnoServicio;
import com.chema.testbackendjr.services.InscripcionServicio;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionControlador {
	@Autowired
	private AlumnoServicio alumnoServicio;
	
	@Autowired
	private InscripcionServicio inscripcionServicio;
	
	@PostMapping("/alumno/{alumnoId}/curso/{cursoId}")
	public ResponseEntity<String> inscribirAlumno(
			@PathVariable Integer alumnoId, 
			@PathVariable Integer cursoId, 
			@RequestParam(required = false) Integer calificacion,
			@RequestParam(required = false) Integer asistencias) {
		try {
			inscripcionServicio.inscribirAlumnoACurso(alumnoId, cursoId, calificacion, asistencias);
			return ResponseEntity.ok("Inscripcion realizada exitosamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Inscripcion fallida: " + e.getMessage());
		}
	}
	
	@GetMapping("/curso/{cursoId}")
	public List<AlumnosEstatus> obtenerResultadoPorCurso(@PathVariable Integer cursoId){
		List<Inscripcion> inscripciones = inscripcionServicio.consultarInscripcionesPorCurso(cursoId);
		return inscripciones.stream()
				.map( inscripcion -> new AlumnosEstatus(inscripcion.getAlumno().getNombre(), alumnoServicio.estaAprobado(inscripcion)))
				.collect(Collectors.toList());
	}
	
	@PutMapping("/{inscripcionId}")
	public ResponseEntity<String> actualizarInscripcion(
			@PathVariable Integer inscripcionId, 
			@RequestParam(required = false) Integer calificacion,
			@RequestParam(required = false) Integer asistencias){
		try {
			inscripcionServicio.actualizarInscripcion(inscripcionId, calificacion, asistencias);
			return ResponseEntity.ok("Inscripcion actualizada correctamente");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Eliminar inscripcion fallida: " + e.getMessage());
		}
	}
	
	@DeleteMapping("/{inscripcionId}")
	public ResponseEntity<String> eliminarInscripcion(@PathVariable Integer inscripcionId) {
		try {
			inscripcionServicio.eliminarInscripcionPorId(inscripcionId);
			return ResponseEntity.ok("Inscripcion eliminada exitosamente");			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Eliminar inscripcion fallida: " + e.getMessage());
		}
	}
}
