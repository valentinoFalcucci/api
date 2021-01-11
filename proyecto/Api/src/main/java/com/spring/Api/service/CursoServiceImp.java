package com.spring.Api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.Api.dao.ICursoDao;
import com.spring.Api.entity.Curso;

@Service
public class CursoServiceImp implements ICursoService{

	@Autowired
	private ICursoDao cursoDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Curso> findAll() {
		 List<Curso> lista=new ArrayList();
		 lista=(List<Curso>)cursoDao.findAll();
		return lista;
	}

	@Override
	public void saveCurso(Curso curso) {
		 cursoDao.save(curso);		
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<Curso> getCursosProfesor(Long id) {
		 List<Curso> lista=new ArrayList();
		 lista=(List<Curso>)cursoDao.findByProfesorId(id);
		return lista;
	}

	
}
