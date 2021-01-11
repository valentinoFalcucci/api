package com.spring.Api.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Api.dao.IProfesorDao;
import com.spring.Api.entity.Lenguaje;
import com.spring.Api.entity.Profesor;
import com.spring.Api.model.ProfesorLenguaje;
import com.spring.Api.service.ILenguajeService;
import com.spring.Api.service.IProfesorService;

@RestController
@RequestMapping("/lenguajeProfesor")
public class ProfesorLenguajeController {

	
	@Autowired
	private ILenguajeService lenguajeService;
	
	@Autowired
	private IProfesorService profesorService;
	
	
	//Metodo inserta los lenguajes del profesor  y luego el profesor en la bd
	
	@PostMapping("/insertar")
	public ResponseEntity<?> insertarLenguajesProfesor(@RequestBody ProfesorLenguaje profesorLenguaje)
	{
		Profesor profesorDB=profesorService.findById(profesorLenguaje.getProfesor().getId());
		if(profesorDB!=null)
		{
			Lenguaje lenguaje=lenguajeService.findLenguajeById(profesorLenguaje.getLenguaje().getId());
			profesorDB.addLenguaje(lenguaje);
			profesorService.save(profesorDB);
			
			return new ResponseEntity<Void>(HttpStatus.CREATED);
			
		}else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	
	//Metodo lista los lenguajes del profesor
	
		@PostMapping("/listar")
		public ResponseEntity<?> listarLenguajesProfesor(@RequestBody Profesor profesor)
		{
			Profesor profesorDB=profesorService.findById(profesor.getId());
			if(profesorDB!=null)
			{
				//Collection<Lenguaje> listaLenguaje=(List<Lenguaje>) profesor.getListaLenguajes();  
				List<Lenguaje> listaLenguaje=(List<Lenguaje>) profesorDB.getListaLenguajes(); 
				
				if(listaLenguaje!=null)
				{
					return new ResponseEntity<>(listaLenguaje,HttpStatus.FOUND);
				}else				
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}else
			{
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			 
		}
	
}
