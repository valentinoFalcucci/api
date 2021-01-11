package com.spring.Api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.Api.dao.ILenguajeDao;
import com.spring.Api.entity.Lenguaje;

@Service
public class LenguajeServiceImp  implements ILenguajeService{

	@Autowired
	private ILenguajeDao lenguajeDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Lenguaje> findAll() {
	 
		List<Lenguaje> lista=new ArrayList();
		lista=(List<Lenguaje>)lenguajeDao.findAll();
		return lista;
	}

	@Override
	public void saveLenguaje(Lenguaje lenguaje) {
		 lenguajeDao.save(lenguaje);
	}

	 

	@Override
	@Transactional(readOnly = true)
	public Lenguaje findLenguajeById(Long id) {
		// TODO Auto-generated method stub
		return lenguajeDao.findByIdSQL(id);
	}

}
