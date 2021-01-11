package com.spring.Api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.Api.entity.Curso;

public interface ICursoDao  extends CrudRepository<Curso,Long>{

	public List<Curso>   findByProfesorId(Long profesorId);
	
}
