package com.spring.Api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Api.entity.Curso;
import com.spring.Api.entity.Profesor;
import com.spring.Api.service.ICursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {

		@Autowired
		private ICursoService cursoService;

	
	// Listar cursos
	@GetMapping("/cursos")
	public ResponseEntity<?> listarCursos() {
		List<Curso> listaCursos = new ArrayList();
		listaCursos = cursoService.findAll();
		if (listaCursos != null) {
			if (listaCursos.size() != 0) {
				return new ResponseEntity<>(listaCursos, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}

		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Crear curso
	@PostMapping("/insertarCurso")
	public ResponseEntity<?> insertarCurso(@RequestBody Curso curso)
	{
		cursoService.saveCurso(curso);		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	//Listar Curso por profesor
	@PostMapping("/listarCursosProfesor")
	public ResponseEntity<?> listarCursosProfesor(@RequestBody Profesor profesor)
	{
		List<Curso> listaCursos = new ArrayList();
		listaCursos = cursoService.getCursosProfesor(profesor.getId());
		if (listaCursos != null) {
			if (listaCursos.size() != 0) {
				return new ResponseEntity<>(listaCursos, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}

		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}

}
