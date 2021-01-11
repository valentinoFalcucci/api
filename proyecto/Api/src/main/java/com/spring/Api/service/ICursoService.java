package com.spring.Api.service;

import java.util.List;

import com.spring.Api.entity.Curso;

public interface ICursoService {

	public List<Curso> findAll();
	
	public void saveCurso(Curso curso);
	
	public List<Curso> getCursosProfesor(Long id);
	
}
