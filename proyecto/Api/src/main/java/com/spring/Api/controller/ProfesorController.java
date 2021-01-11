package com.spring.Api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Api.entity.Profesor;
import com.spring.Api.mapper.Mapper;
import com.spring.Api.model.MProfesor;
import com.spring.Api.service.IProfesorService;

@RestController
@RequestMapping("/api")
public class ProfesorController {

	@Autowired
	private IProfesorService profesorService;
	
	
	@GetMapping("/profesores")
	@ResponseStatus(HttpStatus.OK)
	public List<Profesor> getProfesores()
	{
		return profesorService.findAll();
	}
	
	
	@PostMapping("/insertar")
	public ResponseEntity<Void> insertarProfesor(@RequestBody Profesor profesor)
	{
		if(profesorService.findProfesor(profesor)==null)
		{
			profesorService.save(profesor);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}else
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		
	}
	
	
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizarProfesor(@PathVariable(value="id")Long id,@RequestBody Profesor profesor)
	{
		Profesor profesorDB=null;
		profesorDB=profesorService.findById(id);
		if(profesorDB!=null) 
		{
			profesorDB.setNombre(profesor.getNombre());
			profesorDB.setEmail(profesor.getEmail());
			profesorService.save(profesorDB);
			return new ResponseEntity<>(profesorDB,HttpStatus.OK);
		}else
			
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminarPersona(@PathVariable(value="id")Long id)
	{
		profesorService.deleteProfesor(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@DeleteMapping("/eliminarTodo")
	public ResponseEntity<Void> eliminarProfesores()
	{
		profesorService.deleteAllProfesor();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	//Actualizar Query
	
	@PutMapping("/actualizarSql")
	public ResponseEntity<?> actualizarProfesorSql(@RequestBody Profesor profesor)
	{
		Profesor profesorDB=null;
		profesorDB=profesorService.findByIdSQL(profesor.getId());
		if(profesorDB!=null) 
		{
			profesorDB.setNombre(profesor.getNombre());
			profesorDB.setEmail(profesor.getEmail());
			profesorService.save(profesorDB);
			return new ResponseEntity<>(profesorDB,HttpStatus.OK);
		}else
			
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	// Borrar método Post 
	
	@PostMapping("/eliminarPost")
	public ResponseEntity<Void> eliminarProfesorPost(@RequestBody Profesor profesor)
	{
		Profesor profesorDB=null;
		profesorDB=profesorService.findByIdSQL(profesor.getId());
		if(profesorDB!=null) 
		{
			profesorService.deleteProfesor(profesorDB); 
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else
			
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	
	//Buscar profesor Post
	
		@PostMapping("/buscarPost")
		public ResponseEntity<?> buscarProfesorPost(@RequestBody Profesor profesor)
		{
			Profesor profesorDB=null;
			profesorDB=profesorService.findProfesor(profesor);
			if(profesorDB!=null) 
			{ 
				return new ResponseEntity<>(profesorDB,HttpStatus.OK);
			}else
				
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	
		
		//Login Profesor  Post
		
//			@PostMapping("/login")
//			public ResponseEntity<?> loginProfesor(@RequestBody Profesor profesor)
//			{
//				Profesor profesorDB=null;
//				profesorDB=profesorService.checkProfesorByLogin(profesor);
//				if(profesorDB!=null) 
//				{ 
//					return new ResponseEntity<>(profesorDB,HttpStatus.OK);
//				}else
//					
//				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//			}
//			
		
		
			//Login MProfesor  Post 
				
			@PostMapping("/login")
			public ResponseEntity<?> loginProfesor(@RequestBody Profesor profesor)
			{
				Profesor profesorDB=null;
				profesorDB=profesorService.checkProfesorByLogin(profesor);
				if(profesorDB!=null) 
				{ 
					//lista1
					List<Profesor> listaProfesor=new ArrayList();
					listaProfesor.add(profesorDB);
					//Lista2
					List<MProfesor> listaMProfesor=new ArrayList();
					listaMProfesor=Mapper.lista(listaProfesor);
					return new ResponseEntity<>(listaMProfesor,HttpStatus.OK);
				}else
					
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			
			
}
