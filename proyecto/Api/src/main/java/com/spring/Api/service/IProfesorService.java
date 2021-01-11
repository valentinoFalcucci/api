package com.spring.Api.service;

import java.util.List;
import java.util.Optional;

import com.spring.Api.entity.Profesor;

public interface IProfesorService {

	public List<Profesor> findAll();
	
	public void save(Profesor profesor);
	
	public Profesor findProfesor(Profesor profesor);
	
	public Profesor checkProfesorByLogin(Profesor profesor);
	
	public void deleteProfesor(Profesor profesor);
	
	public Profesor updateProfesor(Profesor profesor);
	
	public Optional<Profesor> findProfesorById(Long id);
	
	public void deleteProfesor(Long id);
	
	public Profesor findById(Long id);
	
	public Profesor findByIdSQL(Long id);
	
	// borrar todos
	public void deleteAllProfesor();
	
}
