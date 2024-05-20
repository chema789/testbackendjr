package com.chema.testbackendjr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chema.testbackendjr.interfaces.TipoCurso;
import com.chema.testbackendjr.jpa.entities.Alumno;
import com.chema.testbackendjr.jpa.entities.Curso;
import com.chema.testbackendjr.jpa.entities.Inscripcion;
import com.chema.testbackendjr.jpa.repositories.AlumnoRepositorio;
import com.chema.testbackendjr.jpa.repositories.CursoRepositorio;
import com.chema.testbackendjr.jpa.repositories.InscripcionRepositorio;

@Service
public class InscripcionServicio {

	@Autowired
	private AlumnoRepositorio alumnoRepositorio;
	
	@Autowired
	private CursoRepositorio cursoRepositorio;
	
	@Autowired
	private InscripcionRepositorio inscripcionRepositorio;
	
	public void inscribirAlumnoACurso(Integer alumnoId, Integer cursoId, Integer calificacion, Integer asistencias) throws Exception {
		Optional<Alumno> alumnoOpt = alumnoRepositorio.findById(alumnoId);
		Optional<Curso> cursoOpt = cursoRepositorio.findById(cursoId);
		
		if(alumnoOpt.isPresent() && cursoOpt.isPresent()) {
			Inscripcion inscripcion = new Inscripcion();
			inscripcion.setAlumno(alumnoOpt.get());
			inscripcion.setCurso(cursoOpt.get());
			
			switch(cursoOpt.get().getTipoCurso()) {
				case CALIFICACION:
					if(calificacion != null)
						inscripcion.setCalificacion(calificacion);
					else
						throw new Exception("Favor de ingresar la calificacion");;
					break;
				case ASISTENCIA:
					if(asistencias != null)
						inscripcion.setAsistencias(asistencias);
					else
						throw new Exception("Favor de ingresar las asistencias");
					break;
				case MIXTO:
					if(calificacion != null && asistencias != null) {
						inscripcion.setCalificacion(calificacion);
						inscripcion.setAsistencias(asistencias);						
					}else
						throw new Exception("Favor de ingresar las asistencias y la calificacion");
					break;
			}
			inscripcionRepositorio.save(inscripcion);
		}else {
			throw new Exception("No existe un curso o alumno con ese ID");
		}
	}
	
	public void actualizarInscripcion(Integer inscripcionId, Integer calificacion, Integer asistencias) throws Exception {
		Optional<Inscripcion> inscripcionOpt = inscripcionRepositorio.findById(inscripcionId);

        if (inscripcionOpt.isPresent()) {
        	Inscripcion inscripcion = inscripcionOpt.get();
        	
        	Optional<Curso> cursoOpt = cursoRepositorio.findById(inscripcion.getCurso().getId());
        	
        	switch(cursoOpt.get().getTipoCurso()) {
			case CALIFICACION:
				if(calificacion != null)
					inscripcion.setCalificacion(calificacion);
				else
					throw new Exception("Favor de ingresar la calificacion");;
				break;
			case ASISTENCIA:
				if(asistencias != null)
					inscripcion.setAsistencias(asistencias);
				else
					throw new Exception("Favor de ingresar las asistencias");
				break;
			case MIXTO:
				if(calificacion != null && asistencias != null) {
					inscripcion.setCalificacion(calificacion);
					inscripcion.setAsistencias(asistencias);						
				}else
					throw new Exception("Favor de ingresar las asistencias y la calificacion");
				break;
		}
            inscripcionRepositorio.save(inscripcion);
        } else {
            throw new RuntimeException("No existe una inscripcion con ese ID");
        }
	}
	
	public void eliminarInscripcionPorId(Integer inscripcionId) {
		inscripcionRepositorio.deleteById(inscripcionId);
	}
	
	public List<Inscripcion> consultarInscripcionesPorCurso(Integer cursoId){
		return inscripcionRepositorio.findByCursoId(cursoId);
	}
	
}
