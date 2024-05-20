package com.chema.testbackendjr.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chema.testbackendjr.interfaces.AlumnosEstatus;
import com.chema.testbackendjr.jpa.entities.Inscripcion;
import com.chema.testbackendjr.services.AlumnoServicio;
import com.chema.testbackendjr.services.InscripcionServicio;

@RestController
@RequestMapping("/alumnos")
public class AlumnoControlador {
	
	@Autowired
	private AlumnoServicio alumnoServicio;
	
	@Autowired
	private InscripcionServicio inscripcionServicio;
	
	
}
