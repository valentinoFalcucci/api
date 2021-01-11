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
import com.spring.Api.entity.Lenguaje;
import com.spring.Api.service.ICursoService;
import com.spring.Api.service.ILenguajeService;

@RestController
@RequestMapping("/lenguaje")
public class LenguajeController {

	
	@Autowired
	private  ILenguajeService lenguajeService;

	
	// Listar cursos
	@GetMapping("/lenguajes")
	public ResponseEntity<?> listarLenguajes() {
		List<Lenguaje> listaLenguajes = new ArrayList();
		listaLenguajes = lenguajeService.findAll();
		if (listaLenguajes != null) {
			if (listaLenguajes.size() != 0) {
				return new ResponseEntity<>(listaLenguajes, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}

		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Crear curso
	@PostMapping("/insertarLenguaje")
	public ResponseEntity<?> insertarLenguaje(@RequestBody Lenguaje lenguaje)
	{
		lenguajeService.saveLenguaje(lenguaje);		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
}
