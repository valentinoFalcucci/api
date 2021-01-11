package com.spring.Api.service;

import java.util.List;

import com.spring.Api.entity.Lenguaje;

public interface ILenguajeService {

	public List<Lenguaje> findAll(); //metodos defino yo 
	
	public void saveLenguaje(Lenguaje lenguaje);
	
	public Lenguaje findLenguajeById(Long id);
	
	
}
